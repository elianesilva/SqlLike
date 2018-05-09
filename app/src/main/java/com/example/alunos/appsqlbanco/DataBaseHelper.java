package com.example.alunos.appsqlbanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String col_5 = "idade";

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
    public  boolean insertData(String nome, String sobrenome, String idade, String profissao){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, nome);
        contentValues.put(col_3, sobrenome);
        contentValues.put(col_4, profissao);
        contentValues.put(col_5, idade);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Integer deletData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME, "ID=?", new String[]{id});
        return i;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * From " + TABLE_NAME, null);
        return res;
    }
    public  boolean updatData(String id, String nome, String sobrenome, String idade, String profissao ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, nome);
        contentValues.put(col_3, sobrenome);
        contentValues.put(col_4, profissao);
        contentValues.put(col_5, idade);
        int result = sqLiteDatabase.update(TABLE_NAME, contentValues, "id", new String[]{id});
        if(result>0){
            return false;
        }else {
            return true;
        }
    }
}
