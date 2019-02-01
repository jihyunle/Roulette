import java.util.Scanner;

public class Roulette {

    public static void main(String[]args){
        Scanner keyboard = new Scanner(System.in);
        double betAmount = 0;
        String betType = "";
        int num = 0;
        String color = "";
        boolean win;
        double netAmount = 0;
        int numWins = 0;
        int numLosses = 0;

        showWelcomeMessage();

        while (true){
            System.out.print("Enter the type of bet you would like to place (red|black|even|odd|high|low): ");
            betType = keyboard.nextLine();
            System.out.print("Enter in your bet amount: ");
            betAmount = keyboard.nextDouble();

            num = generateNum();
            color = generateColor();

            System.out.println("The ball landed on " + num + " " + color + ".");

            win = analyzeWinUsingSwitch(betType, color, num);

            if (win){
                System.out.println("Congratulations, you've won.");
                netAmount += betAmount * 2;
                numWins++;
            } else {
                System.out.println("Sorry, you love this bet.");
                netAmount -= betAmount;
                numLosses++;
            }

            System.out.println("You currently have: $" + netAmount + "\n");

            if (!playAgain()){
                break;
            }

        }

        showExitMessage(netAmount, numWins, numLosses);
        keyboard.close();
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
    * Analyze win using if statements
    * */
    public static boolean analyzeWinUsingIf(String bet, String clr, int num){
        // Analyze color
        if (bet.equalsIgnoreCase(clr)){
            return true;
        }
//        else {
//            return false;
//        }

        // Analyze number
        if (bet.equalsIgnoreCase("even") && num%2==0){
            return true;
        }
//        else {
//            return false;
//        }

        if (bet.equalsIgnoreCase("odd") && num%2!=0){
            return true;
        }
//        else {
//            return false;
//        }

        if (bet.equalsIgnoreCase("low") && num<19){
            return true;
        }
//        else {
//            return false;
//        }

        if (bet.equalsIgnoreCase("high") && num>=19){
            return true;
        }

        else {
            return false;
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
//                } else {
//                    return false;
                }
                break;
            case "black":
                if (bet.equalsIgnoreCase(clr)){
                    return true;
//                } else {
//                    return false;
                }
                break;
            case "even":
                if (num%2==0){
                    return true;
//                } else {
//                    return false;
                }
                break;
            case "odd":
                if (num%2!=0){
                    return true;
//                } else {
//                    return false;
                }
                break;
            case "low":
                if (num<19){
                    return true;
//                } else {
//                    return false;
                }
                break;
            case "high":
                if (num>=19){
                    return true;
//                } else {
//                    return false;
                }
                break;
        }
        return false;
    }

    public static boolean playAgain(){
        System.out.println("Would you like to play again? (true|false)");
        Scanner keyboard = new Scanner(System.in);
        String reply = keyboard.nextLine().toLowerCase();
        if (reply.equals("true")){
            return true;
        } else {
            return false;
        }
    }

    public static void showExitMessage(double net, int wins, int losses){
        System.out.println("Thank you for playing!");
        System.out.println("This is how much money you have remaining: $" + net);
        System.out.println("You've won " + wins + " game(s) and lost " + losses + " game(s).");
    }

}















































