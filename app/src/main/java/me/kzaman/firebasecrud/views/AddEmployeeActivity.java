package me.kzaman.firebasecrud.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import me.kzaman.firebasecrud.R;

public class AddEmployeeActivity extends AppCompatActivity {
    Button save_btn;
    TextInputLayout name, email, phone;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        //save btn
        save_btn = findViewById(R.id.save_btn);

        name = findViewById(R.id.nameInputField);
        email = findViewById(R.id.emailInputField);
        phone = findViewById(R.id.phoneInputField);

        editText = findViewById(R.id.editText);

        String StrName = name.getEditText().getText().toString();
        String StrEmail = email.getEditText().getText().toString();
        String StrPhone = phone.getEditText().getText().toString();

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}