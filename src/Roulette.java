/*
* You will write a Java program to simulate Roulette, a casino game.

Players will be able to enter in the amount of money they want to bet and the type of bet they will be placing.

The types of bets include:
Red: You are betting that the next roll will come up red.
Black: You are betting that the next roll will come up black.
Even: This is wagering that the ball will land on an even number between 1-36.
Odd: This is wagering that the ball will land on an odd number between 1-36.
Low: This is a bet that the next number will be between 1 and 18.
High: This is a bet that the next number will be between 19 and 36.

The program will then randomly generate a number between 1-36 and a color (red or black). You will then double the player's amount if they won, or deduct their money if they lost.

Allow the user to play as many games as they want until they want to quit.

At the end of the program, print out the net amount of money they've earned, whether that's positive or negative. In addition, also print out the number of games they have won and lost.
*/
import java.util.Scanner;

public class Roulette {

    public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);

        // Declare variables (in order of appearance)
        double betAmount = 0;
        String betType = "";
        int num = 0;
        String color = "";
        boolean win;
        double netAmount = 0;
        int roundsWon = 0;
        int roundsLost = 0;

        // Show welcome message
        showWelcomeMessage();

        while (true){
            // Prompt user for input
            System.out.print("Enter the type of bet you would like to place (red|black|even|odd|high|low): ");
            betType = keyboard.nextLine();
            System.out.print("Enter in your bet amount: ");
            betAmount = keyboard.nextDouble();

            /*
            * Consume remaining new line character.
            * https://christprogramming.wordpress.com/2014/01/30/java-common-mistakes-1/*/
            keyboard.nextLine();

            // Simulate a round of Roulette by generating random number and a random color
            num = generateNum();
            color = generateColor();

            // Display where the ball landed
            System.out.println("The ball landed on " + num + " " + color + ".");

            // Determine whether the user won
            win = analyzeWinUsingSwitch(betType, color, num);

            /*
            * Display the result, update the net amount (+/-),
            * and keep counts of wins and losses*/
            if (win){
                System.out.println("Congratulations, you've won. \n");
                netAmount += betAmount * 2;
                roundsWon++;
            } else {
                System.out.println("Sorry, you've lost this bet. \n");
                netAmount -= betAmount;
                roundsLost++;
            }

            System.out.printf("You currently have: $" + "%.2f%n", netAmount);
            System.out.println();

            // Ask user if they want to continue
            if (!playAgain()){
                break;
            }
        } // End of while loop

        // Show exit message
        showExitMessage(netAmount, roundsWon, roundsLost);
//        keyboard.close();
        System.exit(0);
    }


    public static void showWelcomeMessage(){
        System.out.println("WELCOME! Let's Play some Roulette! \n");
    }

    public static int generateNum(){
        int num = 1 + (int)(Math.random()*36);
        return num;
    }

    public static String generateColor(){
        int i = (int)(Math.random()*2);
        if (i==0){
            return "red";
        } else {
            return "black";
        }
    }


    /*
     * Analyze win using switch statements
     * */
    public static boolean analyzeWinUsingSwitch(String bet, String clr, int num){
//        boolean win;
        switch (bet){
            case "red":
                if (bet.equalsIgnoreCase(clr)){
                    return true;
                }
                break;
            case "black":
                if (bet.equalsIgnoreCase(clr)){
                    return true;
                }
                break;
            case "even":
                if (num%2==0){
                    return true;
                }
                break;
            case "odd":
                if (num%2!=0){
                    return true;
                }
                break;
            case "low":
                if (num<19){
                    return true;
                }
                break;
            case "high":
                if (num>=19){
                    return true;
                }
                break;
        } // End of switch statement
        return false;
    }

    public static boolean playAgain(){
        System.out.print("Would you like to play again? (true|false) ");
        Scanner keyboard = new Scanner(System.in);
        String reply = keyboard.nextLine().toLowerCase();
        if (reply.equals("true")){
            return true;
        } else {
            return false;
        }
    }

    public static void showExitMessage(double net, int wins, int losses){
        System.out.println();
        System.out.println("Thank you for playing!");
        System.out.printf("This is how much money you have remaining: $" + "%.2f%n", net);
        System.out.println("You've won " + wins + " game(s) and lost " + losses + " game(s).");
    }

}















































