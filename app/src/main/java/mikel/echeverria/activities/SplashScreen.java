package mikel.echeverria.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import mikel.echeverria.R;

public class SplashScreen extends AppCompatActivity {
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Cargar la animación
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_bounce);

        // Obtener una referencia al logo que quieres animar
        logo = findViewById(R.id.logo);

        // Iniciar la animación
        logo.startAnimation(animation);

        // Esperar a que termine la animación antes de iniciar la actividad principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); // Esperar 2000 ms (2 segundos)
    }
}