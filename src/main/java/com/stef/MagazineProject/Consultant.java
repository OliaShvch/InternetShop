package com.stef.MagazineProject;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Consultant extends Employee {

    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Consultant() {
        setName("name");
        setSurname("surname");
        setBornDate(new GregorianCalendar(1990, 01, 01));
        setId();
        setSalary(2000);
        setRating(0);
        setDate_of_begin(new GregorianCalendar(2016, 5, 5));
        setMarks(new ArrayList<Mark>());
        this.order = 0;
    }

    public Consultant(String name, String surname, int year, int month, int day, double salary, int order) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year,month,day));
        setId();
        setSalary(salary);
        setRating(0);
        setDate_of_begin(new GregorianCalendar(2016, 5, 5));
        setMarks(new ArrayList<Mark>());
        this.order = order;
    }
    public void setBonus(){
        setSalary(getSalary()*1.10);
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "name: " + getName() + "\n" +
                "surname: " + getSurname() + "\n" +
                "Old: " + getAge() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Experience: " + getExperience() + "\n" +
                "order: " + order +
                '}';
    }
}
