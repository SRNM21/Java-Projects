import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static int occupiedSlots = 0;
    static String[] slots ={"place holder for index 0, so the slot starts to 1",
                            "1", "2", "3",
                            "4", "5", "6",
                            "7", "8", "9",};
    
    public static void main(String[] args) throws Exception {
        
        char tryAgain;
        try (Scanner s = new Scanner(System.in)) {
            do {
                String result = null; 
                occupiedSlots = 0;
                resetBoard();
                lineBanner();
                System.out.println("Welcome to TicTacToe");
                
                while(result == null) {
                    printBoard();
                    if (occupiedSlots != 9){
                        getPlayerMove();
                    }
                    if (occupiedSlots != 9){
                        getComputerMove();
                    } 
                    result = checkWinner();
                    lineBanner();
                } 

                printBoard();
                System.out.println(result);
                System.out.print("Try Again? (Y/N)\t\t\t\t");
                tryAgain = s.next().charAt(0);
            } while (tryAgain == 'Y' || tryAgain == 'y');
        } 
        lineBanner();
        System.out.println("Thank you for playing!");
        System.out.println("END OF THE PROGRAM");
        lineBanner();
    }
    
    public static void printBoard(){
        System.out.println("\t" + slots[1] + "|" + slots[2] + "|" + slots[3]);
        System.out.println("\t-----");
        System.out.println("\t" + slots[4] + "|" + slots[5] + "|" + slots[6]);
        System.out.println("\t-----");
        System.out.println("\t" + slots[7] + "|" + slots[8] + "|" + slots[9]);
    }

    public static String getPlayerMove(){
        int selectedSlot = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Select slot number to place your move:\t\t");
        selectedSlot = s.nextInt();

        do {
            if (!(selectedSlot != 0 && selectedSlot <= 9)) {
                System.out.print("Invalid Input, Please choose again:\t\t");
                selectedSlot = s.nextInt();
            }

            if (slots[selectedSlot] == "X" || slots[selectedSlot] == "O") {
                System.out.print("This slot is taken, Please choose again:\t");
                    selectedSlot = s.nextInt();
            }
        } while (!(selectedSlot != 0 && selectedSlot <= 9) 
                || slots[selectedSlot] == "X" || slots[selectedSlot] == "O");

        occupiedSlots++;
        return slots[selectedSlot] = "X";
    }

    public static String getComputerMove(){
        Random r = new Random();
		int cSelectedSlot = 0;
		
		do {
			cSelectedSlot = r.nextInt(9)+1;
		} while (slots[cSelectedSlot] == "X" || slots[cSelectedSlot] == "O");

        System.out.println("Computer chose slot:\t\t\t\t" + cSelectedSlot);
        occupiedSlots++;
        return slots[cSelectedSlot] = "O";
    }

    public static String checkWinner(){
        for (int i = 0; i < 8; i++){
            String line = null;

            switch(i){
                case 0:
                    line = slots[1] + slots[2] + slots[3];
                    break;
                case 1:
                    line = slots[4] + slots[5] + slots[6];
                    break;
                case 2:
                    line = slots[7] + slots[8] + slots[9];
                    break;
                case 3:
                    line = slots[1] + slots[4] + slots[7];
                    break;
                case 4:
                    line = slots[2] + slots[5] + slots[8];
                    break;
                case 5:
                    line = slots[3] + slots[6] + slots[9];
                    break;
                case 6:
                    line = slots[1] + slots[5] + slots[9];
                    break;
                case 7:
                    line = slots[3] + slots[5] + slots[7];
                    break;
            }
            if (line.equals("XXX"))
                return "Player X Wins!";
            else if (line.equals("OOO"))
                return "Player O Wins!";
            
            if (occupiedSlots == 9)
                return "Draw!";
        }
        return null;
    }

    public static void resetBoard(){
        for (int i = 1; i < slots.length; i++) {
            slots[i] = ("" + i);
        }
    }
    public static void lineBanner(){
        System.out.println("======================================================");
    }
}

