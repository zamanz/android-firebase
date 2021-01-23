package me.kzaman.firebasecrud.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import me.kzaman.firebasecrud.R;

public class EmployeeFragment extends Fragment {


    public EmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        ListView listView = (ListView) view.findViewById(R.id.users_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cars);
        listView.setAdapter(arrayAdapter);
        return view;
    }
}