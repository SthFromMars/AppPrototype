package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button button = (Button) findViewById(R.id.logInButton);
        final EditText username = findViewById(R.id.Username);
        final EditText password = findViewById(R.id.Password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn(username.getText().toString(), password.getText().toString());
            }
        });
    }

    void logIn(String username, String password){
        Organizer organizer = OrganizerManager.getInstance().logIn(username, password);
        if(organizer == null) return;
        OrganizerManager.getInstance().signedIn = organizer;
        Intent intent = new Intent(this, ChoseOrdersActivity.class);
        startActivity(intent);
    }
}
