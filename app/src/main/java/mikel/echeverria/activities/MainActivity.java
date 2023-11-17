package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busqueda = findViewById(R.id.editTextText);
        realm = Realm.getDefaultInstance();
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        initializeData();

        recyclerDataAdapter = new RecyclerDataAdapter(listaDeElementos, item -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("id",item.getId());
            startActivity(intent);
        });

        recyclerView.setAdapter(recyclerDataAdapter);
    }

    public void filtrarDatos() {
        RealmResults<Card> listaFiltrada = listaDeElementos.where().contains("name", busqueda.getText().toString()).findAll();
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