package com.endurance.compare;

import com.endurance.dao.EmployeeDao;
import com.endurance.entity.Employee;

public class CompareEmployee {


    private EmployeeDao employeeDao;

    public CompareEmployee(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }

    public String higherSalaryEmployee(int id1, int id2){
        Employee employee1=employeeDao.retrieve(id1);
        Employee employee2=employeeDao.retrieve(id2);
        String firstName=(employee1.getSalary()>employee2.getSalary())?employee1.getFirstName():employee2.getFirstName();
        return firstName;
    }

    public String olderEmployee(int id1,int id2){
        Employee employee1=employeeDao.retrieve(id1);
        Employee employee2=employeeDao.retrieve(id2);
        String lastName=(employee1.getJoiningYear()<employee2.getJoiningYear())?employee1.getLastName():employee2.getLastName();
        return lastName;
    }
}
