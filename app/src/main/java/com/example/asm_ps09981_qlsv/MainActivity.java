package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //Button btnaddClass;
    ImageView ivQLSV,ivQLLH,ivExit,ivDoimk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivQLSV=findViewById(R.id.imgQLSV);
        ivQLLH=findViewById(R.id.imgQLLop);
        ivDoimk=findViewById(R.id.imgDoiMK);
        ivExit=findViewById(R.id.imgExit);

    }

    public void QUANLYLOPHOC(View view) {
        startActivity(new Intent(MainActivity.this,ListLop_Activity.class));
    }

    public void QUANLYSINHVIEN(View view) {
        startActivity(new Intent(MainActivity.this,SinhVienActivity.class));
    }

    public void DOIMATKHAU(View view) {
        startActivity(new Intent(MainActivity.this,ChangePasswordActivity.class));
    }

    public void THOATRA(View view) {
        //Khoi tao lai Activity main
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);

        // Tao su kien ket thuc app
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startActivity(startMain);
        finish();
    }


}

