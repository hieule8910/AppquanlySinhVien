package com.example.asm_ps09981_qlsv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.asm_ps09981_qlsv.database.DatabaseHelper;
import com.example.asm_ps09981_qlsv.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "Student";
//    public static final String SQL_STUDENT =
//            "CREATE TABLE Student(maSV text primary key, maLop text, tenSV text);";

    public StudentDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public int deleteSinhvien(String maSV){
        int result = db.delete(TABLE_NAME,"maSV=?",new String[]{maSV});
        if(result==0){
            return -1;
        }
        return 1;
    }

    public boolean insertStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put("maSV", student.getMaSV());
        values.put("maLop", student.getMaLop());
        values.put("tenSV", student.getTenSV());

        long result = db.insert(TABLE_NAME, null, values);
        try {
            if (result == -1) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Student> getAllStudent() {

        List<Student> dsStudent = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            Student student = new Student();
            student.setMaSV(c.getString(0));
            student.setMaLop(c.getString(1));
            student.setTenSV(c.getString(2));
            dsStudent.add(student);
            Log.d("//=====", student.toString());
            c.moveToNext();
        }
        c.close();
        return dsStudent;

    }
}