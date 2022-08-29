package uk.ac.tees.aad.w9527290.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

import uk.ac.tees.aad.w9527290.Models.UserDetail;
import uk.ac.tees.aad.w9527290.R;

public class registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    FirebaseAuth auth;

    EditText UserEmail, UserPassword,UserName,UserHeight,UserWeight;
    Spinner GenderList;
    public  static  String SelectedGender;

    Button Reg_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestertion);

        auth = FirebaseAuth.getInstance();


        UserEmail = findViewById(R.id.email);
        UserPassword = findViewById(R.id.Password);
        UserName = findViewById(R.id.Name);
        UserHeight = findViewById(R.id.height);
        UserWeight = findViewById(R.id.weight);
        GenderList = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenderList.setAdapter(adapter);
        GenderList.setOnItemSelectedListener(this);
        Reg_btn = findViewById(R.id.register);

        Reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserRegester();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        SelectedGender = GenderList.getItemAtPosition(i).toString();
        Toast.makeText(registration.this,SelectedGender.toString(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void UserRegester()
    {

        String email = UserEmail.getText().toString();
        String password = UserPassword.getText().toString();
        String weight = UserWeight.getText().toString();
        String height = UserHeight.getText().toString();
        String name = UserName.getText().toString();
        String Gender = SelectedGender;

        if(email.isEmpty())
        {
            UserEmail.setError("Required");
            UserEmail.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            UserPassword.setError("Required");
            UserPassword.requestFocus();
            return;
        }
        if(weight.isEmpty())
        {
            UserWeight.setError("Required");
            UserWeight.requestFocus();
            return;
        }
        if(height.isEmpty())
        {
            UserHeight.setError("Required");
            UserHeight.requestFocus();
            return;
        }
        if(name.isEmpty())
        {
            UserName.setError("Required");
            UserName.requestFocus();
            return;
        }

       auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()) {
                   Toast.makeText(registration.this, "jhjjj", Toast.LENGTH_LONG).show();
                   UserDetail detail = new UserDetail(name.toString(),email.toString(),Float.parseFloat(weight),Float.parseFloat(weight),Gender.toString());
                   FirebaseDatabase.getInstance().getReference("user")
                           .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                           .setValue(detail).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           Toast.makeText(registration.this, "yes", Toast.LENGTH_LONG).show();
                           Intent intent = new Intent(registration.this,MainScreen.class);
                           startActivity(intent);
                       }
                   });

               }
               else{

                   Toast.makeText(registration.this, "no", Toast.LENGTH_LONG).show();
               }
           }
       });
    }
}