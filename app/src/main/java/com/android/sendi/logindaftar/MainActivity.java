package com.android.sendi.logindaftar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText txtEmail, txtPassword, txtconfirmPassword, txtFullName, txtBirthday, txtTelepon;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        txtconfirmPassword = findViewById(R.id.txt_confirm_password);
        txtFullName = findViewById(R.id.txt_fullname);
        txtBirthday = findViewById(R.id.txt_birthday);
//        txtTelepon = findViewById(R.id.txt_telepon);

        btnDaftar = findViewById(R.id.btn_daftar);
    }

    private boolean isValidEmaillId(String email){

        return Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+").matcher(email).matches();
    }

    //    validation
    private boolean adaError() {
        boolean ada = false;
        if (txtEmail.getText().toString().isEmpty()) {
            ada = true;
            txtEmail.setError("Tidak bole kosong");
        }if (txtPassword.getText().toString().isEmpty()) {
            ada = true;
            txtPassword.setError("Tidak bole kosong");
        }if (txtconfirmPassword.getText().toString().isEmpty()) {
            ada = true;
            txtconfirmPassword.setError("Tidak bole kosong");
        }if (txtFullName.getText().toString().isEmpty()) {
            ada = true;
            txtFullName.setError("Tidak bole kosong");
        }if (txtBirthday.getText().toString().isEmpty()) {
            ada = true;
            txtBirthday.setError("Tidak bole kosong");
        }
//        if
//                (txtTelepon.getText().toString().isEmpty()) {
//            ada = true;
//            txtTelepon.setError("Tidak bole kosong");
//        }

        //validasi email
        if(!isValidEmaillId(txtEmail.getText().toString().trim())){
//            Toast.makeText(getApplicationContext(), "Valid Email Address.", Toast.LENGTH_SHORT).show();
            txtEmail.setError("InValid Email Address");
        }

        return ada;

    }

    public void daftar(View v) {
        if(!adaError()) {
            Toast.makeText(
                    getApplicationContext(),
                    txtEmail.getText() + "\n" + txtFullName.getText() + "\n" + txtTelepon.getText(),
                    Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("email", txtEmail.getText().toString());
            bundle.putString("nama", txtFullName.getText().toString());
            bundle.putString("telepon", txtTelepon.getText().toString());

            Intent i = new Intent(this,LoginActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
