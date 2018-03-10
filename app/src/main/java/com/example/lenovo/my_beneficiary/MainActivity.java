package com.example.lenovo.my_beneficiary;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText email;
    public EditText password;
    public FirebaseAuth firebaseAuth;
    public Button login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == login) {
            login_user();
        }

        }

    private void login_user() {
        String uname = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (TextUtils.isEmpty(uname)) {
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }


        firebaseAuth.signInWithEmailAndPassword(uname, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            // Intent in=new Intent(this,activity_first.class);
                            user_page();
                            //startActivity(in);

                        } else {
                            //display some message here
                            Toast.makeText(MainActivity.this, "oops! something went wrong" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                        //   progressDialog.dismiss();
                    }
                });
    }

        private void user_page()
    {
        Intent in =new Intent(this,activity_first.class);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(in);
    }

}


