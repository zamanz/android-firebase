package me.kzaman.firebasecrud.ui.employee;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import me.kzaman.firebasecrud.R;


public class EmployeeFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<String> employeeList;

    ArrayAdapter arrayAdapter;

    public EmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee, container, false);

        employeeList = new ArrayList<>();

        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, employeeList);

        ListView listView = (ListView) view.findViewById(R.id.users_list);
        listView.setAdapter(arrayAdapter);

        db.collection("employees")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            //Log.d("employee", document.getId() + " => " + document.getData());
                            //EmployeeModel employee = document.toObject(EmployeeModel.class);
                            employeeList.add(document.getString("name"));
                        }
                    }
                    else {
                        Log.w("doc", "Error getting documents.", task.getException());
                    }
                }
            });

         return view;
    }
}