package me.kzaman.firebasecrud.ui.employee_list;

public class EmployeeModel {
    String name, corporate_number, personal_number, bcs_batch, blood_group, facebook, email, division_id, district_id, upazila_id, address, image;

    public EmployeeModel(String name, String corporate_number, String personal_number, String bcs_batch, String blood_group, String facebook, String email, String division_id, String district_id, String upazila_id, String address, String image) {
        this.name = name;
        this.corporate_number = corporate_number;
        this.personal_number = personal_number;
        this.bcs_batch = bcs_batch;
        this.blood_group = blood_group;
        this.facebook = facebook;
        this.email = email;
        this.division_id = division_id;
        this.district_id = district_id;
        this.upazila_id = upazila_id;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporate_number() {
        return corporate_number;
    }

    public void setCorporate_number(String corporate_number) {
        this.corporate_number = corporate_number;
    }

    public String getPersonal_number() {
        return personal_number;
    }

    public void setPersonal_number(String personal_number) {
        this.personal_number = personal_number;
    }

    public String getBcs_batch() {
        return bcs_batch;
    }

    public void setBcs_batch(String bcs_batch) {
        this.bcs_batch = bcs_batch;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getUpazila_id() {
        return upazila_id;
    }

    public void setUpazila_id(String upazila_id) {
        this.upazila_id = upazila_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
