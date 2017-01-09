package jjimenez.app.com.mascotasrecyclerviewactionview;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import jjimenez.app.com.mascotasrecyclerviewactionview.pojo.SendEmail;

public class ContactoSent extends AppCompatActivity {


    private TextInputEditText EditNombre;
    private TextInputEditText email;
    private TextInputEditText mensaje;
    private Button botonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_sent);


        Toolbar mitoolbar = (Toolbar)findViewById(R.id.detalletoobar);
        setSupportActionBar(mitoolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditNombre = (TextInputEditText)findViewById(R.id.nombreSend);
        email = (TextInputEditText)findViewById(R.id.emailSend);
        mensaje = (TextInputEditText)findViewById(R.id.textSend);
        botonSend = (Button)findViewById(R.id.btnSend);

        botonSend.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                sendemail();

            }
        });



    }

    public void sendemail(){

     String nombre = EditNombre.getText().toString().trim();
        String miemail = email.getText().toString().trim();
        String mimensaje = mensaje.getText().toString().trim();

SendEmail sm = new SendEmail(this, nombre, miemail, mimensaje);

        sm.execute();

    }
}
