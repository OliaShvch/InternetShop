package com.stef.MagazineProject;

import java.util.ArrayList;
import java.util.GregorianCalendar;


    public class Sale {

        private GregorianCalendar time, date;
        ArrayList<SalesLineItem> lines;


        public GregorianCalendar getTime() {
            return time;
        }


        public void setTime(GregorianCalendar time) {
            this.time = time;
        }


        public GregorianCalendar getDate() {
            return date;
        }


        public void setDate(GregorianCalendar date) {
            this.date = date;
        }


        public ArrayList<SalesLineItem> getLines() {
            return lines;
        }


        public void setLines(ArrayList<SalesLineItem> lines) {
            this.lines = lines;
        }


        public Sale() {
            time = new GregorianCalendar();
            date = new GregorianCalendar();
            lines = new ArrayList<SalesLineItem>();
        }


        public void addLine(int quantity,String name,String description, double price, String vendor, int warranty) {
            lines.add(new SalesLineItem(quantity,name,description,price,vendor,warranty));
        }


        public double allPrice() {
            double temp = 0;
            for (int i = 0; i < lines.size(); i++) {
                temp += lines.get(i).sumLine();
            }
            return temp;
        }


        @Override

        public String toString() {
            return "Sale{" +
                    " lines=" + lines.toString() +
                    '}';
        }

    }

