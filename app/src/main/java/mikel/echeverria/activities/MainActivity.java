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

import mikel.echeverria.model.Card;
import mikel.echeverria.R;
import mikel.echeverria.adapters.RecyclerDataAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerDataAdapter recyclerDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa tu RecyclerView
        recyclerView = findViewById(R.id.my_recycler_view);

        // Establece el LayoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Card> dataList = new ArrayList<>();

        Context context = getApplicationContext(); // Puedes obtener el contexto de esta manera

        // Creamos los objetos/items
        dataList.add(new Card(R.drawable.image1, "Hello!", R.color.primario, R.color.color_verde_claro)); // Verde
        dataList.add(new Card(R.drawable.image2, "Robot", R.color.color_amarillo, R.color.color_amarillo_claro)); // Amarillo
        dataList.add(new Card(R.drawable.image3, "Vampiro", R.color.color_azul,R.color.color_azul_claro)); // Azul
        dataList.add(new Card(R.drawable.image4, "Duende", R.color.color_rojo,R.color.color_rojo_claro)); // Rojo
        dataList.add(new Card(R.drawable.image5, "Cerebro", R.color.color_marron,R.color.color_marron_claro)); // Marrón
        dataList.add(new Card(R.drawable.image6, "Fuego", R.color.color_morado,R.color.color_morado_claro)); // Morado
        dataList.add(new Card(R.drawable.image1, "Hola!", R.color.color_cian,R.color.color_cian_claro)); // Cian
        dataList.add(new Card(R.drawable.image2, "IA", R.color.color_gris,R.color.color_gris_claro)); // Gris

        recyclerDataAdapter = new RecyclerDataAdapter(dataList, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, String description) {
                Toast.makeText(MainActivity.this, name + " " + description, Toast.LENGTH_LONG).show();
            }
        });

        // Establece el adaptador en el RecyclerView
        recyclerView.setAdapter(recyclerDataAdapter);
    }
}