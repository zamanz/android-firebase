package me.kzaman.firebasecrud.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import me.kzaman.firebasecrud.Models.Employee;
import me.kzaman.firebasecrud.R;
import me.kzaman.firebasecrud.viewModel.EmployeeListAdapter;

public class EmployeeActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public List<Employee> employeeList;

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        listView = findViewById(R.id.employee_list);
        employeeList = new ArrayList<Employee>();
        EmployeeListAdapter employeeListAdapter;

        db.collection("employees")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            ///Log.d("employee", document.getId() + " => " + document.getData());
                            Employee employees = document.toObject(Employee.class);
                            employeeList.add(employees);
                        }
                    }
                    else {
                        Log.w("doc", "Error getting documents.", task.getException());
                    }
                }
            });

        employeeListAdapter = new EmployeeListAdapter(getApplicationContext(), employeeList);
        listView.setAdapter(employeeListAdapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}