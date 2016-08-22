package com.moodybugs.saim.bdsimservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class InternetTeletalk extends AppCompatActivity {

    ButtonAwesome btnInternetTl0, btnInternetTl1, btnInternetTl2, btnInternetTl3, btnInternetTl4, btnInternetTl5, btnInternetTl6,
            btnInternetTl7, btnInternetTl8, btnInternetTl9, btnInternetTl10, btnInternetTl11, btnInternetTl12,
            btnInternetTl13, btnInternetTl14, btnInternetTl15, btnInternetTl16, btnInternetTl17, btnInternetTl18,
            btnInternetTl19, btnInternetTl20, btnInternetTl21, btnInternetTl22, btnInternetTl23, btnInternetTl24,
            btnInternetTl25, btnInternetTl26, btnInternetTl27, btnInternetTl28, btnInternetTl29, btnInternetTl30,
            btnInternetTl31, btnInternetTl32, btnInternetTl33, btnInternetTl34, btnInternetTl35, btnInternetTl36,
            btnInternetTl37, btnInternetTl38, btnInternetTl39, btnInternetTl40, btnInternetTl41, btnInternetTl42;

    private final int REQUEST_CODE_SEND_SMS = 1;
    public int ButtonClickedChecked;
    String phoneNumberForSms = "111", msgBodyForSms = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeTeletalk);
        setContentView(R.layout.internet_teletalk);
        setTitle("Teletalk Internet Packages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_teletalk);

        Initialization();

        btnInternetTl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternetTeletalk.this, Browser.class);
                intent.putExtra("url", "http://teletalk.com.bd/packages/dataPackages.jsp?menuItem=7003");
                startActivity(intent);
            }
        });

        SendButtonClicked(btnInternetTl1);
        SendButtonClicked(btnInternetTl2);
        SendButtonClicked(btnInternetTl3);
        SendButtonClicked(btnInternetTl4);
        SendButtonClicked(btnInternetTl5);
        SendButtonClicked(btnInternetTl6);
        SendButtonClicked(btnInternetTl7);
        SendButtonClicked(btnInternetTl8);
        SendButtonClicked(btnInternetTl9);
        SendButtonClicked(btnInternetTl10);
        SendButtonClicked(btnInternetTl11);
        SendButtonClicked(btnInternetTl12);
        SendButtonClicked(btnInternetTl13);
        SendButtonClicked(btnInternetTl14);
        SendButtonClicked(btnInternetTl15);
        SendButtonClicked(btnInternetTl16);
        SendButtonClicked(btnInternetTl17);
        SendButtonClicked(btnInternetTl18);
        SendButtonClicked(btnInternetTl19);
        SendButtonClicked(btnInternetTl20);
        SendButtonClicked(btnInternetTl21);
        SendButtonClicked(btnInternetTl22);
        SendButtonClicked(btnInternetTl23);
        SendButtonClicked(btnInternetTl24);
        SendButtonClicked(btnInternetTl25);
        SendButtonClicked(btnInternetTl26);
        SendButtonClicked(btnInternetTl27);
        SendButtonClicked(btnInternetTl28);
        SendButtonClicked(btnInternetTl29);
        SendButtonClicked(btnInternetTl30);
        SendButtonClicked(btnInternetTl31);
        SendButtonClicked(btnInternetTl32);
        SendButtonClicked(btnInternetTl33);
        SendButtonClicked(btnInternetTl34);
        SendButtonClicked(btnInternetTl35);
        SendButtonClicked(btnInternetTl36);
        SendButtonClicked(btnInternetTl37);
        SendButtonClicked(btnInternetTl38);
        SendButtonClicked(btnInternetTl39);
        SendButtonClicked(btnInternetTl40);
        SendButtonClicked(btnInternetTl41);
        SendButtonClicked(btnInternetTl42);
    }

    public void Initialization(){
        btnInternetTl0 = (ButtonAwesome) findViewById(R.id.btnInternetTl0);
        btnInternetTl1 = (ButtonAwesome) findViewById(R.id.btnInternetTl1);
        btnInternetTl2 = (ButtonAwesome) findViewById(R.id.btnInternetTl2);
        btnInternetTl3 = (ButtonAwesome) findViewById(R.id.btnInternetTl3);
        btnInternetTl4 = (ButtonAwesome) findViewById(R.id.btnInternetTl4);
        btnInternetTl5 = (ButtonAwesome) findViewById(R.id.btnInternetTl5);
        btnInternetTl6 = (ButtonAwesome) findViewById(R.id.btnInternetTl6);
        btnInternetTl7 = (ButtonAwesome) findViewById(R.id.btnInternetTl7);
        btnInternetTl8 = (ButtonAwesome) findViewById(R.id.btnInternetTl8);
        btnInternetTl9 = (ButtonAwesome) findViewById(R.id.btnInternetTl9);
        btnInternetTl10 = (ButtonAwesome) findViewById(R.id.btnInternetTl10);
        btnInternetTl11 = (ButtonAwesome) findViewById(R.id.btnInternetTl11);
        btnInternetTl12 = (ButtonAwesome) findViewById(R.id.btnInternetTl12);
        btnInternetTl13 = (ButtonAwesome) findViewById(R.id.btnInternetTl13);
        btnInternetTl14 = (ButtonAwesome) findViewById(R.id.btnInternetTl14);
        btnInternetTl15 = (ButtonAwesome) findViewById(R.id.btnInternetTl15);
        btnInternetTl16 = (ButtonAwesome) findViewById(R.id.btnInternetTl16);
        btnInternetTl17 = (ButtonAwesome) findViewById(R.id.btnInternetTl17);
        btnInternetTl18 = (ButtonAwesome) findViewById(R.id.btnInternetTl18);
        btnInternetTl19 = (ButtonAwesome) findViewById(R.id.btnInternetTl19);
        btnInternetTl20 = (ButtonAwesome) findViewById(R.id.btnInternetTl20);
        btnInternetTl21 = (ButtonAwesome) findViewById(R.id.btnInternetTl21);
        btnInternetTl22 = (ButtonAwesome) findViewById(R.id.btnInternetTl22);
        btnInternetTl23 = (ButtonAwesome) findViewById(R.id.btnInternetTl23);
        btnInternetTl24 = (ButtonAwesome) findViewById(R.id.btnInternetTl24);
        btnInternetTl25 = (ButtonAwesome) findViewById(R.id.btnInternetTl25);
        btnInternetTl26 = (ButtonAwesome) findViewById(R.id.btnInternetTl26);
        btnInternetTl27 = (ButtonAwesome) findViewById(R.id.btnInternetTl27);
        btnInternetTl28 = (ButtonAwesome) findViewById(R.id.btnInternetTl28);
        btnInternetTl29 = (ButtonAwesome) findViewById(R.id.btnInternetTl29);
        btnInternetTl30 = (ButtonAwesome) findViewById(R.id.btnInternetTl30);
        btnInternetTl31 = (ButtonAwesome) findViewById(R.id.btnInternetTl31);
        btnInternetTl32 = (ButtonAwesome) findViewById(R.id.btnInternetTl32);
        btnInternetTl33 = (ButtonAwesome) findViewById(R.id.btnInternetTl33);
        btnInternetTl34 = (ButtonAwesome) findViewById(R.id.btnInternetTl34);
        btnInternetTl35 = (ButtonAwesome) findViewById(R.id.btnInternetTl35);
        btnInternetTl36 = (ButtonAwesome) findViewById(R.id.btnInternetTl36);
        btnInternetTl37 = (ButtonAwesome) findViewById(R.id.btnInternetTl37);
        btnInternetTl38 = (ButtonAwesome) findViewById(R.id.btnInternetTl38);
        btnInternetTl39 = (ButtonAwesome) findViewById(R.id.btnInternetTl39);
        btnInternetTl40 = (ButtonAwesome) findViewById(R.id.btnInternetTl40);
        btnInternetTl41 = (ButtonAwesome) findViewById(R.id.btnInternetTl41);
        btnInternetTl42 = (ButtonAwesome) findViewById(R.id.btnInternetTl42);
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
                ButtonClickedChecked = 222;
                msgBodyForSms = buttonAwesome.getText().toString();
                Log.d("Saim Check :", msgBodyForSms);
                runtimePermission();
                Toast.makeText(getApplicationContext(), "Your request has been processed", Toast.LENGTH_LONG).show();
            }
        });
    }


}
