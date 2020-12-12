package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.model.Lop;

import java.util.ArrayList;

public class EditClassActivity extends AppCompatActivity {
    EditText edMalop, edTenLop;
    LopDAO lopDAO;
    ArrayList<Lop> dsLopHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class);
        lopDAO =  new LopDAO(EditClassActivity.this);
        ArrayAdapter adapter=new ArrayAdapter
                (EditClassActivity.this,android.R.layout.simple_spinner_item,dsLopHoc);
        init();
    }
    private void init() {
        edMalop= findViewById(R.id.edMalop);
        edTenLop= findViewById(R.id.edTenlop);
    }
}
