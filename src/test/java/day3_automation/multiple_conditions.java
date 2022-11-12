package day3_automation;

public class multiple_conditions {
    public static void main(String[] args) {
        //declare three integer variables
        int a, b, c;
        a = 2;
        b = 4;
        c = 6;

        //write multiple conditional statements that cover when a+b < c, a+b > c or a+b = c
        if(a+b < c){
            System.out.println("a & b is less than c");
        } else if (a+b > c){
            System.out.println("a & b is greater than c");
        } else {
            System.out.println("a & b is equal to c");
        }//end of conditions

    }//end of main

}//end of java class
