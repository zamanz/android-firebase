package me.kzaman.firebasecrud.ui.employee;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.kzaman.firebasecrud.repository.FirebaseRepository;

public class EmployeeViewModel extends ViewModel implements FirebaseRepository.OnFirestoreTaskComplete {

    private MutableLiveData<List<EmployeeModel>> employeeModelData = new MutableLiveData<>();

    public LiveData<List<EmployeeModel>> getEmployeeModelData() {
        return employeeModelData;
    }

    private FirebaseRepository firebaseRepository = new FirebaseRepository(this);

    public EmployeeViewModel() {
        firebaseRepository.getEmployeeData();
    }


    @Override
    public void employeeListDataAdded(List<EmployeeModel> employeeModels) {
        employeeModelData.setValue(employeeModels);
    }

    @Override
    public void onError(Exception e) {

    }
}
