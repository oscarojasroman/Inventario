package com.example.marcelo.inventario;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et1= (EditText) findViewById(R.id.txtNombre);
        et2= (EditText) findViewById(R.id.txtUsuarioRe);
        et3= (EditText) findViewById(R.id.txtContraseñaRe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registrar(View v){
        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String nombre=et1.getText().toString();
        String usuario=et2.getText().toString();
        String contraseña=et3.getText().toString();

        ContentValues values=new ContentValues();
        values.put("nombre",nombre);
        values.put("usuario",usuario);
        values.put("contrasena",contraseña);

        db.insert("usuarios",null,values);
        db.close();

        Intent ven=new Intent(this,MainActivity.class);
        startActivity(ven);
    }
    public void cancelar(View view){
        finish();
    }
}
