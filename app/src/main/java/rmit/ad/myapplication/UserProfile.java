package rmit.ad.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user_profile, container, false);

        // Initialize layout elements
        EditText editTextName = view.findViewById(R.id.editTextName);
        EditText editTextEmail = view.findViewById(R.id.editTextEmail);
        Button buttonSave = view.findViewById(R.id.buttonSave);

        // Initialize Firebase components
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();


        // Retrieve user information from Firebase database
        databaseReference.child("Account").child("username").child("locphan201").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String user = dataSnapshot.getValue(String.class);
                Toast.makeText(getContext(), "Information updated successfully!", Toast.LENGTH_SHORT).show();
                editTextName.setText(user);
                editTextEmail.setText(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });

        firebaseDatabase.goOffline();
//        databaseReference = null;


//        // Handle "Save" button click event
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = editTextName.getText().toString().trim();
//                String email = editTextEmail.getText().toString().trim();
//
//                //Update user information in Firebase database
//                User user = new User(name, email);
//                databaseReference.child("users").child(firebaseAuth.getCurrentUser().getUid()).setValue(user);
//
//                Toast.makeText(getContext(), "Information updated successfully!", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }
}