package mx.edu.utng.sportviewwear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Equipos extends AppCompatActivity {

    Button btnRegresarInicio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        btnRegresarInicio2 = findViewById(R.id.btnRegresarInicio2);

        btnRegresarInicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Equipos.this, Inicio.class));
                finish();
            }
        });
    }
}