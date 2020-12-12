package com.example.asm_ps09981_qlsv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asm_ps09981_qlsv.LoginActivity;
import com.example.asm_ps09981_qlsv.database.DatabaseHelper;
import com.example.asm_ps09981_qlsv.model.Lop;
import com.example.asm_ps09981_qlsv.model.User;

public class QuantriDAO {
    DatabaseHelper helper;

    public QuantriDAO(Context context) {
        helper = new DatabaseHelper(context);
    }

    public boolean checkLogin(User user) {
        //tao database
        SQLiteDatabase db = helper.getReadableDatabase();
        //tao con tro de lay du lieu
        Cursor cs = db.rawQuery("SELECT * FROM QUANTRI WHERE username=? AND password=?",
                new String[]{user.getUsername(), user.getPassword()});
        if (cs.getCount() <= 0) {
            return false;
        }
        return true;
    }
        public boolean checkOldPwd(String oldPwd) {
        //lay ra username --> check trongdb xem pass cua username dug hay ko
            String pwd= LoginActivity.USER.getPassword();
            if(!oldPwd.equals(pwd)){
                return false;
            }
            return true;
        }

    public boolean updatePwd(User user) {
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues value = new ContentValues();
        value.put("password",user.getPassword());
        int row=db.update("QUANTRI",value,"username=?",new String[]{user.getUsername()});
        return row>0;
    }


    }









