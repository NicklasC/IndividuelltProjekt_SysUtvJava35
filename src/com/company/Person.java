package com.company;

public class Person{
    String name;
    String surName;
    String phoneNumber;




    public Person(String name, String surName, String phoneNumber){
        this.name=name;
        this.surName=surName;
        this.phoneNumber=phoneNumber;
    }

    public static boolean createPerson(String name,String surName, String phoneNumber){
        String myString = "INSERT INTO Persons(name,surName,phoneNumber) Values ('"+name+"','"+surName+"','"+phoneNumber+"');";
        if(MySqlCon.myExecuteQuery(myString)){
            return true;
        }else{
            return false;
        }
    }

}
