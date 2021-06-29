package com.ganesh.testsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button login;
    String Username;
    String Password;;
    int count;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usernameLogin);
        password = (EditText) findViewById(R.id.passwordLogin);
        login = (Button) findViewById(R.id.login);

        Bundle bundle = getIntent().getExtras();
        Username = bundle.getString("user");
        Password = bundle.getString("Lab@2018");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputname = username.getText().toString();
                String inputpwd = password.getText().toString();

                Boolean isValid = validate(inputname, inputpwd);
                if(!isValid) {
                    count++;
                    if(count==3) {
                        login.setEnabled(false);
                        Toast.makeText(LoginActivity.this, "Failed Login Attempts", Toast.LENGTH_LONG).show();
                    } else {

                        Toast.makeText(LoginActivity.this, "Login Failed" + count, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validate (String name, String password) {
        if(name.equals(Username) && password.equals(Password)) {
            return true;
        }
        return false;
    }
}
