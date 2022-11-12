package day2_automation;

import java.util.ArrayList;

public class t3_arrayloop {

    public static void main(String[] args) {
        //declare and define arrayList for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10022");
        zipCode.add("10461");
        zipCode.add("10088");
        zipCode.add("19987");
        zipCode.add("10456");
        zipCode.add("19766");
        zipCode.add("10034");

        //call for loop to print out all zip code values from the array list
        for (int i=0; i <zipCode.size(); i++){
            //print out each zip code automatically
            System.out.println("Zip code: " + zipCode.get(i));

        }
    }
}//end of java class
