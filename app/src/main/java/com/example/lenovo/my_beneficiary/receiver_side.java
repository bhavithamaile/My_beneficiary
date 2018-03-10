package com.example.lenovo.my_beneficiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class receiver_side extends AppCompatActivity {
    public Button bt;

    public TextView txtview1, txtview2;
    public ListView listViewitems;

    public ArrayList<String> list;
    public ArrayAdapter<String> adapter;
    Upload_Item uq;
    public DatabaseReference databaseReference;
    public FirebaseDatabase firebaseDatabase;
   // public Firebase myref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_side);
        listViewitems = (ListView) findViewById(R.id.listViewItems);
        list = new ArrayList<>();
        //  list.add("bhavitha");
        //list.add("jyothsna");
        adapter = new ArrayAdapter<String>(receiver_side.this, android.R.layout.simple_list_item_1, list);
uq=new Upload_Item();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Items");
        // bt=(Button)findViewById(R.id.button);
        // bt.setOnClickListener(this);
        listViewitems.setAdapter(adapter);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               // String val = dataSnapshot.getValue(String.class);
              Upload_Item uq = dataSnapshot.getValue(Upload_Item.class);
                list.add("\n"+uq.getPerson_name_()+" \n"+uq.getItem_name().toString()+"--"+uq.getItem_description().toString()+"\n\n");
                //list.add(val);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
     /*  txtview1=(TextView) findViewById(R.id.name);
        txtview2=(TextView) findViewById(R.id.about);
        String i=getIntent().getStringExtra("myitem");

        String d=getIntent().getStringExtra("description");
        txtview1.setText(i);
        txtview2.setText(d);*/








