package com.example.alunos.appsqlbanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alunos on 18/04/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Empregados.db";
    public static final String TABLE_NAME = "Empregados_table";

    public static final  String col_1 = "ID";
    public static final  String col_2 = "Nome";
    public static final  String col_3 = "Sobrenome";
    public static final  String col_4 = "Profissao";

    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SOBRENOME TEXT, PROFISSSÂO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
    public  boolean insertData(String nome, String sobrenome, String profissao){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, nome);
        contentValues.put(col_3, sobrenome);
        contentValues.put(col_4, profissao);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }
}
