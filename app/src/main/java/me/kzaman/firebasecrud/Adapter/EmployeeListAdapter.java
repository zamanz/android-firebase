package me.kzaman.firebasecrud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import me.kzaman.firebasecrud.Models.Employee;
import me.kzaman.firebasecrud.R;

public class EmployeeListAdapter extends ArrayAdapter {

    List<Employee> employeeList = new ArrayList<Employee>();

    public EmployeeListAdapter(Context context, List<Employee> employeeList){
        super(context, R.layout.custom_layout,employeeList);
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.custom_layout,parent, false);

        TextView name = row.findViewById(R.id.name);
        name.setText(employeeList.get(position).getName());

        return row;
    }
}
