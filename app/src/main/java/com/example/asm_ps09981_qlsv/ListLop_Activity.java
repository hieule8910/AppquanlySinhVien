package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.asm_ps09981_qlsv.adapter.LopAdapter;
import com.example.asm_ps09981_qlsv.dao.LopDAO;
import com.example.asm_ps09981_qlsv.model.Lop;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListLop_Activity extends AppCompatActivity {

    ListView lvLop;
    FloatingActionButton btnInsert;
    ArrayList<Lop> data = new ArrayList<>();
    LopAdapter adapter;
    LopDAO lopDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lop_);
        btnInsert= findViewById(R.id.fbInsertLop);
        lvLop = (ListView) findViewById(R.id.lvLop);
        lopDAO = new LopDAO(ListLop_Activity.this);
        //Get Data
        data = lopDAO.readAll();
        //set adapter
        adapter = new LopAdapter(ListLop_Activity.this, data);
        lvLop.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListLop_Activity.this,AddClassActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        data.clear();
        data.addAll(lopDAO.readAll());
        adapter.notifyDataSetChanged();
    }
}
