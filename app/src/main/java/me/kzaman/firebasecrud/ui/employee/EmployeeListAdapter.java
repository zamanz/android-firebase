package me.kzaman.firebasecrud.ui.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.kzaman.firebasecrud.R;


public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {


    private List<EmployeeModel> employeeModels;

    public void setEmployeeModels(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.name.setText(employeeModels.get(position).getName());
        holder.email.setText(employeeModels.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        if(employeeModels == null){
            return 0;
        }
        else {
            return employeeModels.size();
        }
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}