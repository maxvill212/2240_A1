//<editor-fold desc="NOTES">
/*

    **********ABOUT***********
    Maxime Villeneuve - 0583160
    Trent University
    This is the part 2 of of Assignment 1 for COIS 2240W 2019
    It uses a recursive and iterative function to display a user decided amount of Fibonacci numbers
    Uses the timing library to time which function is more efficient


    ******VARIABLES MAIN******
    int
        userInput -> how many Fibonacci numbers the user wants to see
        num1      -> initial 0 for the recursive function
        num2      -> initial 1 for the recursive function
    bool
        flag      -> makes sure the initial 0 and/or 1 is only displayed once for the recursion function
 */
//</editor-fold>

import java.util.Scanner;   // Enables user input

public class Main {

    public static void main(String[] args) {

        //<editor-fold desc="Variable Declaration">
        int userInput = 0, num1 = 0, num2 = 1;
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        //</editor-fold>

        // Welcomes the user and asks for the input, then stores it
        System.out.print("\n\nWelcome to a Fibonacci number program\n" +
                "How many numbers would you like to display? ");
        userInput = Integer.parseInt(input.next());

        // Adds a space for cleaner output screen
        System.out.println(" ");

        // Calls the iterative method
        fiboSeriesIts(userInput);

        // Recursive method
        long startTime = System.nanoTime();      // Starts timer for recursive function
        fiboSeriesRec(userInput, num1, num2, flag);    // Calls the recursive method
        long endTime = System.nanoTime();        // Stops the timer
        System.out.println("The recursion function took "
                + (endTime - startTime) + " nano seconds to complete\n");  //Calculates and output the running time
    }





    //<editor-fold desc="Notes Recursion"
    /*
        ***************ABOUT***************
        This is the recursive method
        Prints out the initial 0 and/or 1
        To count the number of recursions, it decreases the user input by 1
        Checks if its 0, if false, proceeds with the algorithm


        **********VARIABLES REC************
        int
            input     -> desired number fon Fibonacci number of the user
            num0      -> 2nd number from the current
            num1      -> 1st number from the current
            finalNum  -> latest number, to be printed
    */
    //</editor-fold>
    public static void fiboSeriesRec(int input, int num0, int num1, boolean flag){

        //<editor-fold desc="Variable Declaration"
        int finalNum;
        //</editor-fold>

        // Print out initial 0 and 1 if input is 2
        // This was done since the initial 1 and 0 are printed by default

        // If flag is true and input is 2
        if(flag && input == 2){
            System.out.println(num0 +"\n" + num1);  // Print 0 and 1
            flag = false;                           // Set flag to false
        }

        // If flag is true and input is 1
        else if( flag && input == 1){
            System.out.println(num0);               // Print 0
            flag = false;                           // Set flag to false
        }

        input--;    // Decrease user input

        //if statement to do recursion if input =! 0
        if(input > 1) {
            flag = false;
            finalNum = num0 + num1;            // Calculate the latest number
            System.out.println(finalNum);      // Print out final number
            num0 = num1;                       // Move preceding number down by 1
            num1 = finalNum;                   // Move current number to preceding position
            fiboSeriesRec(input, num0, num1, flag);  // Create recursion with new number set
        }
    }





    //<editor-fold desc="Notes">
    /*
        ***************ABOUT***************
        This is the iterative method
        Uses a for loop to calculate the Fibonacci numbers while the loop hasn't reached user input


        **********VARIABLES REC************
        int
            finalNum    -> number to be printed
            previous1   -> 1st number from current
            previous2   -> 2nd number from current
    */
    //</editor-fold>
    public static void fiboSeriesIts(int num){

        //<editor-fold desc="Variable Declaration">
        int finalNum = 0;
        int previous1 = 1, previous2;
        //</editor-fold>

        long startTime = System.nanoTime();     // Starts timer for iterative function

        //for loop that calculates and prints out Fibonacci numbers
        for (int i = 0; i < num; i++){
            System.out.println(finalNum);       // Prints current number
            previous2 = previous1;              // Moves preceding number down by 1
            previous1 = finalNum;               // Moves current number to preceding position
            finalNum = previous1 + previous2;   // Calculates the latest number
        }
        long endTime = System.nanoTime();       // Stops timer
        System.out.println("The iterative function took "
                + (endTime - startTime) + " nano seconds to complete\n");  //Calculates and output the running time

    }
}
