package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.dao.SinhVienDAO;
import com.example.asm_ps09981_qlsv.model.Lop;
import com.example.asm_ps09981_qlsv.model.SinhVien;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SinhVienInsert1 extends AppCompatActivity {
    EditText edtTenSV, edtNgaySinh, txtAvatar;
    Spinner spnTenLop;
    SinhVienDAO svDAO;
    ArrayList<SinhVien> dsSinhVien;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinhvien_insert1);
        svDAO = new SinhVienDAO(SinhVienInsert1.this);
        ArrayAdapter adapter = new ArrayAdapter
                (SinhVienInsert1.this, android.R.layout.simple_spinner_item, dsSinhVien);
        init();

    }

    //    //anh xa
    private void init() {
        edtTenSV = findViewById(R.id.txtTenSv);
        edtNgaySinh = findViewById(R.id.txtNgaySinh);
        txtAvatar = findViewById(R.id.txtAvatar);

    }


    public void ThemSinhVien(View view) {
        String ten = edtTenSV.getText().toString();
        String ngaysinh = edtNgaySinh.getText().toString();
        String hinh = txtAvatar.getText().toString();
        try {
            SinhVien sinhvienn = new SinhVien( ten,sdf.parse(ngaysinh), hinh);
            if (svDAO.create(sinhvienn)) {
                Toast.makeText(this, "thêm Thành công", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "thêm thất bại.hãy thử lại", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
