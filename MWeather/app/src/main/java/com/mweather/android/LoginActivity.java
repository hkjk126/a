package com.mweather.android;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    private SharedPreferences firstIn_sp;
    private SharedPreferences register_sp;
    private SharedPreferences auto_login_sp;
    private boolean isFirstIn;
    private String input_username;
    private String input_psw;
    private EditText edt_username;
    private EditText edt_password;
    private CheckBox cb_auto;
    private boolean isAutoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        edt_username = (EditText) findViewById(R.id.login_username);
        edt_password = (EditText) findViewById(R.id.login_psw);
        cb_auto = (CheckBox) findViewById(R.id.auto_login);
        Button bt_login = (Button) findViewById(R.id.login);
        firstIn_sp = getSharedPreferences("firstIn_spf", MODE_PRIVATE);
        auto_login_sp = getSharedPreferences("auto_login", MODE_PRIVATE);
        isAutoLogin = auto_login_sp.getBoolean("isAutoLogin", false);

        isFirstIn = firstIn_sp.getBoolean("isFirstIn", true);
        if (isFirstIn) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            SharedPreferences.Editor editor = firstIn_sp.edit();
            editor.putBoolean("isFirstIn", false);
            editor.commit();
            LoginActivity.this.finish();
        }

        if (isAutoLogin) {
            cb_auto.setChecked(true);
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            LoginActivity.this.finish();

        }else{
            bt_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cb_auto.isChecked()) {
                        SharedPreferences.Editor edit=auto_login_sp.edit();
                        edit.putBoolean("isAutoLogin", true);
                        edit.commit();
                    }
                    input_username = edt_username.getText().toString();
                    input_psw = edt_password.getText().toString();
                    if(input_username.trim().equals("") || input_psw.trim().equals("")) {
                        Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    register_sp=getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
                    String savedUsername = register_sp.getString("username","");
                    String savedPassword = register_sp.getString("password","");

                    if(input_username.trim().equals(savedUsername) && input_psw.trim().equals(savedPassword)) {
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "用户名或者密码错误,请确认信息或者去注册", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

            });

        }

    }
    public void register(View view) {
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}