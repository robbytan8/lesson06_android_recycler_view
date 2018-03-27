package com.robby.lesson06_android_recycler_view.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Robby Tan
 */

public class Student implements Parcelable {

    private String id;
    private String firstName;
    private String lastName;
    private String department;
    private String address;

    private String phone;

    protected Student(Parcel in) {
        id = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        department = in.readString();
        address = in.readString();
        phone = in.readString();
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getDetails() {
        return firstName.concat(" ").concat(lastName).concat(" (").concat(id).concat(")");
    }

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(department);
        dest.writeString(address);
        dest.writeString(phone);
    }
}
