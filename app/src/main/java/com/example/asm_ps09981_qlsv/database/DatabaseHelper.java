package com.example.asm_ps09981_qlsv.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.dao.StudentDAO;


public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Student";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(LopDAO.SQL_LOP);
  //      db.execSQL(StudentDAO.SQL_STUDENT);

        String sql = "CREATE TABLE LOP(MaLop text primary key, tenlop text)"; //cau lenh tao bang
        db.execSQL(sql);
        sql = "INSERT INTO LOP VALUES('11111', 'mobi')"; //du lieu mau co san
        db.execSQL(sql);
        sql = "INSERT INTO LOP VALUES('lt14777', 'laptop')";//du lieu mau co san
        db.execSQL(sql);
        sql = "INSERT INTO LOP VALUES('LT15201', 'dig')";//du lieu mau co san
        db.execSQL(sql);

        //cau lenh tao bang SINHVIEN (co khoa phu va khoa chinh)
         sql = "CREATE TABLE SINHVIEN(MaSv integer primary key autoincrement,"+
                "TenSv text,NgaySinh date,Hinh text,"+ "MaLop text references LOP(MaLop))";
        db.execSQL(sql);
        sql = "INSERT INTO SINHVIEN(TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES('Minh nhi ', '2000-3-4','ic_sinhvien.png','lt14643')";//rang buoc ve tham chieu.ma lop phai giong voi du lieu tren TABLE LOP
        db.execSQL(sql);
        sql = "INSERT INTO SINHVIEN(TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES('anh bao ', '2000-3-5','ic_laucher_background.xml','lt14777')";//rang buoc ve tham chieu
        db.execSQL(sql);
        sql = "INSERT INTO SINHVIEN(TenSv,NgaySinh,Hinh,MaLop)"+
                "VALUES('anh duc ', '2000-5-8','logo.png','LT15201')";//rang buoc ve tham chieu
        db.execSQL(sql);

        //CAU LENH TAO BANG QUANTRI
        sql = "CREATE TABLE QUANTRI(username text primary key, password text)";
        db.execSQL(sql);
        sql = "INSERT INTO QUANTRI VALUES('admin', '123')";
        db.execSQL(sql);
        sql = "INSERT INTO QUANTRI VALUES('hieu', '123')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //thuc thi khi doi version.
        db.execSQL("DROP TABLE IF EXISTS SINHVIEN");
        db.execSQL("DROP TABLE IF EXISTS LOP");
        db.execSQL("DROP TABLE IF EXISTS QUANTRI");
        onCreate(db);
    }
}

