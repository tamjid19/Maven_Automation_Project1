package action_items;

import java.util.ArrayList;

public class actionitem1_part2 {
    public static void main(String[] args) {
        ArrayList<String> regions = new ArrayList<>();
        //now add values for regions array
        regions.add("Bronx,NY");
        regions.add("Alaska");
        regions.add("Delaware");
        regions.add("Arkansas");

        //call an integer array list for area code
        ArrayList<Integer> areaCode = new ArrayList<>();
        areaCode.add(718);
        areaCode.add(907);
        areaCode.add(302);
        areaCode.add(501);

        for (int x = 0; x < regions.size(); x++) {
            System.out.println("My region is " + regions.get(x) + " and my area code is " + areaCode.get(x));
            //end of for loop
        }



    } //end of main
} //end of java class

