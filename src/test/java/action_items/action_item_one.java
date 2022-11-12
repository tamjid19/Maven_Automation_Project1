package action_items;

import java.util.ArrayList;

public class action_item_one {
    public static void main(String[] args) {
        //declare and define the arraylist for countries
        ArrayList<String> countries = new ArrayList<>();
        //now add values for countries array
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("Japan");
        countries.add("Kuwait");

        //call an integer array list for country code
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(81);
        countryCode.add(965);

        for (int x = 0; x < countries.size(); x++) {
            System.out.println("My country is " + countries.get(x) + " and my country code is " + countryCode.get(x));
            //end of for loop
        }



    } //end of main
} //end of java class
