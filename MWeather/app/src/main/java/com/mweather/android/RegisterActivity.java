package com.mweather.android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.DialogInterface.OnClickListener;

public class RegisterActivity extends AppCompatActivity {
    private SharedPreferences register_sp;
    private String username;
    private String password;//密码
    private String password2;//确认密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
    }
    public void onRegister(View v){
        EditText edt_username = (EditText) findViewById(R.id.edt_username);
        EditText edt_password = (EditText) findViewById(R.id.edt_psw);
        EditText edt_password2 = (EditText) findViewById(R.id.edt_psw2);
        username = edt_username.getText().toString();
        password = edt_password.getText().toString();
        password2 = edt_password2.getText().toString();
        if(username.trim().equals("") || password.trim().equals("") || password2.trim().equals("")){
            Toast.makeText(RegisterActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (!(password.trim().equals(password2.trim()))) {
            Toast.makeText(RegisterActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        //进入注册的Dialog
        Dialog dialog=new AlertDialog.Builder(RegisterActivity.this)
                .setTitle("注册")
                .setMessage("你确定注册信息吗？")
                .setPositiveButton("确定", new  OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        register_sp=getSharedPreferences("userInfo",MODE_PRIVATE);
                        SharedPreferences.Editor edit=register_sp.edit();
                        edit.putString("username", username);
                        edit.putString("password", password);
                        edit.commit();

                        Toast.makeText(RegisterActivity.this, "恭喜，注册成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("取消", new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                    }
                }).create();//创建一个dialog
        dialog.show();//显示对话框，否者不成功
    }
    public void onLogin(View v){
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
