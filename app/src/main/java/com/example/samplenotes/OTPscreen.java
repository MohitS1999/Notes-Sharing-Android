package com.example.samplenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPscreen extends AppCompatActivity {

    private EditText etPhone;
    private Button sendBtn;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpscreen);
        etPhone = findViewById(R.id.etPhone);
        sendBtn = findViewById(R.id.sendBtn);
        progressBar = findViewById(R.id.prog);
        auth = FirebaseAuth.getInstance();
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPhone.getText().toString().trim().isEmpty()){
                    Toast.makeText(OTPscreen.this,"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                }else if (etPhone.getText().toString().trim().length() != 10){
                    Toast.makeText(OTPscreen.this,"Invalid Type Phone Number",Toast.LENGTH_SHORT).show();
                }else{
                    otpSend();
                }
            }
        });
    }

    private void otpSend() {
        progressBar.setVisibility(View.VISIBLE);
        sendBtn.setVisibility(View.INVISIBLE);

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                progressBar.setVisibility(View.GONE);
                sendBtn.setVisibility(View.VISIBLE);
                Toast.makeText(OTPscreen.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                // Show a message and update the UI
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                progressBar.setVisibility(View.GONE);
                sendBtn.setVisibility(View.VISIBLE);
                Toast.makeText(OTPscreen.this,"OTP Sent",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OTPscreen.this,OTPVerifyActivity.class);
                intent.putExtra("phone",etPhone.getText().toString().trim());
                intent.putExtra("verificationId",verificationId);
                startActivity(intent);
            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91"+etPhone.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}