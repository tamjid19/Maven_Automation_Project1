package day2_automation;

import java.util.ArrayList;

public class linnear_array2 {

    public static void main(String[] args) {

        //declare and define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        // now add the values for countries array
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("Japan");

        //print USA from countries list
        System.out.println("Countries value: " + countries.get(0));
        //get me count of countries on list
        System.out.println("Countries count: " + countries.size());

        //call an integer array list for street number
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(222);
        streetNumber.add(444);
        System.out.println("First street number: " + streetNumber.get(0));

    }// end of main

}//end of java class
