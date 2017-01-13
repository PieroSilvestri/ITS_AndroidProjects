package com.example.piero.sqliteprova;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.IntentFilter;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText editName, editSurname, editMarks, editId;
    Button btnAddData;
    Button btnViewAll;
    Button btnUpdateData;
    Button btnDelete;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editSurname = (EditText)findViewById(R.id.editText_surname);
        editMarks = (EditText) findViewById(R.id.editText_marks);
        editId = (EditText) findViewById(R.id.editId);

        btnAddData = (Button)findViewById(R.id.button);
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });

        btnViewAll = (Button)findViewById(R.id.button2);
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAll();
            }
        });

        btnUpdateData = (Button)findViewById(R.id.button3);
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateDate();
            }
        });

        btnDelete = (Button)findViewById(R.id.button4);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteData();
            }
        });

    }

    public void AddData(){
       boolean isInserted = myDB.insertData(editName.getText().toString(), editSurname.getText().toString(),
               editMarks.getText().toString());

        if(isInserted){
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
        }
    }

    public void viewAll(){
        Cursor res = myDB.getAllData();
        if(res.getCount() == 0){
            showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID: " + res.getString(0) + "\n");
            buffer.append("Name: " + res.getString(1) + "\n");
            buffer.append("Surname: " + res.getString(2) + "\n");
            buffer.append("Marks: " + res.getString(3) + "\n\n");
        }

        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void UpdateDate(){
        boolean isUpdate = myDB.updateData(editId.getText().toString(), editName.getText().toString(),
                editSurname.getText().toString(), editMarks.getText().toString());
        if(isUpdate){
            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();
        }

    }

    public void DeleteData(){
        Integer deleteRows = myDB.deleteData(editId.getText().toString());
        if(deleteRows > 0){
            Toast.makeText(MainActivity.this, "Data Delete", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Data Not Delete", Toast.LENGTH_LONG).show();
        }
    }
}
