package com.omar.mimapa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {
    EditText etLongitudInicio,etLatitudInicio,etLongitudDestino,etLatitudDestino;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        etLongitudInicio=findViewById(R.id.txtLongitudOrigen);
        etLatitudInicio=findViewById(R.id.txtLatitudOrigen);
        etLongitudDestino=findViewById(R.id.txtLongitudDestino);
        etLatitudDestino=findViewById(R.id.txtLatitudDestino);
    }

    public void click(View view) {

        Punto coordenadas=new Punto();
        if(etLatitudInicio.getText().length()<=0 && etLongitudInicio.getText().length()<=0 ){
            coordenadas.setLongitudInicial("-1.0");
            coordenadas.setLatitudInicial("-1.0");
        }
        try{
            coordenadas.setLongitudFinal(etLongitudDestino.getText().toString());
            coordenadas.setLatitudFinal(etLatitudDestino.getText().toString());

            Intent intent = new Intent(InicioActivity.this,MapsActivity.class);
            intent.putExtra("coordenadas", coordenadas);
            startActivity(intent);

      }catch (NullPointerException e){
            Toast.makeText(this,"Los campos de destino son obligatorios",Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            Toast.makeText(this,"Error de tipo "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
