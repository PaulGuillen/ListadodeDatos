package com.example.ps.listadodedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {

    EditText txtResp;
    ArrayList<Empleado> listaEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        txtResp = (EditText)findViewById(R.id.TXTRESULTADO);
        Intent objInten=getIntent();
        Bundle  objBundle=objInten.getExtras();
        listaEmp =(ArrayList<Empleado>)objBundle.getSerializable("datos");
        mostrar();
    }

    public   void   mostrar()
    {
        String  acumEmp="";
        for(Empleado  e : listaEmp)
        {
            acumEmp+= e.getCodigo()+ "  " + e.getNombre()+ "  " + e.getSueldo() + "\n";
        }
        txtResp.setText(acumEmp);
    }

    public   void  regresar(View v)
    {
        Intent  objIntent=new Intent(this, MainActivity.class);
        Bundle  objbundle=new Bundle();
        objbundle.putSerializable("datos",listaEmp);
        objIntent.putExtras(objbundle);
        startActivity(objIntent);
        finish();
    }
}
