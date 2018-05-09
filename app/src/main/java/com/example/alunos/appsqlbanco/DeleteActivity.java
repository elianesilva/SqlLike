package com.example.alunos.appsqlbanco;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText txtId;
    Button btn_delet_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myDb = new DataBaseHelper(this);
        txtId = (EditText) findViewById(R.id.editText);
        btn_delet_user = (Button) findViewById(R.id.button3);

        btn_delet_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }

    private void ClickMe(){
        String id = txtId.getText().toString();
        int result = myDb.deletData(id);
        Toast.makeText(this, "Dados deletados com sucesso.", Toast.LENGTH_SHORT).show();
    }

}
