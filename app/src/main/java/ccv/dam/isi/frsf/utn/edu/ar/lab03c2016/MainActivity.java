package ccv.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.ClipData;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Adapter adapter;
 //   Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listView);
        int cantidad = trabajos.length;
        Bundle extras = getIntent().getExtras();



        ArrayList listaa = new ArrayList();
        listaa.addAll(Arrays.asList(trabajos));

        if(extras != null){


            String desc = extras.getString("descripcion");
            String cat = extras.getString("categoria");
            int moneda = extras.getInt("idioma");

            if (cat.equals("Arquitecto")){
                Categoria categoria = new Categoria(1,"Arquitecto");
                trabajos[cantidad-1] = new Trabajo(cantidad, desc, categoria, moneda);
                cantidad=cantidad+1;
                listaa.add(new Trabajo(cantidad, desc, categoria, moneda));
            }
            else if (cat.equals("Desarrollador")){
                Categoria categoria = new Categoria(2,"Desarrollador");
                trabajos[cantidad-1] = new Trabajo(cantidad, desc, categoria, moneda);
                cantidad=cantidad+1;
                listaa.add(new Trabajo(cantidad, desc, categoria, moneda));
            }

            else if (cat.equals("Tester")){
                Categoria categoria = new Categoria(3,"Tester");
                trabajos[cantidad-1] = new Trabajo(cantidad, desc, categoria, moneda);
                cantidad=cantidad+1;
                listaa.add(new Trabajo(cantidad, desc, categoria, moneda));
            }

            else if (cat.equals("Analista")){
                Categoria categoria = new Categoria(4,"Analista");
                trabajos[cantidad-1] = new Trabajo(cantidad, desc, categoria, moneda);
                cantidad=cantidad+1;
                listaa.add(new Trabajo(cantidad, desc, categoria, moneda));
            }

            else if (cat.equals("Mobile Developer")){
                Categoria categoria = new Categoria(5,"Mobile Developer");
                trabajos[cantidad-1] = new Trabajo(cantidad, desc, categoria, moneda);
                cantidad=cantidad+1;
                listaa.add(new Trabajo(cantidad, desc, categoria, moneda));

            }

        }


        adapter= new Adapter(getApplicationContext(), listaa);

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
                Toast.makeText(this,"Usted ha sido postulado para esta oferta laboral: ",Toast.LENGTH_LONG).show();
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


    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.nuevaOferta:
                Intent intent = new Intent (getApplicationContext(), IngresoOferta.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    public Trabajo[] trabajos = new Trabajo[]{
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
