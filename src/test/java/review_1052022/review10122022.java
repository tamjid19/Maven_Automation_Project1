package review_1052022;

public class review10122022 {

    public static void main(String[] args) {
        //split the string
        String subjectLine = "Automation_AI101";
        String[] splitMessageArray = subjectLine.split("_");
        //take the second string from the array then grab the number only
        String actionItemNumber = splitMessageArray[1].substring(2);
        //print out John to the console
        System.out.println("The action number item is " + actionItemNumber);






    }//end of main
}