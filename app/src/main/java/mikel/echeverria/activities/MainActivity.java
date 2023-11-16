package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
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

        realm = Realm.getDefaultInstance();
        // Inicializa tu RecyclerView
        recyclerView = findViewById(R.id.my_recycler_view);

        // Establece el LayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        introducirDatos();


        // Creamos los objetos/items
        recyclerDataAdapter = new RecyclerDataAdapter(listaDeElementos, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Card item) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("id",item.getIdCard());

                startActivity(intent);
            }
        });

        // Establece el adaptador en el RecyclerView
        recyclerView.setAdapter(recyclerDataAdapter);
    }
    //cuando cambiamos la TextView de busqueda se llama a este metodo para filtrar los datos de la lista de elementos
    public void filtrarDatos() {
        listaDeElementos = realm.where(Card.class).findAll();
        realm.commitTransaction();
        RealmResults<Card> listaFiltrada = listaDeElementos.where().contains("name", busqueda.getText().toString()).findAll();
        recyclerDataAdapter.setDataList(listaFiltrada);
        recyclerDataAdapter.notifyDataSetChanged();
    }
    //cuando se inicia la aplicacion se llama a este metodo para introducir los datos en la lista de elementos








    public void introducirDatos() {
        listaDeElementos = realm.where(Card.class).findAll();
        realm.commitTransaction();

        if (listaDeElementos.isEmpty()){

            listaDeElementos = realm.where(Card.class).findAll();
            realm.commitTransaction();
            realm.beginTransaction();

            //creacion de objetos


            // Crear los objetos Card que quieres agregar


            // Agregar los objetos a Realm








            // subirlos a la base de datos

            //realm.copyToRealm(dataList);



            realm.commitTransaction();
            listaDeElementos = realm.where(Card.class).findAll();
            recyclerDataAdapter.setDataList(listaDeElementos);
            recyclerDataAdapter.notifyDataSetChanged();
        }

    }

    public void borrarDatos(){

        realm.beginTransaction();
        RealmResults<Card> results = realm.where(Card.class).findAll();
        results.deleteAllFromRealm();
        realm.commitTransaction();

    }

}