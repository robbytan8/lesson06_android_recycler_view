package com.robby.lesson06_android_recycler_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText txtUsername;
    @BindView(R.id.et_password)
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void loginAction() {
        if (!TextUtils.isEmpty(txtUsername.getText().toString().trim()) && !TextUtils.isEmpty(txtPassword.getText().toString().trim())) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(this, "Please provide valid username and password", Toast.LENGTH_SHORT).show();
        }
    }
}
