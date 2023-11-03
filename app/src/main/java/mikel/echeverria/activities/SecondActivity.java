package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import mikel.echeverria.R;
import mikel.echeverria.model.Card;

public class SecondActivity extends AppCompatActivity {
    ImageView imgImagen;
    TextView txtName;

    TextView txtFrases;
    List<String> frases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Realm.init(this);  // Inicializa Realm en la app

        imgImagen = (ImageView) findViewById(R.id.imgImagen);
        txtName = (TextView) findViewById(R.id.txtName);
        txtFrases = (TextView) findViewById(R.id.txtFrases);

        // Recogemos la informacion pasada
        Intent intent = getIntent();
        int idCard = intent.getIntExtra("id", 0);

        Realm realm = Realm.getDefaultInstance(); // Obtengo una instancia de Realm
        Card card = realm.where(Card.class).equalTo("idCard", idCard).findFirst(); // Obtengo el primer objeto de tipo Card con el idCard igual al idCard pasado del activity anterior
        realm.close();

        // Asignamos imagen, nombre y descripción
        imgImagen.setImageResource(card.getImageResource());
        txtName.setText(card.getName());
        for (String frase: card.getFrases()) {
            txtFrases.append(frase + "\n");
        }
    }
}