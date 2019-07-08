package com.endurance.entity;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private long salary;
    private int joiningYear;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getSalary() {
        return salary;
    }

    public int getJoiningYear() {
        return joiningYear;
    }

    public Employee(int id, String firstName, String lastName, Long salary, int joiningYear){
        this.id=id;
        this.firstName=firstName;
        this.lastName =lastName;
        this.salary=salary;
        this.joiningYear=joiningYear;
    }

}
