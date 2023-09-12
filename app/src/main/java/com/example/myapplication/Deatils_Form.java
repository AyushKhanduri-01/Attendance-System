package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Deatils_Form extends AppCompatActivity {
    EditText name,section,rollno,id;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatils_form);
        name=findViewById(R.id.name);
        section=findViewById(R.id.section);
        rollno=findViewById(R.id.rollno);
        id=findViewById(R.id.rollno);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String ,String> map = new HashMap<>();
                map.put("Name",name.getText().toString());
                map.put("Section",section.getText().toString());
                map.put("Roll no",rollno.getText().toString());
                map.put("Student Id",id.getText().toString());

                try {

                   FirebaseFirestore.getInstance().collection("Student Data").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(Deatils_Form.this, "Done", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                catch (Exception e){
                    e.toString();
                }


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}