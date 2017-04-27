package com.example.soumayarebai.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] students={"Soumaya","Fatma","Omar","Chaima","Chadi"};
    ListView gradesList;
    AutoCompleteTextView student;
    HashMap<String,String[]> allGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allGrades=new HashMap<>();
        allGrades.put("Chaima",new String[]{"12","16","4.5","18","20"});
        allGrades.put("Fatma",new String[]{"12","16","4.5","18","20"});
        allGrades.put("Omar",new String[]{"12","14","5","18","17"});
        allGrades.put("Soumaya",new String[]{"10.75","16","11","18","20"});
        allGrades.put("Chadi",new String[]{"9.25","3.25","4.5","8","9"});

        setContentView(R.layout.activity_main);
        gradesList=(ListView) findViewById(R.id.gradesList);
        student= (AutoCompleteTextView) findViewById(R.id.students);
      //  ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,grades);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,students);
        student.setAdapter(adapter2);

       // gradesList.setAdapter(adapter1);
        gradesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView gradeView =(TextView) view.findViewById(R.id.grade);
                float grade = Float.valueOf(gradeView.getText().toString());
                if(grade>=10) toast("pass");
                else toast("fail");
            }
        });

        student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
               // String studentName=students[i] // i ned donne pas le rang de l'etudiant plutot le rang kif yamle affichage
                String studentName=((TextView)view).getText().toString();
                ListAdapter adapter = new MyLineAdapter(MainActivity.this, allGrades.get(studentName));
                gradesList.setAdapter(adapter);
                //toast(studentName);

            }
        });
    }
    public void toast(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}