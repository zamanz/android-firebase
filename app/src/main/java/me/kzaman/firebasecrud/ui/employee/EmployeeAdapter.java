package me.kzaman.firebasecrud.ui.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.kzaman.firebasecrud.R;


public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    public List<EmployeeModel> employeeModelList;

    public EmployeeAdapter(List<EmployeeModel> employeeModelList) {
        this.employeeModelList = employeeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(employeeModelList.get(position).getName());
        holder.email.setText(employeeModelList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return employeeModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);

        }
    }
}