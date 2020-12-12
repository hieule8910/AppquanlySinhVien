package com.example.asm_ps09981_qlsv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.asm_ps09981_qlsv.database.DatabaseHelper;
import com.example.asm_ps09981_qlsv.model.Lop;
import com.example.asm_ps09981_qlsv.model.SinhVien;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//muc dich: tao CRUD. Create, Read, Update and Delete.
public class SinhVienDAO {
  //  private SQLiteDatabase db;
    DatabaseHelper dbHelper;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

//    public static final String TABLE_NAME = "Lop";
//    public static final String SQL_LOP = "CREATE TABLE Lop(maLop text primary key,tenLop text);";

    //hàm khởi tạo
    public SinhVienDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public ArrayList<SinhVien>readAll(){
        ArrayList<SinhVien> data = new ArrayList<>();
        //tao database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //tao con tro de lay du lieu
        Cursor cs = db.rawQuery("select * from SINHVIEN",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int masv= cs.getInt(0);
            String tensv= cs.getString(1);
            String ngaysinh= cs.getString(2);
            String hinh= cs.getString(3);
            String malop= cs.getString(4);
            try {
                 data.add(new SinhVien(masv,tensv,sdf.parse(ngaysinh),hinh,malop));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            cs.moveToNext();
        }
        cs.close();
        return data;
    }

    //them du lieu
    public boolean create(SinhVien sv) {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSv", sv.getTenSv());
        values.put("NgaySinh", sdf.format(sv.getNgaySinh()));
        values.put("Hinh", sv.getHinh());
        values.put("MaSv", sv.getMaSv());
        values.put("MaLop", sv.getMaLopHoc());
        long row = db.insert("SINHVIEN", null, values);
        return (row>0);

    }

    public boolean update(String ma,String ten,String ngaysinh,String masv){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("TenSv",ten);
        values.put("NgaySinh",ngaysinh);
        int row= db.update("SINHVIEN",values,"MaSv=?",new String[]{ma});
        return  row>0;
    }
    public boolean delete(String ma) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        int row = db.delete("SINHVIEN", "MaSv=?", new String[]{ma});
        if (row > 0) {
            return true;

        } else {
            return false;
        }
    }

}
