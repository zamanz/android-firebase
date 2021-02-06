package me.kzaman.firebasecrud.ui.new_employee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import me.kzaman.firebasecrud.R;

public class NewEmployeeFragment extends Fragment {

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    CollectionReference employees = firebaseFirestore.collection("employees");
    Button save_btn;
    TextInputLayout name, email, phone;


    public NewEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                employees.add(employee).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
    }
}