package me.kzaman.firebasecrud.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import me.kzaman.firebasecrud.R;

public class AddEmployeeFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button save_btn;
    TextInputLayout name, email, phone;


    public AddEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_employee, container, false);

        //save btn
        save_btn = view.findViewById(R.id.save_btn);

        name = (TextInputLayout) view.findViewById(R.id.nameInputField);
        email = (TextInputLayout) view.findViewById(R.id.emailInputField);
        phone = (TextInputLayout) view.findViewById(R.id.phoneInputField);

        // Create a new user with a first and last name



        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set value
                Map<String, Object> employee = new HashMap<>();
                employee.put("name", name.getEditText().getText().toString());
                employee.put("email", email.getEditText().getText().toString());
                employee.put("corporate_number", phone.getEditText().getText().toString());

                // Add a new document with a generated ID
                db.collection("employees")
                    .add(employee)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getContext(), "DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getContext(), "Error adding document" + e, Toast.LENGTH_LONG).show();
                        }
                    });
            }
        });
        return view;
    }
}