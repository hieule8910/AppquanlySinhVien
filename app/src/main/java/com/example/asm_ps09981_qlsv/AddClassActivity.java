package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.model.Lop;

import java.util.ArrayList;

public class AddClassActivity extends AppCompatActivity {

    EditText edMalop, edTenLop;
    LopDAO lopDAO;
    ArrayList<Lop> dsLopHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        lopDAO =  new LopDAO(AddClassActivity.this);
        ArrayAdapter adapter=new ArrayAdapter
                (AddClassActivity.this,android.R.layout.simple_spinner_item,dsLopHoc);
        init();

    }
//
//    //anh xa
    private void init() {
        edMalop= findViewById(R.id.edMalop);
        edTenLop= findViewById(R.id.edTenlop);
    }

//    //ham de thêm lớp.bat su kien khi click
    public void AddnewLop(View view) {
        String ten=edTenLop.getText().toString();
        String ma=edMalop.getText().toString();
        Lop lop = new Lop(ma,ten);
        if(lopDAO.create(lop)){
            Toast.makeText(this,"thêm Thành công",Toast.LENGTH_LONG).show();
            finish();
        } else{
            Toast.makeText(this,"thêm thất bại.hãy thử lại",Toast.LENGTH_LONG).show();
        }
    }
//
//
    public void xemLop(View view) {
        edMalop.setText("");
        edTenLop.setText("");
        Toast.makeText(this,"Da xoa trang.",Toast.LENGTH_LONG).show();
    }
}
