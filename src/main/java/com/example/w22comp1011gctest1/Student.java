package com.example.w22comp1011gctest1;

import java.util.Arrays;
import java.util.List;

public class Student {

    private String firstName, lastName, telephone,address,major,province;
    private int studentNumber;
    private int avgGrade;





    public Student( int studentNumber,String firstName, String lastName, String telephone, String address, String major, String province, int avgGrade ) {
        setFirstName(firstName);
        setLastName(lastName);
        setTelephone(telephone);
        setAddress(address);
        setMajor(major);
        setStudentNumber(studentNumber);
        setAvgGrade(avgGrade);

        setProvince(province);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.trim().length()>1){
            this.firstName = firstName;
        }else throw new IllegalArgumentException("First name should be greater than 1 character.");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.trim().length()>1){
            this.lastName = lastName;
        }else throw new IllegalArgumentException("Last name should be greater than 1 character.");
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if(telephone.matches("\\(?[2-9][0-9][0-9]\\)?[-\\s]?[2-9]\\d{2}[-\\s]?[0-9]{4}")){
            this.telephone = telephone;
        }else throw new IllegalArgumentException("Telephone Number should match American dialing plan.");
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address.trim().length()>6){
            this.address = address;
        }else throw new IllegalArgumentException("Address length should be greater than 6 characters.");
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if(major.trim().length()>5){
            this.major = major;
        }else throw new IllegalArgumentException("Major should be greater than 5 characters.");
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        if(studentNumber>200034000){
            this.studentNumber = studentNumber;
        }
    }

    public int getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(int avgGrade) {
        if(avgGrade>=0 && avgGrade<=100){
            this.avgGrade = avgGrade;
        }else throw new IllegalArgumentException("Grade should be between 0 to 100.");
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        List<String> validProvince = Arrays.asList("AB","BC","MB","NB","NL","NS","NT","NU","ON","PE","QC","SK","YT");
        if (validProvince.contains(province)){
            this.province = province;
        } else throw new IllegalArgumentException("Province should be in the list of Valid Province.");
    }

    }

