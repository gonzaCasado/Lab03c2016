package ccv.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listView);

        adapter= new Adapter(getApplicationContext(), Arrays.asList(trabajos));
        lista.setAdapter(adapter);
        registerForContextMenu(lista);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu_principal, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info){
        super.onCreateContextMenu(menu, view, info);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.postularse:
                Toast.makeText(this,"Usted ha sido postulado para esta oferta laboral: ",Toast.LENGTH_LONG);
                return true;
            case R.id.compartir:
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Oferta Laboral");
                this.startActivity(Intent.createChooser(i, "Compartir"));
                return true;
            default:
                return super.onContextItemSelected(item);

        }

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
            new Trabajo(15,"Consultoria performance"),
            new Trabajo(16,"Ecommerce Uah"),
            new Trabajo(17,"Portal Web Htz"),
            new Trabajo(18,"Sitio Coroporativo"),
            new Trabajo(19,"Aplicacion www1")
    };
}
