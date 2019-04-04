package sdu.cs.eakkapod.animalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //ประกาศตัวแปล
    EditText userEditText, passEditText;
    Button loginButton;
    String userString, passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ผูกตัวแปล
        userEditText = findViewById(R.id.edtUsername);
        passEditText = findViewById(R.id.edtPassword);
        loginButton  = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userString = userEditText.getText().toString().trim();
                passString = passEditText.getText().toString().trim();

                if ((userString.length() == 0) || (passString.length() == 0)) {
                    Toast.makeText(getApplicationContext(), "กรอกให้ครบทุกช่อง", Toast.LENGTH_SHORT).show();
                } else {
                    if ((passString.equals("1234"))) {
                        Toast.makeText(getApplicationContext(), "ยินดีตอนรับ " + userString, Toast.LENGTH_SHORT).show();

                        Intent menuIntent = new Intent(MainActivity.this, GameActivity.class);
                        menuIntent.putExtra("Name", userString);
                        startActivity(menuIntent);
                    } else {
                        Toast.makeText(getApplicationContext(),"กรอกไม่ถูกต้อง กรุณากรอกใหม่",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }//End onCreate
}//End class
