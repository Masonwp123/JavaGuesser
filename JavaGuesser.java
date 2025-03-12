import java.util.*;

public class JavaGuesser {

  public static void main(String[] args) {
    new JavaGuesser();
  }

  JavaGuesser() {
    boolean keepGoing = true;
    while (keepGoing) {
        //get player choice
        String response = printMenu();

        if (response.equals("0")) {
            //exit
            keepGoing = false;
        } else if (response.equals("1")) {
            //computer generates a random number, user guesses
            humanGuesser();
        } else if (response.equals("2")) {
            //user decides a number, computer guesses
            computerGuesser();
        } else {
            //no valid input
            System.out.println("Invalid Input, please try again");
        }
    }
  }

  public String printMenu() {
    System.out.println();
    System.out.println("0) Exit");
    System.out.println("1) Human Guesser");
    System.out.println("2) Computer Guesser");

    //get choice
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public void humanGuesser() {
    //get an answer between 1 and 100
    int correct = (int)(Math.floor(Math.random() * 100) + 1);
    
    int round = 1;
    boolean keepGoing = true;
    
    Scanner input = new Scanner(System.in);
    
    while (keepGoing) {
        //get guess
        System.out.print(String.valueOf(round) + ") Please Enter a number: ");
        String guess = input.nextLine();
        
        //decode guess into an integer
        int guessInt = 0;
        try {
            guessInt = Integer.decode(guess);
        } catch (NumberFormatException exception) {
            //if not a number, user will retry
            System.out.println("That is not a number!");
            continue;
        }

        //determine whether guess is too high, too low, or correct
        if (guessInt > correct) {
            System.out.println("Too High!");
        } else if (guessInt < correct) {
            System.out.println("Too Low!");
        } else {
            System.out.println("Correct!");
            keepGoing = false;
        }
        round++;
    }
  }

  //specific function to get mean of two ints as closest value (meaning 1 and 100 returns 51)
  public int getMean(int x, int y) {
    return Math.round((float)(x + y) / 2);
  }

  public void computerGuesser() {
    //set initial values and get mean for first guess
    int lower = 1;
    int upper = 100;
    int guess = getMean(lower, upper);
    
    Scanner input = new Scanner(System.in);

    int round = 1;
    boolean keepGoing = true;
    while (keepGoing) {
        //query user about the number
        System.out.println(guess);
        System.out.println(String.valueOf(round) + ") Too (H)igh, too (L)ow, or (C)orrect?");
        String choice = input.nextLine();
        
        if (choice.equals("h")) {
            //this means the number is too high, so the upper limit should be the current guess
            upper = guess;
            guess = getMean(lower, upper);
        } else if (choice.equals("l")) {
            //this means the number is too low, so the lower limit should be the current guess
            lower = guess;
            guess = getMean(lower, upper);
        } else if (choice.equals("c")) {
            keepGoing = false;
        } else {
            System.out.println("Invalid input, please try again.");
        }

        //if upper or lower ever equals guess then there is no proper answer
        if (upper == guess || lower == guess) {
            System.out.println("There is no correct answer.");
            keepGoing = false;
        }
        round++;
    }
  }

}