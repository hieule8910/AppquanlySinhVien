package com.example.asm_ps09981_qlsv.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.asm_ps09981_qlsv.database.DatabaseHelper;
import com.example.asm_ps09981_qlsv.model.Lop;

import java.util.ArrayList;
import java.util.List;

//muc dich: tao CRUD. Create, Read, Update and Delete.
public class LopDAO {
    DatabaseHelper helper;
//    private SQLiteDatabase db;
//    private DatabaseHelper dbHelper;

//    public static final String TABLE_NAME = "Lop";
//    public static final String SQL_LOP = "CREATE TABLE Lop(maLop text primary key,tenLop text);";

    //hàm khởi tạo. constructor truyen context vao.cho phu hop voi database
    public LopDAO(Context context) {
        helper = new DatabaseHelper(context);
    }
    public ArrayList<Lop>readAll(){
        ArrayList<Lop> data = new ArrayList<>();
        //tao database
        SQLiteDatabase db = helper.getReadableDatabase();
        //tao con tro de lay du lieu
        Cursor cs = db.rawQuery("select*from LOP",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String malop= cs.getString(0);
            String tenlop= cs.getString(1);

            data.add(new Lop(malop,tenlop));
            cs.moveToNext();
        }
        cs.close();
        return data;
    }

    //them du lieu
    public boolean create(Lop lop) {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaLop", lop.getMalop());
        values.put("tenlop", lop.getTenlop());
        long row = db.insert("LOP", null, values);
        if (row>0){
            return true;
        }else{
            return false;
        }
    }
//
////    //xoa lop
//    public int deleteLop(String maLop){
//        int result = db.delete(TABLE_NAME,"maLop=?",new String[]{maLop});
//        if(result==0){
//            return -1;
//        }
//        return 1;
//    }

    //sua du lieu lai.
    public boolean update(String ma,String tenlop){
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("tenlop",tenlop);
        int row=db.update("LOP",values,"MaLop=?",new String[]{ma});
        return row>0;
    }
    //xoa du lieu
    public boolean delete(String ma) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        int row = db.delete("LOP", "MaLop=?", new String[]{ma});
        if (row > 0) {
            return true;

        } else {
            return false;
        }
    }
}
