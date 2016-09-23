package ccv.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listView);

        Adapter adapter= new Adapter(getApplicationContext(), Arrays.asList(trabajos));
        lista.setAdapter(adapter);
    }

    public static final Trabajo[] trabajos = new Trabajo[]{
            new Trabajo(1,"Proyecto ABc"),
            new Trabajo(2,"Sistema de Gestion"),
            new Trabajo(3, "Aplicacion XYZ"),
            new Trabajo(4,"Modulo NN1"),
            new Trabajo(5,"Sistema de adminisracion TDF"),
            new Trabajo(6,"Aplicacion OYU 66"),
            new Trabajo(7,"Gestion de laboratorios"),
            new Trabajo(8,"Sistema Universidades"),
            new Trabajo(9,"Portal Compras"),
            new Trabajo(10,"Gestion RRHH"),
            new Trabajo(11,"Traductor Automatico"),
            new Trabajo(12,"Alquileres online"),
            new Trabajo(13,"Gestion financiera"),
            new Trabajo(14,"Modulo Seguridad"),
            new Trabajo(15,"consultoria performance"),
            new Trabajo(16,"Ecommerce Uah"),
            new Trabajo(17,"Portal Web Htz"),
            new Trabajo(18,"Sitio Coroporativo"),
            new Trabajo(19,"Aplicacion www1")
    };
}
