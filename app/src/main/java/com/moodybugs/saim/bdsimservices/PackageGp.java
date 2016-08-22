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

public class PackageGp extends AppCompatActivity {

    ButtonAwesome btnPackageGp0, btnPackageGp1, btnPackageGp2, btnPackageGp3, btnPackageGp4, btnPackageGp5, btnPackageGp6, btnPackageGp7, btnPackageGp8;

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
        setTheme(R.style.ThemeGp);
        setContentView(R.layout.package_gp);
        setTitle("GP Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_gp);

        Initialization();

        SendButtonClicked(btnPackageGp1);
        SendButtonClicked(btnPackageGp2);
        SendButtonClicked(btnPackageGp3);
        SendButtonClicked(btnPackageGp4);
        SendButtonClicked(btnPackageGp5);
        SendButtonClicked(btnPackageGp6);
        SendButtonClicked(btnPackageGp7);
        SendButtonClicked(btnPackageGp8);

        CallButtonClicked(btnPackageGp0);
    }


    public void Initialization(){
        btnPackageGp0 = (ButtonAwesome) findViewById(R.id.btnPackageGp0);
        btnPackageGp1 = (ButtonAwesome) findViewById(R.id.btnPackageGp1);
        btnPackageGp1 = (ButtonAwesome) findViewById(R.id.btnPackageGp1);
        btnPackageGp2 = (ButtonAwesome) findViewById(R.id.btnPackageGp2);
        btnPackageGp3 = (ButtonAwesome) findViewById(R.id.btnPackageGp3);
        btnPackageGp4 = (ButtonAwesome) findViewById(R.id.btnPackageGp4);
        btnPackageGp5 = (ButtonAwesome) findViewById(R.id.btnPackageGp5);
        btnPackageGp6 = (ButtonAwesome) findViewById(R.id.btnPackageGp6);
        btnPackageGp7 = (ButtonAwesome) findViewById(R.id.btnPackageGp7);
        btnPackageGp8 = (ButtonAwesome) findViewById(R.id.btnPackageGp8);
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
                String bNumber = buttonAwesome.getText().toString();
                //phoneNumber = bNumber.substring(0, bNumber.indexOf("#")) + Uri.encode("#");
                phoneNumber = Uri.encode(bNumber);
                Log.d("Saim Check :", phoneNumber);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
