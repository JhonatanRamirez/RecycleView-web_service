package com.example.final_curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaracion de variables
     * */

    EditText txt_correo, txt_clave;
    Button btn_iniciar;
    ImageButton btn_facebook, btn_gmail;
    TextView txt_registrarse, txt_ol_clave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txt_correo= findViewById(R.id.txt_correo);
        this.txt_clave=findViewById(R.id.txt_clave);
        this.btn_iniciar=findViewById(R.id.btn_iniciar);
        this.btn_facebook=findViewById(R.id.btn_facebook);
        this.btn_gmail=findViewById(R.id.btn_gmail);
        this.txt_registrarse= findViewById(R.id.lbl_registro);
        this.txt_ol_clave=findViewById(R.id.lbl_Ol_clave);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Perfil.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
