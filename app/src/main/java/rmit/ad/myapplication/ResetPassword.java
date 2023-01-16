package rmit.ad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResetPassword extends AppCompatActivity {

    EditText et_email;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        et_email = (EditText) findViewById(R.id.reset_et_email);
        btn_send = (Button) findViewById(R.id.reset_btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    Intent intent = new Intent(ResetPassword.this, EmailVerification.class);
                    startActivityForResult(intent, 200);
                }
            }
        });
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(et_email.getText())) {
            et_email.setError("Please enter your email!");
            return false;
        }

        String email = (String) et_email.getText().toString();

        // Check if email is valid
        if ((email.contains(" ")) || !(email.contains("@"))) {
            et_email.setError("Invalid Email!");
            return false;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                Intent resultIntent = new Intent();
                String email = (String) et_email.getText().toString();
                resultIntent.putExtra("email", email);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        }
    }
}