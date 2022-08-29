package uk.ac.tees.aad.w9527290.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uk.ac.tees.aad.w9527290.R;

public class Login extends AppCompatActivity {

    Button Login;
    EditText email,pass;
    FirebaseAuth auth;
    TextView fgtext;
    TextView RegesterText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();

        Login = findViewById(R.id.login);
        email = findViewById(R.id.searchitem);
        pass = findViewById(R.id.LoginPassword);
        fgtext = findViewById(R.id.textViewfg);
        RegesterText = findViewById(R.id.registertext);

        RegesterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(uk.ac.tees.aad.w9527290.activities.Login.this,registration.class);
                startActivity(intent);
            }
        });

        fgtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(uk.ac.tees.aad.w9527290.activities.Login.this,fForgetPassword.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String currentemail = email.getText().toString();
                String currentpass = pass.getText().toString();
                if(currentemail.isEmpty())
                {
                    email.setError("Enter the Email");
                    email.requestFocus();
                    return;
                }
                if(currentpass.isEmpty())
                {
                    pass.setError("Enter the pass");
                    pass.requestFocus();
                    return;
                }

                auth.signInWithEmailAndPassword(currentemail,currentpass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful())
                                {

                                    Intent intent = new Intent(uk.ac.tees.aad.w9527290.activities.Login.this, MainScreen.class);
                                    startActivity(intent);
                                }
                                else
                                    {
                                        Toast.makeText(uk.ac.tees.aad.w9527290.activities.Login.this,"Error",Toast.LENGTH_LONG).show();
                                    }
                            }
                        });
            }
        });
    }
}