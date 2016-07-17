package ebarrioscode.appformulariodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecibirDatosActivity extends AppCompatActivity implements View.OnClickListener{

    TextView listarNombre;
    TextView listarFecha;
    TextView listarTelefono;
    TextView listarEmail;
    TextView listarDescripcion;
    Button editarDatos;
    boolean validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_datos);

        listarNombre = (TextView)findViewById(R.id.tvEditNombre);
        listarFecha = (TextView)findViewById(R.id.tvFechaEdit);
        listarTelefono = (TextView)findViewById(R.id.tvTelefonoEdit);
        listarEmail = (TextView)findViewById(R.id.tvEmailEdit);
        listarDescripcion = (TextView)findViewById(R.id.tvDescEdit);
        editarDatos = (Button)findViewById(R.id.btnEditarDatos);

        editarDatos.setOnClickListener(this);

        Intent intent2 = getIntent();
        Bundle bundle = intent2.getExtras();

        if(bundle!=null)
        {
            String name = (String) bundle.get("Nombre");
            listarNombre.setText(name);

            String miFecha = (String)bundle.get("fecha");
            listarFecha.setText(miFecha);

            String tel = (String) bundle.get("Telefono");
            listarTelefono.setText(tel);

            String email = (String) bundle.get("Correo");
            listarEmail.setText(email);

            String descripcion = (String) bundle.get("Descripcion");
            listarDescripcion.setText(descripcion);

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnEditarDatos:
                validar = true;
                Intent intentEditar = new Intent(RecibirDatosActivity.this, MainActivity.class);
                intentEditar.putExtra("validar",validar);
                intentEditar.putExtra("RegresandoNombre",listarNombre.getText());
                intentEditar.putExtra("RegresandoTelefono",listarTelefono.getText());
                intentEditar.putExtra("RegresandoEmail",listarEmail.getText());
                intentEditar.putExtra("RegresandoDescripcion",listarDescripcion.getText());

                startActivity(intentEditar);
            break;
        }
    }
}
