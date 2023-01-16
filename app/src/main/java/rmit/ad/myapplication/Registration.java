package rmit.ad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    EditText et_email, et_name, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        et_name = findViewById(R.id.regis_et_name);
        et_email = findViewById(R.id.regis_et_email);
        et_password = findViewById(R.id.regis_et_password);

        Button registerButton = (Button) findViewById(R.id.regis_btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    Intent intent = new Intent(Registration.this, EmailVerification.class);
                    startActivityForResult(intent, 100);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Intent resultIntent = new Intent();
                String email = (String) et_email.getText().toString();
                resultIntent.putExtra("email", email);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        }
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(et_name.getText())) {
            et_name.setError("Please enter your name!");
            return false;
        }

        if (TextUtils.isEmpty(et_email.getText())) {
            et_email.setError("Please enter your email!");
            return false;
        }

        if (TextUtils.isEmpty(et_password.getText())) {
            et_password.setError("Please enter a password!");
            return false;
        }

        String email = (String) et_email.getText().toString();
        String password = (String) et_password.getText().toString();

        // Check if email is valid
        if ((email.contains(" ")) || !(email.contains("@"))) {
            et_email.setError("Invalid Email!");
            return false;
        }

        //Check if password is valid
        if (password.contains(" ")) {
            et_password.setError("Invalid Email!");
            return false;
        }

        return true;
    }
}