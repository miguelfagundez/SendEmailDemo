package com.miguefagundez.sendemaildemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Members
    private EditText ettoEmails;
    private EditText etccEmails;
    private EditText etbccEmails;
    private EditText etSubject;
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMembers();
    }

    // Validate email format using regular expression
    private boolean isEmailValid(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    // Init private members
    void setupMembers(){
        ettoEmails = findViewById(R.id.etSendEmails);
        etccEmails = findViewById(R.id.etSendEmailsCC);
        etbccEmails = findViewById(R.id.etSendEmailsBCC);
        etSubject = findViewById(R.id.etSubject);
        etText = findViewById(R.id.etText);
    }

    public void sendEmail(View view) {
        String[] email = {ettoEmails.getText().toString()};
        String[] ccEmail = {etccEmails.getText().toString()};
        String[] bccEmail = {etbccEmails.getText().toString()};
        String subjectText = etSubject.getText().toString();
        String longText = etText.getText().toString();

        if (email[0].isEmpty()){
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_LONG).show();
        }else {
            if (!isEmailValid(email[0])){
                Toast.makeText(this, "Email does not have a valid format!", Toast.LENGTH_LONG).show();
            }else{
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));

                intent.putExtra(Intent.EXTRA_EMAIL, email);

                if (!ccEmail[0].isEmpty() && isEmailValid(ccEmail[0])){
                    intent.putExtra(Intent.EXTRA_CC, ccEmail);
                }

                if (!bccEmail[0].isEmpty() && isEmailValid(bccEmail[0])){
                    intent.putExtra(Intent.EXTRA_BCC, bccEmail);
                }

                intent.putExtra(Intent.EXTRA_SUBJECT, subjectText);
                intent.putExtra(Intent.EXTRA_TEXT, longText);

                startActivity(Intent.createChooser(intent, "Choose an Email app"));
            }
        }
    }
}