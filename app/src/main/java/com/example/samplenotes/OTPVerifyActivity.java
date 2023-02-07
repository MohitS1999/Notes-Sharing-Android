package com.example.samplenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPVerifyActivity extends AppCompatActivity {


    private Button verifyBtn;
    private TextView resendBtn;
    private TextView phoneNo;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private ProgressBar progressBar;

    private String verificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);

        verifyBtn = findViewById(R.id.verifyBtn);
        resendBtn = findViewById(R.id.resendOTP);
        phoneNo = findViewById(R.id.phoneNo);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        progressBar = findViewById(R.id.progrssVerify);

        phoneNo.setText(String.format("+91-%s",getIntent().getStringExtra("phone")));
        verificationId = getIntent().getStringExtra("verificationId");
        editTextInput();
        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTPVerifyActivity.this,"OTP send successfully",Toast.LENGTH_SHORT).show();
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                if (et1.getText().toString().trim().isEmpty() ||
                        et2.getText().toString().trim().isEmpty() ||
                        et3.getText().toString().trim().isEmpty() ||
                        et4.getText().toString().trim().isEmpty() ||
                        et5.getText().toString().trim().isEmpty() ||
                        et6.getText().toString().trim().isEmpty()
                ){
                    progressBar.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(OTPVerifyActivity.this,"OTP is not valid",Toast.LENGTH_SHORT).show();
                }else{
                    if (verificationId != null){
                        String code = et1.getText().toString().trim() +
                                et2.getText().toString().trim() +
                                et3.getText().toString().trim() +
                                et4.getText().toString().trim() +
                                et5.getText().toString().trim() +
                                et6.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                        FirebaseAuth
                                .getInstance()
                                .signInWithCredential(credential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent = new Intent(OTPVerifyActivity.this,MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    progressBar.setVisibility(View.GONE);
                                    progressBar.setVisibility(View.VISIBLE);
                                }else{
                                    progressBar.setVisibility(View.GONE);
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(OTPVerifyActivity.this,"OTP is not valid",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });

    }

    private void editTextInput() {

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et4.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                et6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}