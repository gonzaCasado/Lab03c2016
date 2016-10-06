package ccv.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class IngresoOferta extends AppCompatActivity {

    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_oferta);

        /*final String[] categorias = new String[5];
        for(int i=0;i<=Categoria.CATEGORIAS_MOCK.length-1;i++){
            categorias[i]=Categoria.CATEGORIAS_MOCK[i].getDescripcion();
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCategoria);
        ArrayList<String> listCategorias = new ArrayList<String>();
        listCategorias.addAll(Arrays.asList(categorias));
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listCategorias);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);*/
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_ingreso_oferta);
        final Button guardar = (Button) findViewById(R.id.buttonGuardar);
        final String[] categorias = new String[5];
        for(int i=0;i<=Categoria.CATEGORIAS_MOCK.length-1;i++){
            categorias[i]=Categoria.CATEGORIAS_MOCK[i].getDescripcion();
        }

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerCategoria);
        ArrayList<String> listCategorias = new ArrayList<String>();
        listCategorias.addAll(Arrays.asList(categorias));
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listCategorias);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText datosIngresados = (EditText) findViewById(R.id.editTextOferta);
                //Categoria seleccionCategoria = (Categoria) spinner.getSelectedItem();
                String categoriaSeleccionada = spinner.getSelectedItem().toString();
                final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupIdioma);

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override

                    public void onCheckedChanged(RadioGroup arg0, int id) {

                        switch (id) {
                            case -1:
                                Log.v(TAG,"CASE -1");
                                break;
                            case R.id.radioButtonAR:
                                Log.e(TAG,"CASE MONEDA 2");
                                break;
                            case R.id.radioButtonBR:
                                Log.e(TAG,"CASE MONEDA 4");
                                break;
                            case R.id.radioButtonEU:
                                Log.e(TAG,"CASE MONEDA 1");
                                break;
                            case R.id.radioButtonUK:
                                Log.e(TAG,"CASE MONEDA 3");
                                break;
                            case R.id.radioButtonUS:
                                Log.e(TAG,"CASE MONEDA 0");
                                break;
                        }


                    }
                });
                int monedaSeleccionado=8;

                if (radioGroup.getCheckedRadioButtonId()==R.id.radioButtonAR)
                    monedaSeleccionado=2;
                if (radioGroup.getCheckedRadioButtonId()==R.id.radioButtonUS)
                    monedaSeleccionado=0;
                if (radioGroup.getCheckedRadioButtonId()==R.id.radioButtonBR)
                    monedaSeleccionado=4;
                if (radioGroup.getCheckedRadioButtonId()==R.id.radioButtonUK)
                    monedaSeleccionado=3;
                if (radioGroup.getCheckedRadioButtonId()==R.id.radioButtonEU)
                    monedaSeleccionado=1;
                //Trabajo trabajo = new Trabajo(20, datosIngresados.getText().toString(), seleccionCategoria, monedaSeleccionado);

                Toast.makeText(getApplicationContext(),"Hola " + monedaSeleccionado,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("descripcion",datosIngresados.getText().toString());
                intent.putExtra("categoria", categoriaSeleccionada);
                intent.putExtra("idioma",monedaSeleccionado);
                startActivity(intent);

            }
        });
    }

}
