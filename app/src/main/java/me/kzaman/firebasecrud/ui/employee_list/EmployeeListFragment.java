package me.kzaman.firebasecrud.ui.employee_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import me.kzaman.firebasecrud.R;


public class EmployeeListFragment extends Fragment {

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    CollectionReference employees = firebaseFirestore.collection("employees");
    List<String> stringList = new ArrayList<String>();
    public EmployeeListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.employees_list);
        employees.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("employee_list", document.getId() + " => " + document.getString("name"));
                        stringList.add(document.getString("name"));
                        //EmployeeModel employee_list = document.toObject(EmployeeModel.class);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, stringList);
                    arrayAdapter.notifyDataSetChanged();
                    listView.setAdapter(arrayAdapter);
                }
                else {
                    Log.w("doc", "Error getting documents.", task.getException());
                }
            }
        });
    }
}