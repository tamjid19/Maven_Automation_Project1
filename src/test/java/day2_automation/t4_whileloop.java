package day2_automation;

public class t4_whileloop {

    public static void main(String[] args) {
        //declare and define linear array for street number
        int[] streetNumber = new int[]{111,444,777,999,447};
        //iterate through all street numbers by while loop
        //set the initializer
        int i = 0;
        //now set the condition for while loop
        //linear array gets the count by using .length command
        while (i < streetNumber.length){
            System.out.println("Street Number: " + streetNumber[i]);
            //incrementation goes at the end of the while loop
            i++;
        }//end of while loop

    }//end of main


}//end of public class

