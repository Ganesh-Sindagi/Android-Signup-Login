package com.ganesh.testsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button login, signup;
    EditText username, password;
    String regularExpression = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pwd);
        signup = (Button) findViewById(R.id.signup);
        login = (Button) findViewById(R.id.loginMain);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newuname = username.getText().toString();
                String newpass = password.getText().toString();
                System.out.println("Matches" + newpass);
                if(validatePassword(newpass)) {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user", newuname);
                    bundle.putString("Lab@2018", newpass);
                    i.putExtras(bundle);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                Bundle bundle = new Bundle();
                // Passing default bundle values -- it is shit thou but should be done!!!
                bundle.putString("user", "Ganesh");
                bundle.putString("Lab@2018", "@Ganesh7");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(password);
        System.out.println("Matches" + matcher.matches());
        return matcher.matches();
    }
}
