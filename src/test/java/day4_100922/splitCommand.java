package day4_100922;

public class splitCommand {
    public static void main(String[] args) {

        //declare a string variable
        String message = "My name is John";
        //extract out John from the string and print it
        //call split message by using String array
        String[] splitMessage = message.split(" ");
        System.out.println("result: " + splitMessage[3]);

        //extracting each character from a string
        String message2 = "abc";
        String[] splitMessage2 = message2.split("");
        System.out.println("Index 2 is: " +splitMessage2[1]);

    }//end of main
}
