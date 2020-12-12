package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asm_ps09981_qlsv.dao.QuantriDAO;
import com.example.asm_ps09981_qlsv.model.User;

public class LoginActivity extends AppCompatActivity {
    Button btnDangnhap,btnDoimatkhau;
    EditText edtUser,edtPass;
    ImageView img3;
    TextView td;
    CheckBox ckRem;
    QuantriDAO qtDAO;
    public static User USER=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        qtDAO=new QuantriDAO(LoginActivity.this);
        btnDangnhap= findViewById(R.id.btnLogin);
        btnDoimatkhau= findViewById(R.id.btnDoimk);
        edtPass= findViewById(R.id.edtPass);
        edtUser= findViewById(R.id.edtUser);
       // img3= findViewById(R.id.imageView3);
        td= findViewById(R.id.tvtieude);
        ckRem= findViewById(R.id.checkboxRemember);
    }

    public void submit(View view) {
        String user= edtUser.getText().toString();
        String pwd= edtPass.getText().toString();
        boolean check = ckRem.isChecked();
        User username= new User(user,pwd);
        if(qtDAO.checkLogin(username)){
            luuTT(user,pwd,check);
            USER=username;
            Toast.makeText(this, "Dang nhap thanh cong!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "Dang nhap that bai!!!", Toast.LENGTH_LONG).show();
        }
//        luuTT(user,pwd,check);
//        Toast.makeText(LoginActivity.this, "Username là:"+user+", Password là :"+pwd, Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//        startActivity(intent);
    }


    public void doimk(View view) {
        Intent intent=new Intent(getApplicationContext(),ChangePasswordActivity.class);
        startActivity(intent);
    }
    //ham luu thong tin
    private void luuTT(String un,String pwd,boolean check) {
        SharedPreferences preferences=getSharedPreferences("thongtin.dat",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (check){
            editor.putString("username",un);
            editor.putString("password",pwd);
            editor.putBoolean("check",check);
        }else {
            //xoa tinh trang truoc do
            editor.clear();
    }
        editor.commit();
        //luu lai toan bo
    }

    //ham load thong tin login tren form
    private void loadData() {
        SharedPreferences preferences=getSharedPreferences("thongtin.dat",MODE_PRIVATE);
        boolean check = preferences.getBoolean("check", false);
        if (check){
           edtUser.setText(preferences.getString("username",""));
           edtPass.setText(preferences.getString("password",""));
           ckRem.setChecked(check);
        }
    }
}

