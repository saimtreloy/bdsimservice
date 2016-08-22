package com.moodybugs.saim.bdsimservices;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class PackageTeletalk extends AppCompatActivity {

    ButtonAwesome btnPackageTl1, btnPackageTl2, btnPackageTl3, btnPackageTl4, btnPackageTl5;

    private final int REQUEST_CODE_SEND_SMS = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;
    String phoneNumberForSms = null, msgBodyForSms = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeTeletalk);
        setContentView(R.layout.package_teletalk);
        setTitle("Teletalk Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_teletalk);

        Initialization();

        SendButtonClicked(btnPackageTl1);
        SendButtonClicked(btnPackageTl2);
        SendButtonClicked(btnPackageTl3);
        SendButtonClicked(btnPackageTl4);
        SendButtonClicked(btnPackageTl5);
    }


    public void Initialization(){
        btnPackageTl1 = (ButtonAwesome) findViewById(R.id.btnPackageTl1);
        btnPackageTl1 = (ButtonAwesome) findViewById(R.id.btnPackageTl1);
        btnPackageTl2 = (ButtonAwesome) findViewById(R.id.btnPackageTl2);
        btnPackageTl3 = (ButtonAwesome) findViewById(R.id.btnPackageTl3);
        btnPackageTl4 = (ButtonAwesome) findViewById(R.id.btnPackageTl4);
        btnPackageTl5 = (ButtonAwesome) findViewById(R.id.btnPackageTl5);
    }

    //Runtime Permission For Importing Contacts
    public void runtimePermission() {
        if (ButtonClickedChecked == 222) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                sendSms(phoneNumberForSms, msgBodyForSms);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.SEND_SMS)) {
                        Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS}, REQUEST_CODE_SEND_SMS);
                } else {
                    sendSms(phoneNumberForSms, msgBodyForSms);
                }
            }
        }
    }

    public void sendSms(String Number, String msgBody) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(Number, null, msgBody, null, null);
    }

    //Requesting Permission result For Importing Contacts
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (ButtonClickedChecked == 222) {
            if (requestCode == REQUEST_CODE_SEND_SMS) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    sendSms(phoneNumberForSms, msgBodyForSms);
                } else {
                    Toast.makeText(getApplicationContext(), "Contact not processed", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    public void SendButtonClicked(final ButtonAwesome buttonAwesome) {
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == btnPackageTl1.getId()){
                    ButtonClickedChecked = 222;
                    phoneNumberForSms = "154";
                    msgBodyForSms = buttonAwesome.getHint().toString();
                    runtimePermission();
                    Toast.makeText(getApplicationContext(), "Please wait for SMS.", Toast.LENGTH_LONG).show();
                } else {
                    ButtonClickedChecked = 222;
                    phoneNumberForSms = "555";
                    msgBodyForSms = buttonAwesome.getHint().toString();
                    runtimePermission();
                    Toast.makeText(getApplicationContext(), "Please wait for SMS.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
