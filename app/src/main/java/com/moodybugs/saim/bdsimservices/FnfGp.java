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

public class FnfGp extends AppCompatActivity {
    //XML Layout Elements
    EditText txtAddFnFGp, txtAddSFnFGp, txtDeleteFnFGp, txtChangeFnfOldGp, txtChangeFnfNewGp, txtChangeSFnfOldGp, txtChangeSFnfNewGp;
    ButtonAwesome btnAddFnfImportNumberGp, btnAddSFnfImportNumberGp, btnDeleteFnfImportNumberGp, btnChangeFnfOldImportGp, btnChangeFnfNewImportGp, btnChangeSFnfOldImportGp, btnChangeSFnfNewImportGp;
    ButtonAwesome btnAddFnfSendGp, btnAddSFnfSendGp, btnDeleteFnfSendGp, btnChangeFnfSendGp, btnChangeSFnfSendGp, btnCheckFnfSendGp;
    //Code Needed Elements
    private final int REQUEST_CODE_READ_CONTACT = 1;
    private final int REQUEST_CODE_SEND_SMS = 1;
    final public int PICK_CONTACT = 1;
    public int ButtonClickedChecked;
    String phoneNumber = null;
    String phoneNumberForSms = null, msgBodyForSms = null;
    int editTextCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeGp);
        setContentView(R.layout.fnf_gp);
        setTitle("GP FnF Servie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_appbar_gp);

        Initialization();
        //Importing Contact
        ImportButtonClick(btnAddFnfImportNumberGp, txtAddFnFGp);
        ImportButtonClick(btnAddSFnfImportNumberGp, txtAddSFnFGp);
        ImportButtonClick(btnDeleteFnfImportNumberGp, txtDeleteFnFGp);
        ImportButtonClick(btnChangeFnfOldImportGp, txtChangeFnfOldGp);
        ImportButtonClick(btnChangeFnfNewImportGp, txtChangeFnfNewGp);
        ImportButtonClick(btnChangeSFnfOldImportGp, txtChangeSFnfOldGp);
        ImportButtonClick(btnChangeSFnfNewImportGp, txtChangeSFnfNewGp);

        //Making FNF Process
        SendButtonClicked(btnAddFnfSendGp);
        SendButtonClicked(btnAddSFnfSendGp);
        SendButtonClicked(btnDeleteFnfSendGp);
        SendButtonClicked(btnChangeFnfSendGp);
        SendButtonClicked(btnChangeSFnfSendGp);
        SendButtonClicked(btnCheckFnfSendGp);
    }

    public void Initialization() {
        findViewById(R.id.mainLayoutFnfGp).requestFocus();
        //Edittext
        txtAddFnFGp = (EditText) findViewById(R.id.txtAddFnFGp);
        txtAddSFnFGp = (EditText) findViewById(R.id.txtAddSFnFGp);
        txtDeleteFnFGp = (EditText) findViewById(R.id.txtDeleteFnFGp);
        txtChangeFnfOldGp = (EditText) findViewById(R.id.txtChangeFnfOldGp);
        txtChangeFnfNewGp = (EditText) findViewById(R.id.txtChangeFnfNewGp);
        txtChangeSFnfOldGp = (EditText) findViewById(R.id.txtChangeSFnfOldGp);
        txtChangeSFnfNewGp = (EditText) findViewById(R.id.txtChangeSFnfNewGp);

        //ButtonAwesome For Import Contact
        btnAddFnfImportNumberGp = (ButtonAwesome) findViewById(R.id.btnAddFnfImportNumberGp);
        btnAddSFnfImportNumberGp = (ButtonAwesome) findViewById(R.id.btnAddSFnfImportNumberGp);
        btnDeleteFnfImportNumberGp = (ButtonAwesome) findViewById(R.id.btnDeleteFnfImportNumberGp);
        btnChangeFnfOldImportGp = (ButtonAwesome) findViewById(R.id.btnChangeFnfOldImportGp);
        btnChangeFnfNewImportGp = (ButtonAwesome) findViewById(R.id.btnChangeFnfNewImportGp);
        btnChangeSFnfOldImportGp = (ButtonAwesome) findViewById(R.id.btnChangeSFnfOldImportGp);
        btnChangeSFnfNewImportGp = (ButtonAwesome) findViewById(R.id.btnChangeSFnfNewImportGp);

        //ButtonAwesome For Send
        btnAddFnfSendGp = (ButtonAwesome) findViewById(R.id.btnAddFnfSendGp);
        btnAddSFnfSendGp = (ButtonAwesome) findViewById(R.id.btnAddSFnfSendGp);
        btnDeleteFnfSendGp = (ButtonAwesome) findViewById(R.id.btnDeleteFnfSendGp);
        btnChangeFnfSendGp = (ButtonAwesome) findViewById(R.id.btnChangeFnfSendGp);
        btnChangeSFnfSendGp = (ButtonAwesome) findViewById(R.id.btnChangeSFnfSendGp);
        btnCheckFnfSendGp = (ButtonAwesome) findViewById(R.id.btnCheckFnfSendGp);
    }

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

    //Importing Contact StratActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*if (resultCode == this.RESULT_OK) {
            if (data != null && requestCode == PICK_CONTACT) {
                Uri uriOfPhoneNumberRecord = data.getData();
                String idOfPhoneRecord = uriOfPhoneNumberRecord.getLastPathSegment();
                Cursor cursor = getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER}, ContactsContract.CommonDataKinds.Phone._ID + "=?", new String[]{idOfPhoneRecord}, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        //Toast.makeText(getActivity().getBaseContext(), phoneNumber, Toast.LENGTH_LONG).show();
                        SetImportedNumbet(phoneNumber);
                    }
                    cursor.close();
                }
            }
        }*/
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
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[] { id },
                            null);

                    int i = 0;
                    while (pCur.moveToNext()) {
                        phoneNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        if(i == 0){
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
        }
    }

    //Set Imported Number to EditText
    public void SetImportedNumbet(String pNumber) {
        if (editTextCounter == txtAddFnFGp.getId()) {
            txtAddFnFGp.setText(pNumber);
            btnAddFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtAddSFnFGp.getId()) {
            txtAddSFnFGp.setText(pNumber);
            btnAddSFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtDeleteFnFGp.getId()) {
            txtDeleteFnFGp.setText(pNumber);
            btnDeleteFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeFnfOldGp.getId()) {
            txtChangeFnfOldGp.setText(pNumber);
            btnChangeFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeFnfNewGp.getId()) {
            txtChangeFnfNewGp.setText(pNumber);
            btnChangeFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeSFnfOldGp.getId()) {
            txtChangeSFnfOldGp.setText(pNumber);
            btnChangeSFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        } else if (editTextCounter == txtChangeSFnfNewGp.getId()) {
            txtChangeSFnfNewGp.setText(pNumber);
            btnChangeSFnfSendGp.setEnabled(true);
            editTextCounter = 0;
        }
    }

    public void SendButtonClicked(ButtonAwesome buttonAwesome) {
        buttonAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedChecked = 222;
                if (v.getId() == btnAddFnfSendGp.getId()) {
                    if (txtAddFnFGp.getText().toString().isEmpty() || txtAddFnFGp.getText().toString().length() > 11 || txtAddFnFGp.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "2888";
                        msgBodyForSms = txtAddFnFGp.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is added to fnf list.", Toast.LENGTH_LONG).show();
                        txtAddFnFGp.setText("");
                    }
                } else if (v.getId() == btnAddSFnfSendGp.getId()) {
                    if (txtAddSFnFGp.getText().toString().isEmpty() || txtAddSFnFGp.getText().toString().length() > 11 || txtAddSFnFGp.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "2888";
                        msgBodyForSms = "SF " + txtAddSFnFGp.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is added to fnf list.", Toast.LENGTH_LONG).show();
                        txtAddSFnFGp.setText("");
                    }
                } else if (v.getId() == btnDeleteFnfSendGp.getId()) {
                    if (txtDeleteFnFGp.getText().toString().isEmpty() || txtDeleteFnFGp.getText().toString().length() > 11 || txtDeleteFnFGp.getText().toString().length() < 11) {
                        Toast.makeText(getApplicationContext(), "Input box can not be empty!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "2888";
                        msgBodyForSms = "D " + txtDeleteFnFGp.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your number is deleted from fnf list.", Toast.LENGTH_LONG).show();
                        txtDeleteFnFGp.setText("");
                    }
                } else if (v.getId() == btnChangeFnfSendGp.getId()) {
                    if (txtChangeFnfOldGp.getText().toString().isEmpty() || txtChangeFnfOldGp.getText().toString().length() > 11 || txtChangeFnfOldGp.getText().toString().length() < 11 ||
                            txtChangeFnfNewGp.getText().toString().isEmpty() || txtChangeFnfNewGp.getText().toString().length() > 11 || txtChangeFnfNewGp.getText().toString().length() < 11
                            || txtChangeFnfOldGp.getText().toString().equals(txtChangeFnfNewGp.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Input box number should be proper!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "2888";
                        msgBodyForSms = txtChangeFnfOldGp.getText().toString() + " " + txtChangeFnfNewGp.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your FNF Number Changed to " + txtChangeFnfNewGp.getText().toString(), Toast.LENGTH_LONG).show();
                        txtChangeFnfOldGp.setText("");
                        txtChangeFnfNewGp.setText("");
                    }
                } else if (v.getId() == btnChangeSFnfSendGp.getId()) {
                    if (txtChangeSFnfOldGp.getText().toString().isEmpty() || txtChangeSFnfOldGp.getText().toString().length() > 11 || txtChangeSFnfOldGp.getText().toString().length() < 11 ||
                            txtChangeSFnfNewGp.getText().toString().isEmpty() || txtChangeSFnfNewGp.getText().toString().length() > 11 || txtChangeSFnfNewGp.getText().toString().length() < 11
                            || txtChangeSFnfOldGp.getText().toString().equals(txtChangeSFnfNewGp.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Input box number should be proper!", Toast.LENGTH_LONG).show();
                    } else {
                        phoneNumberForSms = "2888";
                        msgBodyForSms = "SFC " + txtChangeSFnfOldGp.getText().toString() + " " + txtChangeSFnfNewGp.getText().toString();
                        runtimePermission();
                        Toast.makeText(getApplicationContext(), "Your Super FNF Number Changed to " + txtChangeSFnfNewGp.getText().toString(), Toast.LENGTH_LONG).show();
                        txtChangeSFnfOldGp.setText("");
                        txtChangeSFnfNewGp.setText("");
                    }
                } else if (v.getId() == btnCheckFnfSendGp.getId()) {
                    phoneNumberForSms = "2888";
                    msgBodyForSms = "FF";
                    runtimePermission();
                    Toast.makeText(getApplicationContext(), "Wait for return sms.", Toast.LENGTH_LONG).show();
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
            Intent intent = new Intent(FnfGp.this, Developer.class);
            startActivity(intent);
            finish();
        }else if (item.getItemId() == android.R.id.home){
            Intent intent = new Intent(FnfGp.this, MainMenu.class);
            startActivity(intent);
            finish();
        }

        return true;
    }
}
