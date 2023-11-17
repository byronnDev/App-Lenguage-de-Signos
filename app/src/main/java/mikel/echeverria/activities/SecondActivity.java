package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import io.realm.Realm;
import mikel.echeverria.R;
import mikel.echeverria.model.Card;

public class SecondActivity extends AppCompatActivity {
    ImageView imgImagen;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        imgImagen = findViewById(R.id.imgImagen);
        txtName = findViewById(R.id.txtName);

        int idCard = getIntent().getIntExtra("id", 0);

        Realm realm = Realm.getDefaultInstance();
        Card card = realm.where(Card.class).equalTo("id", idCard).findFirst();
        realm.close();

        imgImagen.setImageResource(card.getImageResource());
        txtName.setText(card.getName());

    }
}