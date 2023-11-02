package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        // Inicializa tu RecyclerView
        recyclerView = findViewById(R.id.my_recycler_view);

        // Establece el LayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Card> dataList = new ArrayList<>();

        // Creamos los objetos/items

        recyclerDataAdapter = new RecyclerDataAdapter(dataList, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, String description) {
                Toast.makeText(MainActivity.this, name + " " + description, Toast.LENGTH_LONG).show();
            }
        });

        // Establece el adaptador en el RecyclerView
        recyclerView.setAdapter(recyclerDataAdapter);
    }





    public void introducirDatos() {
        listaDeElementos = realm.where(Card.class).findAll();
        realm.commitTransaction();

        if (listaDeElementos.isEmpty()){

            listaDeElementos = realm.where(Card.class).findAll();
            realm.commitTransaction();

            //creacion de objetos
            //elemento mago = new elemento("mago","El mago de la corte real, tambien engargado de ayudar al rey con su gran sabiduria",R.drawable._02_wizard,"#c39bd3", "#9b59b6");


            realm.beginTransaction();
            // subirlos a la base de datos
            //realm.copyToRealm(caballero);
            //realm.copyToRealm(mago);

            listaDeElementos = realm.where(Card.class).findAll();
            realm.commitTransaction();
        }

    }


}