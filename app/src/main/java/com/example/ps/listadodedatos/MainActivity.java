package com.example.ps.listadodedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView lstViewOps;
    ArrayList<Empleado> listaEmp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTitle("ListView");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstViewOps = (ListView)findViewById(R.id.lstViewOps);
        lstViewOps.setOnItemClickListener(this);
        Intent objIntent = getIntent();
        Bundle objBundle = objIntent.getExtras();
        if(objBundle != null)
        {
            listaEmp =(ArrayList<Empleado>)objBundle.getSerializable("datos");
        }else
            listaEmp = new ArrayList<Empleado>();

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        seleccionar(arg2);
    }

    public   void  seleccionar(int arg2)
    {
        switch(arg2)
        {
            case  0: irIngresar();  break;
            case  1: irMostrar();  break;
        }
    }

    public   void irIngresar()
    {

        Intent  objIntent = new Intent(this,Ingresar.class);
        Bundle  objbundle = new Bundle();
        objbundle.putSerializable("datos",listaEmp);
        objIntent.putExtras(objbundle);
        startActivity(objIntent);
        finish();
    }

    public  void irMostrar()
    {
        Intent  objIntent = new Intent(this,Mostrar.class);
        Bundle  objbundle = new Bundle();
        objbundle.putSerializable("datos",listaEmp);
        objIntent.putExtras(objbundle);
        startActivity(objIntent);
        finish();
    }

}