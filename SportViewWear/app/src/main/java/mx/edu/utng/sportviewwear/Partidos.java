package mx.edu.utng.sportviewwear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Partidos extends AppCompatActivity {

    Button btnRegresarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos);

        btnRegresarInicio = findViewById(R.id.btnRegresarInicio);

        btnRegresarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Partidos.this, Inicio.class));
                finish();
            }
        });

    }
}