package rmit.ad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button btn_forget, btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.main_et_username);
        et_password = (EditText) findViewById(R.id.main_et_password);
        btn_forget = (Button) findViewById(R.id.main_btn_forget);
        btn_login = (Button) findViewById(R.id.main_btn_login);
        btn_register = (Button) findViewById(R.id.main_btn_register);

        btn_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgetIntent = new Intent(MainActivity.this, ResetPassword.class);
                startActivityForResult(forgetIntent, 200);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidAndLogin()) {
                    Intent loginIntent = new Intent(MainActivity.this, NavigationPage.class);
                    startActivityForResult(loginIntent, 300);
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, Registration.class);
                startActivityForResult(registerIntent, 100);
            }
        });
    }

    private boolean isValidAndLogin() {
        if (TextUtils.isEmpty(et_username.getText())) {
            et_username.setError("Please enter your username!");
            return false;
        }
        if (TextUtils.isEmpty(et_password.getText())) {
            et_password.setError("Please enter your password!");
            return false;
        }

        String username = (String) et_username.getText().toString();
        String password = (String) et_password.getText().toString();

        // Check database

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                String email = (String) data.getExtras().get("email");
                et_username.setText(email);
                Toast.makeText(this, "Successfully Register!", Toast.LENGTH_SHORT).show();
            }

            if (requestCode == 200) {
                String email = (String) data.getExtras().get("email");
                et_username.setText(email);
                Toast.makeText(this, "Successfully Reset Password!", Toast.LENGTH_SHORT).show();
            }

            if (requestCode == 300) {
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}