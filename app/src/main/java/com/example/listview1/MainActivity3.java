package com.example.listview1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
TextView datat,datat1;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        datat =(TextView)findViewById(R.id.datatext);
        datat1 =(TextView)findViewById(R.id.datatext1);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("getinformation");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("name").getValue().toString();
                String age=snapshot.child("age").getValue().toString();
                String url=snapshot.child("url").getValue().toString();
                datat.setText(name);
                datat1.setText(age);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}