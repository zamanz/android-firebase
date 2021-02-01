package me.kzaman.firebasecrud.ui.dashboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import me.kzaman.firebasecrud.R;
import me.kzaman.firebasecrud.LoginActivity;

public class DashboardFragment extends Fragment {

    ProgressDialog progressDialog;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        progressDialog = new ProgressDialog(getContext());

        Button logoutBtn = view.findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                    getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    Toast.makeText(getContext(), "User Successfully Logged Out", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                } catch (Exception e){
                    Log.d("error", e.getMessage());
                }

            }
        });
        return view;
    }
}