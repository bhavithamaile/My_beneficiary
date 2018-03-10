package com.example.lenovo.my_beneficiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class giver_side extends AppCompatActivity implements View.OnClickListener{
    public EditText item;
    public EditText description;
    public FirebaseAuth firebaseAuth;
    public FirebaseDatabase database;
    public DatabaseReference databaseReference;

public Button additem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giver_side);
        item=(EditText) findViewById(R.id.item);
        database=FirebaseDatabase.getInstance();
        additem=(Button) findViewById(R.id.add_item);
        databaseReference=database.getReference("Items");
        firebaseAuth=FirebaseAuth.getInstance();
       // FirebaseUser user=firebaseAuth.getCurrentUser();

        description=(EditText) findViewById(R.id.description);
       // FirebaseUser user=firebaseAuth.getCurrentUser();
        additem.setOnClickListener( this);

    }


    public void upload_button_clicked() {
        String i=item.getText().toString().trim();
        String d=description.getText().toString().trim();

      FirebaseUser user=firebaseAuth.getCurrentUser();
        String uname=user.getEmail();
        Upload_Item  ui = new Upload_Item(uname,i,d);
       // assert user != null;
        //databaseReference.child(user.getUid()).setValue(ui);
        databaseReference.push().setValue(ui);
        Toast.makeText(this," Successfully uploaded",Toast.LENGTH_LONG).show();


      /*  Intent receive=new Intent(giver_side.this,receiver_side.class);
        receive.putExtra("myitem",i);
        receive.putExtra("description",d);
        startActivity(receive);
       */

    }

    @Override
    public void onClick(View v) {
        upload_button_clicked();
    }
}
