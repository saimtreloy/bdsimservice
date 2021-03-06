package com.moodybugs.saim.bdsimservices;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FnfRobi extends AppCompatActivity {

    EditText txtAddFndRobi, txtAddSFnfRobi, txtDeleteFnfRobi;
    ButtonAwesome btnAddFnfImportNumberRobi, btnAddSFnfImportNumberRobi, btnDeleteFnfImportNumberRobi;
    ButtonAwesome btnAddFnfSendRobi, btnAddSFnfSendRobi, btnDeleteFnfSendRobi, btnCheckFnfSendRobi, btnHelpSendRobi;

    private final int REQUEST_CODE_READ_CONTACT = 1;
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
        setTheme(R.style.ThemeAirtel);
        setContentView(R.layout.fnf_robi);
        setTitle("Robi FnF Servie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_robi);

        Initialization();

        ImportButtonClick(btnAddFnfImportNumberRobi, txtAddFndRobi);
        ImportButtonClick(btnAddSFnfImportNumberRobi, txtAddSFnfRobi);
        ImportButtonClick(btnDeleteFnfImportNumberRobi, txtDeleteFnfRobi);

        SendButtonClicked(btnAddFnfSendRobi);
        SendButtonClicked(btnAddSFnfSendRobi);
        SendButtonClicked(btnDeleteFnfSendRobi);
        SendButtonClicked(btnCheckFnfSendRobi);
        SendButtonClicked(btnHelpSendRobi);

    }


    public void Initialization() {
        findViewById(R.id.mainLayoutFnfRobi).requestFocus();
        //Edit Text
        txtAddFndRobi = (EditText) findViewById(R.id.txtAddFndRobi);
        txtAddSFnfRobi = (EditText) findViewById(R.id.txtAddSFnfRobi);
        txtDeleteFnfRobi = (EditText) findViewById(R.id.txtDeleteFnfRobi);

        //Import Button
        btnAddFnfImportNumberRobi = (ButtonAwesome) findViewById(R.id.btnAddFnfImportNumberRobi);
        btnAddSFnfImportNumberRobi = (ButtonAwesome) findViewById(R.id.btnAddSFnfImportNumberRobi);
        btnDeleteFnfImportNumberRobi = (ButtonAwesome) findViewById(R.id.btnDeleteFnfImportNumberRobi);

        //Import Send Button
        btnAddFnfSendRobi = (ButtonAwesome) findViewById(R.id.btnAddFnfSendRobi);
        btnAddSFnfSendRobi = (ButtonAwesome) findViewById(R.id.btnAddSFnfSendRobi);
        btnDeleteFnfSendRobi = (ButtonAwesome) findViewById(R.id.btnDeleteFnfSendRobi);
        btnCheckFnfSendRobi = (ButtonAwesome) findViewById(R.id.btnCheckFnfSendRobi);
        btnHelpSendRobi = (ButtonAwesome) findViewById(R.id.btnHelpSendRobi);
    }

    //Import Contact
    public void ImportButtonClick(ButtonAwesome buttonAwesome, final EditText editText) {
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 111;
                runtimePermission();
                editTextCounter = editText.getId();
            }
        });
    }

    //Runtime Permission For Importing Contacts
    public void runtimePermission() {
        if (ButtonClickedChecked == 111) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                selectContact();
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                        Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_READ_CONTACT);
                } else {
                    selectContact();
                }
            }
        } else if (ButtonClickedChecked == 222) {
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
        } else if (ButtonClickedChecked == 333) {
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
        }
    }


    //Importing Contact Intent Result
    public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT);
    }

    public void sendSms(String Number, String msgBody) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(Number, null, msgBody, null, null);
    }

    public void makeCall(String Number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    //Importing Contact StratActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            ContentResolver cr = getContentResolver();
            Uri contactData = data.getData();
            Cursor c = getContentResolver().query(contactData, null, null,
                    null, null);
            if (c.moveToFirst()) {
                String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id},
                            null);

                    int i = 0;
                    while (pCur.moveToNext()) {
                        phoneNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        if (i == 0) {
                            SetImportedNumbet(phoneNumber);
                            break;
                        }
                    }

                }

            }
        }

    }


    //Requesting Permission result For Importing Contacts
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (ButtonClickedChecked == 111) {
            if (requestCode == REQUEST_CODE_READ_CONTACT) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    selectContact();
                } else {
                    Toast.makeText(getApplicationContext(), "Contact not processed", Toast.LENGTH_SHORT).show();
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
        } else if (ButtonClickedChecked == 333) {
            if (requestCode == REQUEST_CODE_CALL) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeCall(phoneNumber);
                } else {
                    Toast.makeText(getApplicationContext(), "Call not processed", Toast.LENGTH_SHORT).show();
                }
            } else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    //Set Imported Number to EditText
    public void SetImportedNumbet(String pNumber) {
        if (editTextCounter == txtAddFndRobi.getId()) {
            txtAddFndRobi.setText(pNumber);
            editTextCounter = 0;
        }else if (editTextCounter == txtAddSFnfRobi.getId()) {
            txtAddSFnfRobi.setText(pNumber);
            editTextCounter = 0;
        } else if (editTextCounter == txtDeleteFnfRobi.getId()) {
            txtDeleteFnfRobi.setText(pNumber);
            editTextCounter = 0;
        }
    }


    public void SendButtonClicked(ButtonAwesome buttonAwesome) {
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 222;
                //Add FNF
                if (v.getId() == btnAddFnfSendRobi.getId()) {
                    if (txtAddFndRobi.getText().toString().isEmpty() || txtAddFndRobi.getText().toString().length() > 11 || txtAddFndRobi.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "8363";
                        msgBodyForSms = "A " + txtAddFndRobi.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is added to fnf list.", Toast.LENGTH_LONG).show();
                        txtAddFndRobi.setText("");
                    }
                }//Add SFNF
                else if (v.getId() == btnAddSFnfSendRobi.getId()) {
                    if (txtAddSFnfRobi.getText().toString().isEmpty() || txtAddSFnfRobi.getText().toString().length() > 11 || txtAddSFnfRobi.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "8363";
                        msgBodyForSms = "P " + txtAddSFnfRobi.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is added to fnf list.", Toast.LENGTH_LONG).show();
                        txtAddSFnfRobi.setText("");
                    }
                }
                // Delete FNF
                else if (v.getId() == btnDeleteFnfSendRobi.getId()) {
                    if (txtDeleteFnfRobi.getText().toString().isEmpty() || txtDeleteFnfRobi.getText().toString().length() > 11 || txtDeleteFnfRobi.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "8363";
                        msgBodyForSms = "D " + txtDeleteFnfRobi.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is deleted from fnf list.", Toast.LENGTH_LONG).show();
                        txtDeleteFnfRobi.setText("");
                    }
                }
                // Check FNF
                else if (v.getId() == btnCheckFnfSendRobi.getId()) {
                    phoneNumberForSms = "8363";
                    msgBodyForSms = "F";
                    runtimePermission();
                    Toast.makeText(getApplicationContext(), "Please wait for return sms.", Toast.LENGTH_LONG).show();
                }
                // Help FNF
                else if (v.getId() == btnHelpSendRobi.getId()) {
                    phoneNumberForSms = "8363";
                    msgBodyForSms = "H";
                    runtimePermission();
                    Toast.makeText(getApplicationContext(), "Please wait for return sms.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void CallButtonClicked(ButtonAwesome buttonAwesome){
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 333;
                //Check FNF

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnDeveloper){
            Intent intent = new Intent(FnfRobi.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(FnfRobi.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
