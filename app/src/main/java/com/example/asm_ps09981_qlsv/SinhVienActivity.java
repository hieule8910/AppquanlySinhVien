package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.asm_ps09981_qlsv.adapter.SinhVienAdapter;
import com.example.asm_ps09981_qlsv.dao.SinhVienDAO;
import com.example.asm_ps09981_qlsv.model.SinhVien;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SinhVienActivity extends AppCompatActivity {
    ListView lvSV;
    FloatingActionButton btnInsert;
    ArrayList<SinhVien> data = new ArrayList<>();
    SinhVienAdapter adapter;
    SinhVienDAO DAO;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);
        btnInsert = findViewById(R.id.fbInsertSv);
        lvSV = (ListView) findViewById(R.id.lvSinhVien);
        DAO = new SinhVienDAO(SinhVienActivity.this);
        //get Data
        data = DAO.readAll();
        //set adapter
        adapter = new SinhVienAdapter(SinhVienActivity.this, data);
        lvSV.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogInsert();
            }
        });
    }

    private void showDialogInsert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SinhVienActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.sinhvien_insert, null);
        builder.setView(view);
        final EditText etTen = view.findViewById(R.id.txtTenSv);
        final EditText etNs = view.findViewById(R.id.txtNgaySinh);
        final EditText etHinh = view.findViewById(R.id.txtAvatar);
        final Spinner spnLop = view.findViewById(R.id.spnLopHoc);
        Button btThem = view.findViewById(R.id.btnThemSv);
        Button btnNhapLai = view.findViewById(R.id.btnNhapLaiSv);

        SinhVienDAO daoSV = new SinhVienDAO(SinhVienActivity.this);
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        dsSV = daoSV.readAll();
        ArrayAdapter adapterSV = new ArrayAdapter(SinhVienActivity.this,
                android.R.layout.simple_spinner_item, dsSV);
        spnLop.setAdapter(adapterSV);
        final AlertDialog dialog = builder.create();



        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etTen.getText().toString();
                String ns = etNs.getText().toString();
                String hinh = etHinh.getText().toString();
                SinhVien svn = (SinhVien) spnLop.getSelectedItem();
                String maLop = svn.getMaLopHoc();
                try {
                    SinhVien sv = new SinhVien(ten, sdf.parse(ns), hinh, maLop);
                    if(DAO.create(sv)){
                        Toast.makeText(SinhVienActivity.this,"Thêm thành công!!!!!!", Toast.LENGTH_LONG).show();
                        data.clear();
                        data.addAll(DAO.readAll());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(SinhVienActivity.this,"thêm Thất bại!!!!!!", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(DAO.readAll());
        adapter.notifyDataSetChanged();
    }

}
