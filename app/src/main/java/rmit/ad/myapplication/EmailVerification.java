package rmit.ad.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailVerification extends AppCompatActivity {

    private static final String NOTIFICATION_CHANNEL_ID = "Confirmation Code";
    private static final String verifiedCode = generateCode();
    EditText et_code;
    Button btn_verify, btn_resend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        et_code = (EditText) findViewById(R.id.verify_et_code);
        btn_verify = (Button) findViewById(R.id.verify_btn_verify);
        btn_resend = (Button) findViewById(R.id.verify_btn_resend);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputCode = (String) et_code.getText().toString();
                if ((verifiedCode.equals(inputCode))) {
                    Intent resultIntent = new Intent();
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else if (TextUtils.isEmpty(et_code.getText())) {
                    et_code.setError("Please enter the code!");
                } else {
                    et_code.setError("Please enter the correct code!");
                }
            }
        });

        btn_resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification(verifiedCode);
                Toast.makeText(EmailVerification.this, "The code has been re-sent to you!", Toast.LENGTH_SHORT).show();
            }
        });

        showNotification(verifiedCode);
        Toast.makeText(this, "The code has been sent to you!", Toast.LENGTH_SHORT).show();
    }

    private void showNotification(String verifiedCode) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My notification",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Verification Code")
                .setContentText("Your verification code is " + verifiedCode)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        notificationManager.notify(0, builder.build());
    }

    private static String generateCode() {
        String code = "";
        for (int i = 0; i < 5; i++) {
            code += "" + ((int) (Math.random() * 10));
        }
        return code;
    }
}