package com.example.final_curso.Adapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.final_curso.Entidades.Producto_entidad;
import com.example.final_curso.R;
import java.util.ArrayList;
import java.util.List;

public class producto_adapter extends RecyclerView.Adapter<producto_adapter.productoHolder>{

    List<Producto_entidad> lista_producto;


    public producto_adapter(ArrayList<Producto_entidad> lista_producto) {
        this.lista_producto = lista_producto;
        //Log.e("Array_producto","El tamaño del array es: "+ lista_producto.size());
    }

    @Override
    public productoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View producto= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fragment_producto, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        producto.setLayoutParams(layoutParams);
        return new producto_adapter.productoHolder(producto);
    }

    @Override
    public  void onBindViewHolder(final producto_adapter.productoHolder holder , final int position) {

        Log.e("onBindViewHolder"," : "+lista_producto.get(position).getNombre().toString());
        holder.nombre.setText(lista_producto.get(position).getNombre().toString());
        holder.descripcion.setText(lista_producto.get(position).getDescripcion().toString());

    }

    @Override
    public int getItemCount() {

        return this.lista_producto.size();
    }


    public class productoHolder extends RecyclerView.ViewHolder {

        TextView nombre, descripcion;

        public productoHolder(final View itemView) {
            super(itemView);

            nombre= itemView.findViewById(R.id.txt_nombr_producto);
            descripcion =itemView.findViewById(R.id.txt_descrip_producto);
        }
    }
}
