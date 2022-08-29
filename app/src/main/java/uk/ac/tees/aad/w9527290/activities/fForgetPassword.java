package uk.ac.tees.aad.w9527290.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import uk.ac.tees.aad.w9527290.R;

public class fForgetPassword extends AppCompatActivity {


    EditText email;
    Button ResetButton;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fforget_password);

        ResetButton = findViewById(R.id.resetPasswordbtn);
        email = findViewById(R.id.ResetEmail);

        auth = FirebaseAuth.getInstance();
        ResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current_email = email.getText().toString();
                if(current_email.isEmpty())
                {
                    email.setError("Enter Email");
                    email.requestFocus();
                    return;
                }

                auth.sendPasswordResetEmail(current_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(fForgetPassword.this,"emai send",Toast.LENGTH_LONG).show();

                        }
                        if(!task.isSuccessful())
                        {
                            Toast.makeText(fForgetPassword.this,"Failed",Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });
    }
}