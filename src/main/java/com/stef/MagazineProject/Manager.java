package com.stef.MagazineProject;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Manager extends Employee {

    private String phone;
    private String department;

    public Manager() {
        setName("name");
        setSurname("surname");
        setBornDate(new GregorianCalendar(1990, 01, 01));
        setId();
        setSalary(2000);
        setRating(0);
        setDate_of_begin(new GregorianCalendar(2016, 5, 5));
        setMarks(new ArrayList<Mark>());
        this.phone = phone;
        this.department = department;
    }

    public Manager(String name, String surname, int year, int month, int day, double salary, String phone, String department) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year, month, day));
        setId();
        setSalary(salary);
        setRating(0);
        setDate_of_begin(new GregorianCalendar(2016, 5, 5));
        setMarks(new ArrayList<Mark>());
        this.phone = phone;
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBonus() {
        setSalary(getSalary() * 1.20);
    }

    @Override
    public String toString() {
        return "Manager{" + "\n" +
                "name: " + getName() + "\n" +
                "surname: " + getSurname() + "\n" +
                "Old: " + getAge() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Experience: " + getExperience() + "\n" +
                "phone: " + phone + "\n" +
                ", department: " + department + "\n" +
                '}';
    }
}
