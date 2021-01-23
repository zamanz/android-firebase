package me.kzaman.firebasecrud.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import me.kzaman.firebasecrud.Models.Employee;
import me.kzaman.firebasecrud.R;
import me.kzaman.firebasecrud.viewModel.EmployeeAdapter;

public class EmployeeFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Employee> employeeList;

    EmployeeAdapter employeeAdapter;

    public EmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee, container, false);

        employeeList = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(employeeList);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.users_list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(employeeAdapter);



        db.collection("employees")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentChange document : task.getResult().getDocumentChanges()) {
                                if (document.getType() == DocumentChange.Type.ADDED){
                                    //Log.d("doc", document.getDocument().getId() + " => " + document.getDocument().getString("name"));
                                    Employee employees = document.getDocument().toObject(Employee.class);
                                    employeeList.add(employees);
                                    employeeAdapter.notifyDataSetChanged();
                                }
                            }
                        } else {
                            Log.w("doc", "Error getting documents.", task.getException());
                        }
                    }
                });

                return view;
    }
}