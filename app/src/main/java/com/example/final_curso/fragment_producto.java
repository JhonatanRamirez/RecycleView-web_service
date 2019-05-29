package com.example.final_curso;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.final_curso.Adapter.producto_adapter;
import com.example.final_curso.Entidades.Producto_entidad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_producto extends Fragment implements Response.Listener<JSONArray>, Response.ErrorListener {

    int valorLlegada;
    ArrayList<Producto_entidad> arrayProducto;
    RecyclerView recyclerProducto;
    TextView lbl_producto;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue request;

    public fragment_producto() {
    }

    @SuppressLint("ValidFragment")
    public fragment_producto(int valorLlegada) {
        this.valorLlegada = valorLlegada;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.consultar_producto, container, false);

        arrayProducto= new ArrayList<>();
        recyclerProducto=view.findViewById(R.id.id_recyclerprod);
        recyclerProducto.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerProducto.setHasFixedSize(true);
        lbl_producto= view.findViewById(R.id.lbl_producto);
        request= Volley.newRequestQueue(this.getContext());
        cargarWebService();
        return  view;

    }

    private void cargarWebService(){

        String url="https://cursojueves.000webhostapp.com/web_service/get_producto.php";

        jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url,null, this, this);
        request.add(jsonArrayRequest);




    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se puede conectar a la base de datos", Toast.LENGTH_LONG).show();
        System.out.println();
        Log.e("Impresion","Lo sentimos :( "+ error.toString());

    }

    @Override
    public void onResponse(JSONArray response) {

        Producto_entidad p = null;

        try {
            //JSONArray jsonArray= response.getJSONArray(0);

            for (int i=0; i<response.length(); i++){

                p= new Producto_entidad();
                JSONObject jsonObject=null;
                jsonObject= response.getJSONObject(i);

                p.setNombre(jsonObject.optString("nombre"));
                p.setDescripcion(jsonObject.optString("descripcion"));

                arrayProducto.add(p);

            }


            producto_adapter adapter = new producto_adapter(arrayProducto);
            recyclerProducto.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();

        }



    }
}
