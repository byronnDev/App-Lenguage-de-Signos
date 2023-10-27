package mikel.echeverria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.RecyclerDataAdapter;

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

        List<ItemData> dataList = new ArrayList<>();

        Context context = getApplicationContext(); // Puedes obtener el contexto de esta manera
        int verdeColor = ContextCompat.getColor(context, R.color.color_verde);
        int amarilloColor = ContextCompat.getColor(context, R.color.color_amarillo);
        int azulColor = ContextCompat.getColor(context, R.color.color_azul);
        int rojoColor = ContextCompat.getColor(context, R.color.color_rojo);
        int marronColor = ContextCompat.getColor(context, R.color.color_marron);
        int moradoColor = ContextCompat.getColor(context, R.color.color_morado);
        int cianColor = ContextCompat.getColor(context, R.color.color_cian);
        int grisColor = ContextCompat.getColor(context, R.color.color_gris);

        int verdeClaroColor = ContextCompat.getColor(context, R.color.color_verde_claro);
        int amarilloClaroColor = ContextCompat.getColor(context, R.color.color_amarillo_claro);
        int azulClaroColor = ContextCompat.getColor(context, R.color.color_azul_claro);
        int rojoClaroColor = ContextCompat.getColor(context, R.color.color_rojo_claro);
        int marronClaroColor = ContextCompat.getColor(context, R.color.color_marron_claro);
        int moradoClaroColor = ContextCompat.getColor(context, R.color.color_morado_claro);
        int cianClaroColor = ContextCompat.getColor(context, R.color.color_cian_claro);
        int grisClaroColor = ContextCompat.getColor(context, R.color.color_gris_claro);

        // Creo las descripciones para cada elemento
        String helloDescription = "Hello! es una expresión de saludo utilizada en el idioma inglés y en muchos otros idiomas en todo el mundo. Es una manera universalmente reconocida de iniciar una conversación o saludar a alguien de manera cordial. Esta simple palabra refleja la amabilidad y la voluntad de establecer una conexión con otra persona. A menudo se pronuncia con entusiasmo y una sonrisa para transmitir un mensaje de bienvenida y apertura en las interacciones sociales.";
        String robotDescription = "Un robot es una máquina versátil y programable diseñada para realizar una variedad de tareas de forma autónoma o controlada por un operador. Los robots pueden adoptar una amplia gama de formas y tamaños, desde brazos robóticos industriales que ensamblan automóviles hasta robots humanoides que imitan el comportamiento humano. Estas máquinas pueden realizar trabajos repetitivos, peligrosos o precisos, y se utilizan en industrias como la manufactura, la exploración submarina y la cirugía.";
        String vampireDescription = "El vampiro es una figura legendaria y sobrenatural que ha sido una parte constante de la mitología y la literatura de terror a lo largo de la historia. Se cree que los vampiros son seres inmortales que se alimentan de la sangre de los vivos para mantener su propia existencia. Además de la necesidad de sangre, a menudo se les atribuyen habilidades sobrenaturales, como la capacidad de transformarse en murciélagos o hipnotizar a sus víctimas. Los vampiros han sido protagonistas de numerosas historias y películas de terror, y su imagen ha evolucionado a lo largo del tiempo.";
        String elfDescription = "El duende es una criatura mítica presente en las leyendas y folclores de muchas culturas, especialmente en la mitología celta y la hispana. Por lo general, se les representa como seres pequeños, traviesos y mágicos que habitan en bosques, grutas o lugares remotos. Los duendes pueden ser juguetones o maliciosos, y a menudo están asociados con la protección o el castigo de aquellos que entran en su territorio. Estas criaturas han sido una fuente de inspiración en la literatura y la cultura popular, y se consideran guardianes de la naturaleza en algunas tradiciones.";
        String brainDescription = "El cerebro es el órgano central del sistema nervioso en los seres humanos y otros vertebrados. Se encuentra en la cabeza y desempeña un papel fundamental en la regulación de todas las funciones del cuerpo. Es el centro del pensamiento, la memoria, la percepción y el control de movimientos y respuestas corporales. El cerebro humano es altamente complejo, con miles de millones de neuronas que se comunican entre sí a través de conexiones sinápticas. Esta maravilla biológica es responsable de la conciencia y la inteligencia en los seres humanos.";
        String fireDescription = "El fuego es una reacción química exotérmica que se produce cuando un material combustible se combina con oxígeno en condiciones adecuadas. Esta reacción genera calor, luz y gases de combustión. El fuego ha sido tanto una fuerza natural como una herramienta creada por los humanos a lo largo de la historia. Tiene aplicaciones beneficiosas, como cocinar alimentos y proporcionar calor, pero también puede ser destructivo en forma de incendios forestales o estructurales. La capacidad de controlar el fuego fue un logro crucial en la evolución humana.";
        String holaDescription = "¡Hola! es la versión en español de la palabra 'Hello!' y se utiliza de manera similar para saludar a alguien de manera amigable y cordial. Es una forma común de establecer contacto en español y se pronuncia con entusiasmo para expresar una bienvenida o un interés genuino en la comunicación.";
        String aiDescription = "La Inteligencia Artificial es un campo de la informática que se enfoca en la creación de sistemas y programas capaces de realizar tareas que, normalmente, requerirían inteligencia humana. Estos sistemas pueden aprender, razonar, tomar decisiones y procesar datos de manera autónoma. La IA tiene aplicaciones en una amplia gama de industrias, incluyendo la atención médica, la industria automotriz, la logística y la atención al cliente. Su desarrollo continúa avanzando, con el potencial de transformar fundamentalmente la forma en que interactuamos con la tecnología y el mundo que nos rodea.";

        // Creamos los objetos/items
        dataList.add(new ItemData(R.drawable.image1, "Hello!", helloDescription, verdeColor, verdeClaroColor)); // Verde
        dataList.add(new ItemData(R.drawable.image2, "Robot", robotDescription, amarilloColor, amarilloClaroColor)); // Amarillo
        dataList.add(new ItemData(R.drawable.image3, "Vampiro", vampireDescription, azulColor,azulClaroColor)); // Azul
        dataList.add(new ItemData(R.drawable.image4, "Duende", elfDescription, rojoColor,rojoClaroColor)); // Rojo
        dataList.add(new ItemData(R.drawable.image5, "Cerebro", brainDescription, marronColor,marronClaroColor)); // Marrón
        dataList.add(new ItemData(R.drawable.image6, "Fuego", fireDescription, moradoColor,moradoClaroColor)); // Morado
        dataList.add(new ItemData(R.drawable.image1, "Hola!", holaDescription, cianColor,cianClaroColor)); // Cian
        dataList.add(new ItemData(R.drawable.image2, "IA", aiDescription, grisColor,grisClaroColor)); // Gris

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