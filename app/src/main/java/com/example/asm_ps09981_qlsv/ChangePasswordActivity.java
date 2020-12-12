package com.example.asm_ps09981_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm_ps09981_qlsv.dao.QuantriDAO;
import com.example.asm_ps09981_qlsv.model.User;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText edtPassmoi, edtPasscu, edtnhaclaipass;
    Button btnLuu, btnClear;
    QuantriDAO qtDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        edtnhaclaipass = findViewById(R.id.edRePassword);
        edtPassmoi = findViewById(R.id.edPassword);
        edtPasscu = findViewById(R.id.edOldPass);
        btnClear = findViewById(R.id.btnClear);
        btnLuu = findViewById(R.id.btnChangePass);
    }

    public void changePassword(View view) {
//        int check = 1;
//        if (edtPassmoi.getText().length() == 0
//                || edtPasscu.getText().length() == 0
//                || edtnhaclaipass.getText().length() == 0) {
//            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin",
//                    Toast.LENGTH_SHORT).show();
//            check = -1;
//        } else {
//            String pass = edtPassmoi.getText().toString();
//            String rePass = edtnhaclaipass.getText().toString();
//            if (!pass.equals(rePass)) {
//                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
//                        Toast.LENGTH_SHORT).show();
//                check = -1;
//            }
//        }
//        return check;

        String old = edtPasscu.getText().toString();
        String nPwd = edtPassmoi.getText().toString();
        String re = edtnhaclaipass.getText().toString();
        String un = LoginActivity.USER.getUsername();
        //kiem loi mk cu
        if (!qtDAO.checkOldPwd(old)) {
            Toast.makeText(ChangePasswordActivity.this, "mat khau cu khong dung", Toast.LENGTH_SHORT).show();
        } else {
            if (!nPwd.equals(re)) {
                Toast.makeText(ChangePasswordActivity.this, "mat khau nhap lai khong trung voi mat khau moi.", Toast.LENGTH_SHORT).show();
            } else {
                if (!qtDAO.updatePwd(new User(nPwd, un))) {
                    Toast.makeText(ChangePasswordActivity.this, "cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                    LoginActivity.USER.setPassword(nPwd);
                    finish();
                } else {
                    Toast.makeText(ChangePasswordActivity.this, "cap nhat that bai", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void clearAll (View view){
        edtnhaclaipass.setText("");
        edtPassmoi.setText("");
        edtPasscu.setText("");
        Toast.makeText(this, "đã xóa trắng", Toast.LENGTH_SHORT).show();
    }
}