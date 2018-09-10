package com.example.ps.listadodedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Ingresar extends AppCompatActivity {


        EditText txtCod, txtNom, txtSue;
        ArrayList<Empleado> listaIng;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ingresar);

            txtCod =(EditText)findViewById(R.id.txtCodigo);
            txtNom =(EditText)findViewById(R.id.txtNombre);
            txtSue =(EditText)findViewById(R.id.txtSueldo);
            Intent objInten=getIntent();
            Bundle  objBundle=objInten.getExtras();
            listaIng = (ArrayList<Empleado>)objBundle.getSerializable("datos");
        }

        public   void  agregar(View v)
        {
            String sCod, sNom, sSue;
            double  sue;
            sCod = txtCod.getText().toString();
            sNom = txtNom.getText().toString();
            sSue = txtSue.getText().toString();
            sue = Double.parseDouble(sSue);
            Empleado  obj = new Empleado(sCod, sNom, sue);
            listaIng.add(obj);
            txtCod.setText("");
            txtNom.setText("");
            txtSue.setText("");
            txtCod.requestFocus();
        }
        public   void  regresar(View v)
        {
            Intent  objIntent=new Intent(this, MainActivity.class);
            Bundle  objbundle=new Bundle();
            objbundle.putSerializable("datos",listaIng);
            objIntent.putExtras(objbundle);
            startActivity(objIntent);
            finish();
        }
    }

