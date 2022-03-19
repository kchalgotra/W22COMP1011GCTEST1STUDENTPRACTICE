package com.example.w22comp1011gctest1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class StudentViewController implements Initializable {

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> studentNumCol;

    @FXML
    private TableColumn<Student, String> firstNameCol;

    @FXML
    private TableColumn<Student, String> lastNameCol;

    @FXML
    private TableColumn<Student, String> telephoneCol;

    @FXML
    private TableColumn<Student, String> addressCol;

    @FXML
    private TableColumn<Student, String> provinceCol;

    @FXML
    private TableColumn<Student, Integer> avgGradeCol;

    @FXML
    private TableColumn<Student, String> majorCol;

    @FXML
    private CheckBox ontarioCheckBox;

    @FXML
    private Label numOfStudentsLabel;

    @FXML
    private CheckBox honourRollCheckBox;

    @FXML
    private ComboBox<String> areaCodeComboBox;

    private ArrayList<Student> students;
    @FXML
    private void applyFilter()  {
        tableView.getItems().clear();

        ArrayList<Student> filteredStudents = new ArrayList<>();
        filteredStudents.addAll(students);

        for(Student student:students){
            //Select only Ontario students
            if(ontarioCheckBox.isSelected()){

                if(!student.getProvince().equals("ON")){
                    filteredStudents.remove(student);
                }
            }
            //Select only honour roll
            if(honourRollCheckBox.isSelected()){
                if(student.getAvgGrade() < 80){
                    filteredStudents.remove(student);
                }
            }
            //filter students according to Area Code
            String areaCode = areaCodeComboBox.getSelectionModel().getSelectedItem();
            if(!areaCode.equals("All")){
                if(!student.getTelephone().substring(0,3).equals(areaCode)){
                    filteredStudents.remove(student);
                }
            }
        }

        tableView.getItems().addAll(filteredStudents);
        numOfStudentsLabel.setText("Number of student "+ tableView.getItems().size() );


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        studentNumCol.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        provinceCol.setCellValueFactory(new PropertyValueFactory<>("province"));
        avgGradeCol.setCellValueFactory(new PropertyValueFactory<>("avgGrade"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));


        students = DBUtility.getStudentFromDB();
        tableView.getItems().addAll(students);



        areaCodeComboBox.getItems().addAll(getAreaCode2());
        numOfStudentsLabel.setText("Number of students: "+ tableView.getItems().size());
    }
/*
    private TreeSet<String> getAreaCode(){
        TreeSet  areaCodes = new TreeSet();
        for(Student student : students ){
            areaCodes.add(student.getTelephone().substring(0,3));
        }
        return areaCodes;
    }*/


    private ArrayList<String> getAreaCode2(){

        ArrayList<String> areaCodes = new ArrayList<>();

        areaCodes.add("All");
        for(Student student : students){
            String areaCode = student.getTelephone().substring(0,3);
            if(!areaCodes.contains(areaCode)){
                areaCodes.add(areaCode);

            }
        }
        Collections.sort(areaCodes);
        return areaCodes;
    }



}
