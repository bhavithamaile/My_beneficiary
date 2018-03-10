package com.example.lenovo.my_beneficiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_first extends AppCompatActivity implements View.OnClickListener {
    public Button giver;
    public Button receiver,logout;
    public FirebaseAuth firebaseAuth;
    public TextView tv;
   // public Toolbar tool_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
       // tool_bar=(Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(tool_bar);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        tv=(TextView) findViewById(R.id.textView2);
        String x=tv.getText().toString();
       // tv.setVisibility(View.VISIBLE);
        tv.setText("Welcome "+user.getEmail());
        logout=(Button) findViewById(R.id.logout_button);
        giver = (Button) findViewById(R.id.giver_button);
        receiver = (Button) findViewById(R.id.receiver_button);
        giver.setOnClickListener(this);
        receiver.setOnClickListener(this);
        logout.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(v==receiver)
        {
            Intent in =new Intent(this,receiver_side.class);
            startActivity(in);
        }
        if(v==giver)
        {
            Intent in =new Intent(this,giver_side.class);
            startActivity(in);
        }
        if(v==logout)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
        return true;
    }*/
}
