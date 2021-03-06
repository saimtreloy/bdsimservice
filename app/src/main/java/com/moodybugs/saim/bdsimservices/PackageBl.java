package com.moodybugs.saim.bdsimservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class PackageBl extends AppCompatActivity {

    ButtonAwesome btnPackageBl1, btnPackageBl2, btnPackageBl3, btnPackageBl4, btnPackageBl5, btnPackageBl6,
            btnPackageBl7, btnPackageBl8, btnPackageBl9, btnPackageBl10,btnPackageBl11, btnPackageBl12;

    private final int REQUEST_CODE_SEND_SMS = 1;
    private final int REQUEST_CODE_CALL = 1;
    final public int PICK_CONTACT = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;
    String phoneNumberForSms = null, msgBodyForSms = null;
    int editTextCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeBl);
        setContentView(R.layout.package_bl);
        setTitle("Banglalink Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_gp);

        Initialization();

        CallButtonClicked(btnPackageBl1);
        CallButtonClicked(btnPackageBl2);
        CallButtonClicked(btnPackageBl3);
        CallButtonClicked(btnPackageBl4);
        CallButtonClicked(btnPackageBl5);
        CallButtonClicked(btnPackageBl6);
        CallButtonClicked(btnPackageBl7);
        CallButtonClicked(btnPackageBl8);
        CallButtonClicked(btnPackageBl9);
        CallButtonClicked(btnPackageBl10);
        CallButtonClicked(btnPackageBl11);
        CallButtonClicked(btnPackageBl12);

    }


    public void Initialization(){
        btnPackageBl1 = (ButtonAwesome) findViewById(R.id.btnPackageBl1);
        btnPackageBl1 = (ButtonAwesome) findViewById(R.id.btnPackageBl1);
        btnPackageBl2 = (ButtonAwesome) findViewById(R.id.btnPackageBl2);
        btnPackageBl3 = (ButtonAwesome) findViewById(R.id.btnPackageBl3);
        btnPackageBl4 = (ButtonAwesome) findViewById(R.id.btnPackageBl4);
        btnPackageBl5 = (ButtonAwesome) findViewById(R.id.btnPackageBl5);
        btnPackageBl6 = (ButtonAwesome) findViewById(R.id.btnPackageBl6);
        btnPackageBl7 = (ButtonAwesome) findViewById(R.id.btnPackageBl7);
        btnPackageBl8 = (ButtonAwesome) findViewById(R.id.btnPackageBl8);
        btnPackageBl9 = (ButtonAwesome) findViewById(R.id.btnPackageBl9);
        btnPackageBl10 = (ButtonAwesome) findViewById(R.id.btnPackageBl10);
        btnPackageBl11 = (ButtonAwesome) findViewById(R.id.btnPackageBl11);
        btnPackageBl12 = (ButtonAwesome) findViewById(R.id.btnPackageBl12);
    }

    //Runtime Permission For Importing Contacts
    public void runtimePermission() {
        if (ButtonClickedChecked == 333) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                makeCall(phoneNumber);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                        Toast.makeText(getApplicationContext(), "Permission required", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
                } else {
                    makeCall(phoneNumber);
                }
            }
        }else if (ButtonClickedChecked == 222) {
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

    public void makeCall(String Number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    public void sendSms(String Number, String msgBody) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(Number, null, msgBody, null, null);
    }

    //Requesting Permission result For Importing Contacts
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (ButtonClickedChecked == 333) {
            if (requestCode == REQUEST_CODE_CALL) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeCall(phoneNumber);
                } else {
                    Toast.makeText(getApplicationContext(), "Call not processed", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        } else if (ButtonClickedChecked == 222) {
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
                ButtonClickedChecked = 222;
                phoneNumberForSms = "4444";
                msgBodyForSms = buttonAwesome.getHint().toString();
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Please wait for SMS.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void CallButtonClicked(final ButtonAwesome buttonAwesome){
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 333;
                String bNumber = buttonAwesome.getHint().toString();
                //phoneNumber = bNumber.substring(0, bNumber.indexOf("#")) + Uri.encode("#");
                phoneNumber = Uri.encode(bNumber);
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
