package com.stef.MagazineProject;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public abstract class Employee extends Human {
    private static int nextId = 1;

    private int id;
    private GregorianCalendar date_of_begin;
    private double salary;
    private double rating;
    private ArrayList<Mark> marks;

    public boolean raiseSalary(int x) {
        if (x > 0) {
            this.salary += x;
            return true;
        }
        return false;
    }

    public String getExperience() {
        GregorianCalendar curentDate = new GregorianCalendar();
        int year, month, date, hour, minutes;

        year = curentDate.get(GregorianCalendar.YEAR)
                - date_of_begin.get(GregorianCalendar.YEAR);
        month = curentDate.get(GregorianCalendar.MONTH)
                - date_of_begin.get(GregorianCalendar.MONTH);
        date = curentDate.get(GregorianCalendar.DATE)
                - date_of_begin.get(GregorianCalendar.DATE);
        hour = curentDate.get(GregorianCalendar.HOUR)
                - date_of_begin.get(GregorianCalendar.HOUR);
        minutes = curentDate.get(GregorianCalendar.MINUTE)
                - date_of_begin.get(GregorianCalendar.MINUTE);

        if (month < 0) {
            month = 0;
        }
        return " year = " + year +
                " month = " + month +
                " date = " + date +
                " hour = " + hour +
                " minutes = " + minutes;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDate_of_begin(GregorianCalendar date_of_begin) {
        this.date_of_begin = date_of_begin;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public double getRating() {
        return rating;
    }

    public GregorianCalendar getDate_of_begin() {
        return date_of_begin;
    }

    public void addMark(double mark) {
        marks.add(new Mark(mark));
    }

    public void generationRating() {
        double sum = 0;
        int count = 0;
        GregorianCalendar current = new GregorianCalendar();

        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getTime().get(GregorianCalendar.MONTH) == current.get(GregorianCalendar.MONTH)) {
                count++;
                sum += marks.get(i).getMark();
            }
        }
        rating = sum / count;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public abstract void setBonus();
}
