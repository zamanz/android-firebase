package me.kzaman.firebasecrud.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import me.kzaman.firebasecrud.R;

public class AddEmployeeFragment extends Fragment {
    
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

        name = view.findViewById(R.id.nameInputField);
        email = view.findViewById(R.id.emailInputField);
        phone = view.findViewById(R.id.phoneInputField);

        String StrName = name.getEditText().getText().toString();
        String StrEmail = email.getEditText().getText().toString();
        String StrPhone = phone.getEditText().getText().toString();

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Name: " + StrName, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}