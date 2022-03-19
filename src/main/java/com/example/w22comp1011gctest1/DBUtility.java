package com.example.w22comp1011gctest1;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    public static String user = "Kashish200471366";
    public static String password = "b11Oph_NCu";
    public static String connectionURL =    "jdbc:mysql://172.31.22.43:3306/Kashish200471366";

    public static ArrayList<Student> getStudentFromDB(){

            ArrayList<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM students;";

            try(
                    Connection conn = DriverManager.getConnection(connectionURL,user,password);
                    Statement statement = conn.createStatement();

                    ResultSet resultSet = statement.executeQuery(sql);
            ) {
                while (resultSet.next()){
                    int studentNumber =resultSet.getInt("studentNum");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String telephone = resultSet.getString("telephone");
                    String address = resultSet.getString("homeAddress");
                    String major = resultSet.getString("major");
                    String province = resultSet.getString("province");
                    int avgGrade = resultSet.getInt("avgGrade");


                    Student newStudent =new Student(studentNumber,firstName,lastName,telephone,address,major,province,avgGrade);

                    students.add(newStudent);


                }



            } catch (SQLException e) {
                e.printStackTrace();
            }


        return students;
    }
}
