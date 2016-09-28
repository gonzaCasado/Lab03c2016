package ccv.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrador on 08/09/2016.
 */
public class Adapter extends ArrayAdapter<Trabajo> {
    LayoutInflater inflater;
    String actual;

    Adapter(Context context, List<Trabajo> items) {
        super(context, R.layout.layout_fila, items);
        inflater= LayoutInflater.from(context);
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        DecimalFormat df= new DecimalFormat("#.##");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        View row=inflater.inflate(R.layout.layout_fila, parent, false);
        TextView categoria = (TextView) row.findViewById(R.id.textCategoria);
        categoria.setText(this.getItem(position).getCategoria().getDescripcion().toString());
        TextView descripcion = (TextView) row.findViewById(R.id.textDescripcion);
        descripcion.setText(this.getItem(position).getDescripcion().toString());
        TextView horas = (TextView) row.findViewById(R.id.textHoras2);
        horas.setText(this.getItem(position).getHorasPresupuestadas().toString() + " ");
        TextView costo = (TextView) row.findViewById(R.id.textPrecioHora2);
        costo.setText(df.format(Double.parseDouble(this.getItem(position).getPrecioMaximoHora().toString()))+"  ");
        TextView fecha = (TextView) row.findViewById(R.id.textFecha2);
        fecha.setText("  " + dateFormat.format((Date) this.getItem(position).getFechaEntrega()));
        ImageView icon=(ImageView) row.findViewById(R.id.imageView);
        CheckBox ingles = (CheckBox) row.findViewById(R.id.checkBox);

        if(this.getItem(position).getMonedaPago() == 0){
            icon.setImageResource(R.drawable.us);
        }
        else if(this.getItem(position).getMonedaPago() == 1){
            icon.setImageResource(R.drawable.eu);
        }
        else if(this.getItem(position).getMonedaPago() == 2){
            icon.setImageResource(R.drawable.ar);
        }
        else if(this.getItem(position).getMonedaPago() == 3){
            icon.setImageResource(R.drawable.uk);
        }
        else icon.setImageResource(R.drawable.br);

        if(this.getItem(position).getRequiereIngles()== true){
            ingles.setChecked(true);
        }
        else ingles.setChecked(false);


        row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                    setActual(getItem(position).getDescripcion().toString());
                return false;
            }
        });

        return(row);
    }

    private void setActual(String actual){
        this.actual = actual;
    }
    public String getActual(){
        return actual;
    }

}