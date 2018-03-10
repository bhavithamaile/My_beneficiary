package com.example.lenovo.my_beneficiary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener {

    public EditText email;
    public EditText password;
   // public Button login;
    public Button register;
    public FirebaseAuth firebaseAuth;
    public TextView login;
    public EditText person_name;
    public ContactsContract.CommonDataKinds.Phone number;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login= (TextView) findViewById(R.id.textView);
        register = (Button) findViewById(R.id.email_sign_up_button);
person_name=(EditText) findViewById(R.id.Name);
//number=(ContactsContract.CommonDataKinds.Phone)findViewById(R.id.Number);
       login.setOnClickListener(this);
       register.setOnClickListener(this);
    }

    public void onClick(View view) {

        if (view == register)
            register_user();
        if (view == login) {
            Intent main=new Intent(this,MainActivity.class);
            startActivity(main);
        }
    }

    private void register_user() {
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

        firebaseAuth.createUserWithEmailAndPassword(uname, pass)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            //display some message here
                            Toast.makeText(LoginActivity.this, "Successfully registered", Toast.LENGTH_LONG).show();
                        } else {
                            //display some message here
                            Toast.makeText(LoginActivity.this, "Registration Error"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                        //   progressDialog.dismiss();
                    }
                });

    }


}
