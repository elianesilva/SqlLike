package com.example.alunos.appsqlbanco;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update2Activity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText id, nome, sobrenome, idade, profissao;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update2);

        myDb = new DataBaseHelper(this);

        id = (EditText) findViewById(R.id.id_id);
        nome = (EditText) findViewById(R.id.id_nome);
        sobrenome = (EditText) findViewById(R.id.id_sobrenome);
        idade = (EditText) findViewById(R.id.id_idade);
        profissao = (EditText) findViewById(R.id.id_profissao);
        btn_update = (Button) findViewById(R.id.button);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickMe();
            }
        });
    }
    private void ClickMe(){
        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        String id_pessoa = id.getText().toString();
        String nome_pessoa = nome.getText().toString();
        String sobrenome_pessoa = sobrenome.getText().toString();
        String idade_pessoa = idade.getText().toString();
        String profissao_pessoa = profissao.getText().toString();

        boolean result = myDb.updatData();
        if(result == true){

        }


    }
}
