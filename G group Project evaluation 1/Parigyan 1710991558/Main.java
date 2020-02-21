

public class Main {
  public static void main(String[] args){
    Game game = new Game("bands.txt");
    
    System.out.println("Guess the Band!");
    System.out.println("It randomly picks a band name, and shows you how many letters its made up of.");
    System.out.println("Now figure out the band by guessing one letter at a time.");
    System.out.println("If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point.");
    System.out.println("If you lose 10 points, game over!!");
    System.out.println("Let's start!");
    System.out.println("the band title has "+game.getBandTitle().length() + " characters (including spaces and punctuation).");
    
    while(!game.gameEnded()){
      System.out.println("You are guessing: " + game.getHiddenBandTitle());
      System.out.println("You have guessed (" + game.getWrongLetters().length()/2+ ") wrong letters" + game.getWrongLetters());
      game.guessLetter();
    }
    if (game.WonGame()){
      System.out.println("You win!");
      System.out.println("You have guessed '"+ game.getBandTitle()+"' correctly");
    }
    else {
      System.out.println("You have guessed ("+ game.getWrongLetters().length()/2 +") wrong letters:" + game.getWrongLetters());
      System.out.println("You lost!");
      System.out.println("The Band title was "+ game.getBandTitle());
      System.out.println("Better luck next time.");
    }
  }  
}


