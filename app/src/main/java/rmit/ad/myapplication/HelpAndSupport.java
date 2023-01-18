package rmit.ad.myapplication;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HelpAndSupport extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_help_and_support, container, false);

        EditText messageEditText = view.findViewById(R.id.help_et_msg);

        Button submitBtn = view.findViewById(R.id.help_support_submit_button);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();
                if (!TextUtils.isEmpty(message)) {
                    messageEditText.setText("");
                    Toast.makeText(getContext(), "Message sent!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Please enter a message", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}