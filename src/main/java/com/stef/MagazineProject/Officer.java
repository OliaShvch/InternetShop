package com.stef.MagazineProject;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Officer extends Employee {
    private  int recordofProductinStock;

    public int getRecordofProductinStock() {
        return recordofProductinStock;
    }

    public void setRecordofProductinStock(int recordofProductinStock) {
        this.recordofProductinStock = recordofProductinStock;
    }

    public Officer() {
        setName("name");
        setSurname("surname");
        setBornDate(new GregorianCalendar(1990, 01, 01));
        setId();
        setSalary(2000);
        setRating(0);
        setDate_of_begin(new GregorianCalendar(2016, 5, 5));
        setMarks(new ArrayList<Mark>());
        this.recordofProductinStock = 0;
    }

    public Officer(String name, String surname, int year, int month, int day, double salary, int recordofProductinStock) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year,month,day));
        setId();
        setSalary(salary);
        setRating(0);
        setDate_of_begin(new GregorianCalendar(2016, 5, 5));
        setMarks(new ArrayList<Mark>());
        this.recordofProductinStock = recordofProductinStock;
    }
    public void setBonus(){
        setSalary(getSalary()*1.50);
    }

    @Override
    public String toString() {
        return "Officer{" +
                "name: " + getName() + "\n" +
                "surname: " + getSurname() + "\n" +
                "Old: " + getAge() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Experience: " + getExperience() + "\n" +
                "recordofProductinStock: " + recordofProductinStock +
                '}';
    }
}
