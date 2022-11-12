package day3_automation;

import java.util.ArrayList;

public class arraylist_loop_conditions {
    public static void main(String[] args) {
        // <> refers to anchor
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("Japan");
        countries.add("Egypt");
        countries.add("Kuwait");

        //using for loop to iterate through countries list and print out the country USA or Kuwait
        for (int i=0; i < countries.size(); i++){
            if(countries.get(i) == "USA"){
                System.out.println("Country is USA and index i is " +i);
            } else if (countries.get(i) == "Kuwait"){
                System.out.println("Country is Kuwait and index i is " +i);
            }

            //to comment/uncomment


              /*
            if(countries.get(i) == "USA"){
                System.out.println("Country is USA. And index i is " + i);
            } else if(countries.get(i) == "Australia"){
                System.out.println("Country is Australia. And index i is " + i);
            }
            */


        }//end of loop

    }

    }

