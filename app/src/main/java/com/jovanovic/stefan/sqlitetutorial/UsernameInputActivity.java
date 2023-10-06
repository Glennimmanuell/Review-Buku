package com.jovanovic.stefan.sqlitetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class UsernameInputActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private Button saveUsernameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username_input);

        usernameEditText = findViewById(R.id.usernameEditText);
        saveUsernameButton = findViewById(R.id.saveUsernameButton);

        saveUsernameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString().trim();
                if (!username.isEmpty()) {

                    MyDatabaseHelper myDB = new MyDatabaseHelper(UsernameInputActivity.this);
                    myDB.insertUsername(username);

                    Intent intent = new Intent(UsernameInputActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
