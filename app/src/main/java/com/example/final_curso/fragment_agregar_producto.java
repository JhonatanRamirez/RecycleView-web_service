package com.example.final_curso;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.final_curso.Entidades.Producto_entidad;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fragment_agregar_producto extends Fragment implements View.OnClickListener{

    EditText nombre, descripcion;
    Button btn_reg;
    StringRequest stringRequest;
    RequestQueue request;
    Producto_entidad p;
    public fragment_agregar_producto() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_agregar_producto, container, false);

        this.nombre= view.findViewById(R.id.reg_nombre);
        this.descripcion= view.findViewById(R.id.reg_descripcion);
        this.btn_reg= view.findViewById(R.id.btn_reg_datos);
        request= Volley.newRequestQueue(this.getContext());
        this.btn_reg.setOnClickListener(this);
        return  view;

    }

    @Override
    public void onClick(View v) {

         if(v == btn_reg){


            guardarBd();
        }

    }

    private void guardarBd() {

        AsignarParametros();

        String url2="https://cursojueves.000webhostapp.com/web_service/set_producto.php?";

        this.stringRequest= new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(getContext(), "Su producto fue guardado con exito", Toast.LENGTH_LONG).show();
                borrarCampos();

            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "Este es el error linea 83"+ error);
            }
        }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String> parametros= new HashMap<>();
                parametros.put("nombre",   p.getNombre());
                parametros.put("descripcion", p.getDescripcion());

                return parametros;


            }

        };

        request.add(stringRequest);

    }

    private void AsignarParametros() {

        p= new Producto_entidad();
        p.setNombre(this.nombre.getText().toString());
        p.setDescripcion(this.descripcion.getText().toString());

    }

    private void borrarCampos(){

        this.nombre.setText("");
        this.descripcion.setText("");

    }
}
