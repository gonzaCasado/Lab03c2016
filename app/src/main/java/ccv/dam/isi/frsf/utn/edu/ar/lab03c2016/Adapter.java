package ccv.dam.isi.frsf.utn.edu.ar.lab03c2016;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrador on 08/09/2016.
 */
public class Adapter extends ArrayAdapter<Trabajo> {
    LayoutInflater inflater;
    Adapter(Context context, List<Trabajo> items) {
        super(context, R.layout.layout_fila, items);
        inflater= LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        DecimalFormat df= new DecimalFormat("#.##");
        View row=inflater.inflate(R.layout.layout_fila, parent, false);
        TextView categoria = (TextView) row.findViewById(R.id.textCategoria);
        //categoria.setText();
        TextView descripcion = (TextView) row.findViewById(R.id.textDescripcion);
        TextView horas = (TextView) row.findViewById(R.id.textFecha2);
        TextView costo = (TextView) row.findViewById(R.id.textPrecioHora2);
        TextView fecha = (TextView) row.findViewById(R.id.textFecha2);
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
            ingles.setSelected(true);
        }
        else ingles.setSelected(false);

        return(row);
    }
}