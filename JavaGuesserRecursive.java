import java.util.*;

public class JavaGuesserRecursive {

  public static void main(String[] args) {
    new JavaGuesserRecursive();
  }

  JavaGuesserRecursive() {
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

    System.out.println();
    System.out.print("Please Enter 0-2: ");

    //get choice
    Scanner input = new Scanner(System.in);
    String choice = input.nextLine();

    System.out.println();

    return choice;
  }

  public void humanGuesser() {
    //get an answer between 1 and 100
    int correct = (int)(Math.floor(Math.random() * 100) + 1);

    int round = humanGuesser(correct, 0);

    System.out.println(round);

    System.out.println();
    if (round < 7) {
        System.out.println("Fantastic Job!");
    } else if (round == 7) {
        System.out.println("Well done.");
    } else {
        System.out.println("Maybe you should try again...");
    }
  }

  public int humanGuesser(int correct, int round) {
    
    Scanner input = new Scanner(System.in);
    
    //increment round
    round++;

    //get guess
    System.out.print(String.valueOf(round) + ") Please Enter a number: ");
    String guess = input.nextLine();
        
    //parse guess into an integer
    int guessInt = 0;
    try {
        guessInt = Integer.parseInt(guess);
    } catch (NumberFormatException exception) {
        //if not a number, user will retry with the same round number
        System.out.println("That is not a number!");
        return humanGuesser(correct, round - 1);
    }

    //determine whether guess is too high, too low, or correct
    if (guessInt > correct) {
        System.out.println("Too High!");
    } else if (guessInt < correct) {
        System.out.println("Too Low!");
    } else {
        System.out.println("Correct!");
        return round;
    }

    return humanGuesser(correct, round);
  }

  //specific function to get mean of two ints as closest value (meaning 1 and 100 returns 51)
  public int getMean(int x, int y) {
    return Math.round((float)(x + y) / 2);
  }

  //default for computerGuesser values
  public void computerGuesser() {
    //we use values 0 and 101 because these numbers are exclusive
    computerGuesser(0, 101, 0);
  }

  public void computerGuesser(int lower, int upper, int round) {
    //set initial values and get mean for first guess
    int guess = getMean(lower, upper);
    
    Scanner input = new Scanner(System.in);

    //increment round
    round++;

    //query user about the number
    System.out.println(guess);
    System.out.println(String.valueOf(round) + ") Too (H)igh, too (L)ow, or (C)orrect?");
    String choice = input.nextLine().toLowerCase();
        
    if (choice.equals("h")) {
        //this means the number is too high, so the upper limit should be the current guess
        upper = guess;
        guess = getMean(lower, upper);
    } else if (choice.equals("l")) {
        //this means the number is too low, so the lower limit should be the current guess
        lower = guess;
        guess = getMean(lower, upper);
    } else if (choice.equals("c")) {
        return;
    } else {
        System.out.println("Invalid input, please try again.");
    }

    //if upper or lower ever equals guess then there is no proper answer
    if (upper + 1 == guess || lower - 1 == guess) {
        System.out.println("There is no correct answer.");
        return;
    }
    computerGuesser(lower, upper, round);
  }

}