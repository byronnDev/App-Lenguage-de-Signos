package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import mikel.echeverria.model.Card;
import mikel.echeverria.R;
import mikel.echeverria.adapters.RecyclerDataAdapter;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    RealmResults<Card> listaDeElementos;
    RecyclerView recyclerView;
    RecyclerDataAdapter recyclerDataAdapter;
    TextView busqueda;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busqueda = findViewById(R.id.editTextText);
        realm = Realm.getDefaultInstance();
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        busqueda.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No es necesario implementar este método para tu caso
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Este método se llama cuando el texto en el EditText cambia
                filtrarDatos(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No es necesario implementar este método para tu caso
            }
        });
        button = findViewById(R.id.btnFiltrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        initializeData();

        recyclerDataAdapter = new RecyclerDataAdapter(listaDeElementos, item -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("id",item.getId());
            startActivity(intent);
        });

        recyclerView.setAdapter(recyclerDataAdapter);
    }

    public void filtrarDatos(String query) {
    RealmResults<Card> listaFiltrada = listaDeElementos.where().contains("name", query).findAll();
    recyclerDataAdapter.setDataList(listaFiltrada);
    recyclerDataAdapter.notifyDataSetChanged();
}

    public void initializeData() {
        listaDeElementos = realm.where(Card.class).findAll();

        if (listaDeElementos.isEmpty()){


            Card card1 = new Card(R.drawable.abajo, "card1", "Casa");
            Card card2 = new Card(R.drawable.abrazar, "card2", "Calendario");
            Card card3 = new Card(R.drawable.aburrido, "card3", "Cuerpo");

            realm.beginTransaction();
            realm.copyToRealm(card1);
            realm.copyToRealm(card2);
            realm.copyToRealm(card3);
            realm.commitTransaction();

            listaDeElementos = realm.where(Card.class).findAll();
        }
    }

    public void deleteData(){
        realm.beginTransaction();
        realm.where(Card.class).findAll().deleteAllFromRealm();
        realm.commitTransaction();
    }
}