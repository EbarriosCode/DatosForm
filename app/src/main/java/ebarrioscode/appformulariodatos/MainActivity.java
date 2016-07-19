package ebarrioscode.appformulariodatos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nombre;
    EditText telefono;
    EditText email;
    EditText descripcion;

    DatePicker fecha;
    Button btnSiguiente;

    boolean validar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtNombre);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        fecha = (DatePicker) findViewById(R.id.fecha);
        email = (EditText) findViewById(R.id.txtEmail);
        descripcion = (EditText) findViewById(R.id.txtDescripcion);
        btnSiguiente = (Button) findViewById(R.id.btnSubmit);

        btnSiguiente.setOnClickListener(this);

        validar = getIntent().getBooleanExtra("validar",false);

            if(validar)
            {
                nombre.setText(getIntent().getStringExtra("RegresandoNombre"));
                telefono.setText(getIntent().getStringExtra("RegresandoTelefono"));
                email.setText(getIntent().getStringExtra("RegresandoEmail"));
                descripcion.setText(getIntent().getStringExtra("RegresandoDescripcion"));
            }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSubmit:
                Intent intent = new Intent(MainActivity.this, RecibirDatosActivity.class);
                String name = nombre.getText().toString();
                String date = String.valueOf(fecha.getDayOfMonth()+"/"+(fecha.getMonth()+1)+"/"+fecha.getYear());
                String tel = telefono.getText().toString();
                String correo = email.getText().toString();
                String descrip = descripcion.getText().toString();

                intent.putExtra("Nombre",name);
                intent.putExtra("fecha",date);
                intent.putExtra("Telefono",tel);
                intent.putExtra("Correo",correo);
                intent.putExtra("Descripcion",descrip);

                startActivity(intent);
                validar = true;
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.textoActividad1),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
