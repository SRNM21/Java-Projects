import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String userMove = null;
    static String comMove = null;
    static int userScore = 0;
    static int comScore = 0;

    public static void main(String[] args) throws Exception {

        char playAgain;
        try (Scanner s = new Scanner(System.in)) {
            do {
                lineBanner();
                System.out.println("Rock: 1 | Paper: 2 | Scissors: 3");
                System.out.print("Choose move:\t\t");
                int userInput = s.nextInt();

                if (!(userInput != 0 && userInput <= 3)){
                    do {
                        System.out.print("Invalid Input, \nPlease choose again:\t");
                        userInput = s.nextInt();
                    } while (!(userInput != 0 && userInput <= 3));
                }
                lineBanner();

                switch(userInput){
                    case 1:
                        userMove = "Rock";
                        break;
                    case 2:
                        userMove = "Paper";
                        break;
                    case 3:
                        userMove = "Scissors";
                        break;
                }
                
                Random r = new Random();
                int comInput = r.nextInt(3)+1;

                switch(comInput){
                    case 1:
                        comMove = "Rock";
                        break;
                    case 2:
                        comMove = "Paper";
                        break;
                    case 3:
                        comMove = "Scissors";
                        break;
                }

                if (userMove.equals("Invalid")) System.out.println("Invalid Input!");
                else checkWinner();

                System.out.print("Try Again? (Y/N)\t");
                playAgain = s.next().charAt(0);
            }while (playAgain == 'y' || playAgain == 'Y');
        } catch (Exception e){
            lineBanner();
            System.out.println("Invalid Input!");
        }
        System.out.println("\nEND OF THE PROGRAM");
        lineBanner();
    }

    public static void lineBanner(){
        System.out.println("========================================");
    }

    public static void checkWinner(){

        if (userMove.equals(comMove)){

            System.out.println("You choose:\t\t" + userMove);
            System.out.println("Computer choose:\t" + comMove);
            System.out.println("\nDraw!\n");
            System.out.println("You:\t\t\t" + userScore);
            System.out.println("Computer:\t\t" + comScore);
            lineBanner();
        } else if 
        (userMove.equals("Rock") && comMove.equals("Scissors")
        ||userMove.equals("Paper") && comMove.equals("Rock")
        ||userMove.equals("Scissors") && comMove.equals("Paper")){

            String resultA = null;
            switch (userMove){
                case "Rock":
                    resultA = " crushes ";
                    break;
                case "Paper":
                    resultA = " covers ";
                    break;
                case "Scissors":
                    resultA = " cuts ";    
                    break;   
            }

            System.out.println("You choose:\t\t" + userMove);
            System.out.println("Computer choose:\t" + comMove);
            System.out.println("\n" + userMove + resultA + comMove );
            System.out.println("\nYou Win!\n");
            userScore++;
            System.out.println("You:\t\t\t" + userScore);
            System.out.println("Computer:\t\t" + comScore);
            lineBanner();
        } else {

            String resultB = null;
            switch (comMove){
                case "Rock":
                    resultB = " crushes ";
                    break;
                case "Paper":
                    resultB = " covers ";
                    break;
                case "Scissors":
                    resultB = " cuts ";    
                    break;   
            }

            System.out.println("You choose:\t\t" + userMove);
            System.out.println("Computer choose:\t" + comMove);
            System.out.println("\n" + comMove + resultB + userMove);
            System.out.println("\nYou Lose!\n");
            comScore++;
            System.out.println("You:\t\t\t" + userScore);
            System.out.println("Computer:\t\t" + comScore);
            lineBanner();
        }
    }
}