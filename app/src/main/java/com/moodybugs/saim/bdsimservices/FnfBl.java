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

public class FnfBl extends AppCompatActivity {

    EditText txtAddFnFBl, txtAddSFnFBl, txtDeleteFnfBl, txtChangeFnfOldBl, txtChangeFnfNewBl, txtChangeSFnfOldBl, txtChangeSFnfNewBl;
    ButtonAwesome btnAddFnfImportNumberBl, btnAddSFnfImportNumberBl, btnDeleteFnfImportNumberBl, btnChangeFnfOldImportmBl, btnChangeFnfNewImportmBl, btnChangeSFnfOldImportmBl, btnChangeSFnfNewImportmBl;
    ButtonAwesome btnAddFnfSendBl, btnAddSFnfSendBl, btnDeleteFnfSendBl, btnChangeFnfSendBl, btnChangeSFnfSendBl, btnCheckFnfSendBl;

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
        setTheme(R.style.ThemeBl);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fnf_bl);
        setTitle("BL FnF Servie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_banglalink);

        Initialization();
        //Importing Contact
        ImportButtonClick(btnAddFnfImportNumberBl, txtAddFnFBl);
        ImportButtonClick(btnAddSFnfImportNumberBl, txtAddSFnFBl);
        ImportButtonClick(btnDeleteFnfImportNumberBl, txtDeleteFnfBl);
        ImportButtonClick(btnChangeFnfOldImportmBl, txtChangeFnfOldBl);
        ImportButtonClick(btnChangeFnfNewImportmBl, txtChangeFnfNewBl);
        ImportButtonClick(btnChangeSFnfOldImportmBl, txtChangeSFnfOldBl);
        ImportButtonClick(btnChangeSFnfNewImportmBl, txtChangeSFnfNewBl);

        //Making FNF Process
        SendButtonClicked(btnAddFnfSendBl);
        CallButtonClicked(btnAddSFnfSendBl);
        SendButtonClicked(btnDeleteFnfSendBl);
        SendButtonClicked(btnChangeFnfSendBl);
        CallButtonClicked(btnChangeFnfSendBl);
        SendButtonClicked(btnCheckFnfSendBl);
    }

    public void Initialization() {
        findViewById(R.id.mainLayoutFnfBl).requestFocus();
        //Edit Text
        txtAddFnFBl = (EditText) findViewById(R.id.txtAddFnFBl);
        txtAddSFnFBl = (EditText) findViewById(R.id.txtAddSFnFBl);
        txtDeleteFnfBl = (EditText) findViewById(R.id.txtDeleteFnfBl);
        txtChangeFnfOldBl = (EditText) findViewById(R.id.txtChangeFnfOldBl);
        txtChangeFnfNewBl = (EditText) findViewById(R.id.txtChangeFnfNewBl);
        txtChangeSFnfOldBl = (EditText) findViewById(R.id.txtChangeSFnfOldBl);
        txtChangeSFnfNewBl = (EditText) findViewById(R.id.txtChangeSFnfNewBl);

        //Import Button
        btnAddFnfImportNumberBl = (ButtonAwesome) findViewById(R.id.btnAddFnfImportNumberBl);
        btnAddSFnfImportNumberBl = (ButtonAwesome) findViewById(R.id.btnAddSFnfImportNumberBl);
        btnDeleteFnfImportNumberBl = (ButtonAwesome) findViewById(R.id.btnDeleteFnfImportNumberBl);
        btnChangeFnfOldImportmBl = (ButtonAwesome) findViewById(R.id.btnChangeFnfOldImportmBl);
        btnChangeFnfNewImportmBl = (ButtonAwesome) findViewById(R.id.btnChangeFnfNewImportmBl);
        btnChangeSFnfOldImportmBl = (ButtonAwesome) findViewById(R.id.btnChangeSFnfOldImportmBl);
        btnChangeSFnfNewImportmBl = (ButtonAwesome) findViewById(R.id.btnChangeSFnfNewImportmBl);

        //Import Send Button
        btnAddFnfSendBl = (ButtonAwesome) findViewById(R.id.btnAddFnfSendBl);
        btnAddSFnfSendBl = (ButtonAwesome) findViewById(R.id.btnAddSFnfSendBl);
        btnDeleteFnfSendBl = (ButtonAwesome) findViewById(R.id.btnDeleteFnfSendBl);
        btnChangeFnfSendBl = (ButtonAwesome) findViewById(R.id.btnChangeFnfSendBl);
        btnChangeSFnfSendBl = (ButtonAwesome) findViewById(R.id.btnChangeSFnfSendBl);
        btnCheckFnfSendBl = (ButtonAwesome) findViewById(R.id.btnCheckFnfSendBl);
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
        } else if (ButtonClickedChecked == 333){
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                makeCall(phoneNumber);
            }else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                        Toast.makeText(getApplicationContext(), "Permission required", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
                }else{
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

    public void makeCall(String Number){
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
        }else if (ButtonClickedChecked == 333){
            if (requestCode == REQUEST_CODE_CALL){
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    makeCall(phoneNumber);
                }else {
                    Toast.makeText(getApplicationContext(), "Call not processed", Toast.LENGTH_SHORT).show();
                }
            }else {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    //Set Imported Number to EditText
    public void SetImportedNumbet(String pNumber) {
        if (editTextCounter == txtAddFnFBl.getId()) {
            txtAddFnFBl.setText(pNumber);
            btnAddFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtAddSFnFBl.getId()) {
            txtAddSFnFBl.setText(pNumber);
            btnAddSFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtDeleteFnfBl.getId()) {
            txtDeleteFnfBl.setText(pNumber);
            btnDeleteFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeFnfOldBl.getId()) {
            txtChangeFnfOldBl.setText(pNumber);
            btnChangeFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeFnfNewBl.getId()) {
            txtChangeFnfNewBl.setText(pNumber);
            btnChangeFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeSFnfOldBl.getId()) {
            txtChangeSFnfOldBl.setText(pNumber);
            btnChangeSFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeSFnfNewBl.getId()) {
            txtChangeSFnfNewBl.setText(pNumber);
            btnChangeSFnfSendBl.setEnabled(true);
            editTextCounter = 0;
        }
    }

    public void SendButtonClicked(ButtonAwesome buttonAwesome) {
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 222;
                //Add FNF
                if (v.getId() == btnAddFnfSendBl.getId()) {
                    if (txtAddFnFBl.getText().toString().isEmpty() || txtAddFnFBl.getText().toString().length() > 11 || txtAddFnFBl.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "3030";
                        msgBodyForSms = "Add " + txtAddFnFBl.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is added to fnf list.", Toast.LENGTH_LONG).show();
                        txtAddFnFBl.setText("");
                    }
                }
                // Delete FNF
                else if (v.getId() == btnDeleteFnfSendBl.getId()) {
                    if (txtDeleteFnfBl.getText().toString().isEmpty() || txtDeleteFnfBl.getText().toString().length() > 11 || txtDeleteFnfBl.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "3030";
                        msgBodyForSms = "rem " + txtDeleteFnfBl.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is deleted from fnf list.", Toast.LENGTH_LONG).show();
                        txtDeleteFnfBl.setText("");
                    }
                }
                //Change FNF
                else if (v.getId() == btnChangeFnfSendBl.getId()) {
                    if (txtChangeFnfOldBl.getText().toString().isEmpty() || txtChangeFnfOldBl.getText().toString().length() > 11 || txtChangeFnfOldBl.getText().toString().length() < 11 ||
                            txtChangeFnfNewBl.getText().toString().isEmpty() || txtChangeFnfNewBl.getText().toString().length() > 11 || txtChangeFnfNewBl.getText().toString().length() < 11
                            || txtChangeFnfOldBl.getText().toString().equals(txtChangeFnfNewBl.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Input box number should be proper!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "3030";
                        msgBodyForSms = "ch " + txtChangeFnfOldBl.getText().toString() + " " + txtChangeFnfNewBl.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your FNF Number Changed to " + txtChangeFnfNewBl.getText().toString(), Toast.LENGTH_LONG).show();
                        txtChangeFnfOldBl.setText("");
                        txtChangeFnfNewBl.setText("");
                    }
                }
                //Check FNF
                else if (v.getId() == btnCheckFnfSendBl.getId()) {
                    phoneNumberForSms = "3030";
                    msgBodyForSms = "FF";
                    runtimePermission();
                    Toast.makeText(getApplicationContext(), "Wait for return sms.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void CallButtonClicked(ButtonAwesome buttonAwesome){
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 333;
                //Add SFNF
                if (v.getId() == btnAddSFnfSendBl.getId()) {
                    if (txtAddSFnFBl.getText().toString().isEmpty() || txtAddSFnFBl.getText().toString().length() > 11 || txtAddSFnFBl.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumber = "*166*7*" + txtAddSFnFBl.getText().toString() + Uri.encode("#");
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is added to fnf list.", Toast.LENGTH_LONG).show();
                        txtAddFnFBl.setText("");
                    }
                }
                //Change FNF
                else if (v.getId() == btnChangeSFnfSendBl.getId()) {
                    if (txtChangeSFnfOldBl.getText().toString().isEmpty() || txtChangeSFnfOldBl.getText().toString().length() > 11 || txtChangeSFnfOldBl.getText().toString().length() < 11 ||
                            txtChangeSFnfNewBl.getText().toString().isEmpty() || txtChangeSFnfNewBl.getText().toString().length() > 11 || txtChangeSFnfNewBl.getText().toString().length() < 11
                            || txtChangeSFnfOldBl.getText().toString().equals(txtChangeSFnfNewBl.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Input box number should be proper!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumber = "*166*8*" + txtChangeSFnfOldBl.getText().toString() + "*" + txtChangeSFnfNewBl.getText().toString() + Uri.encode("#");
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your Super FNF Number Changed to " + txtChangeSFnfNewBl.getText().toString(), Toast.LENGTH_LONG).show();
                        txtChangeSFnfOldBl.setText("");
                        txtChangeSFnfNewBl.setText("");
                    }
                }
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
            Intent intent = new Intent(FnfBl.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(FnfBl.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
