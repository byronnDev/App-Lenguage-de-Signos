package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import mikel.echeverria.R;

public class SecondActivity extends AppCompatActivity {
    ImageView imgImagen;
    TextView txtName;
    TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        imgImagen = (ImageView) findViewById(R.id.imgImagen);
        txtName = (TextView) findViewById(R.id.txtName);

        // Recogemos la informacion pasada
        Intent intent = getIntent();
        int imageResource = intent.getIntExtra("imageResource", R.drawable.image1 /* default image */);
        String name = intent.getStringExtra("name");

        // Asignamos imagen, nombre y descripción
        imgImagen.setImageResource(imageResource);
        txtName.setText(name);

    }
}