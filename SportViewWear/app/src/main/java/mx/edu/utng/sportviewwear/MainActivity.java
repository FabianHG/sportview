package mx.edu.utng.sportviewwear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText pass;
    Button ingresar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        ingresar = findViewById(R.id.ingresar);

        mAuth = FirebaseAuth.getInstance();

        ingresar.setOnClickListener(v ->{

            String em = email.getText().toString();
            String pw = pass.getText().toString();

            if (TextUtils.isEmpty(em)){
                Toast.makeText(this, "Ingresa tu email", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(pw)){
                Toast.makeText(this, "Ingresa su password", Toast.LENGTH_SHORT).show();
            }else{

                mAuth.signInWithEmailAndPassword(em,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Bienvenido",Toast.LENGTH_SHORT).show();
                                Intent ini = new Intent( MainActivity.this, Inicio.class);
                                startActivity(ini);
                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}