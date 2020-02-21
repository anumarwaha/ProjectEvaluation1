import java.util.Scanner;

public class Game {
  private String bandToGuess;
  private int pointsLost;
  private String wrongLetters;
  private String rightLetters;
  private boolean gameWon;
  
  //constructor intializing BandList
  public Game(String pathname) {
    BandList bandlist = new BandList(pathname);
    bandToGuess = bandlist.getRandomBand().trim();
    pointsLost = 0;
    rightLetters = "";
    wrongLetters = "";
    gameWon = false;
  }
  
  //method return title of band
  public String getBandTitle(){
    return bandToGuess;
  }
  
  //method that replaces all the letters in the band title with underscores, if no letters have been correctly guessed yet, and all the letters except the ones guessed, if any letter was already correctly guessed.
  public String getHiddenBandTitle(){
    if (rightLetters.equals("")){
      return bandToGuess.replaceAll("[a-zA-Z]", "_");
    }
    else{
      return bandToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_");
    }
  }
  
  //Method that returns letters guessed that are not in the band title.
  public String getWrongLetters(){
    return wrongLetters;
  }
  
  //Method that returns true if the game was won and false otherwise.
  public boolean WonGame(){
    return gameWon;
  }
  
  //Method that returns that the game has ended and the player did not win if number of points lost is at least 10, and returns that the game has ended and the player won if the previous is not true and there are no underscores left in the hidden version of the band title.
  public boolean gameEnded(){
    if (pointsLost >= 10){
      return true;
    }
    if(!getHiddenBandTitle().contains("_")){
      gameWon = true;
      return true;
    }
    return false;
  }
  
  private String inputLetter(){
    System.out.println("Guess the letter: ");
    Scanner scanner = new Scanner(System.in);
    String letter = scanner.nextLine().toLowerCase();
    
    if (!letter.matches("[a-z]")){
      System.out.println("This is not a letter.");
      return inputLetter();
    }
    else if (wrongLetters.contains(letter) || rightLetters.contains(letter)){
      System.out.println("You already guessed that letter.");
      return inputLetter();
    }
    else return letter;
  }
  
  public void guessLetter(){
    String guessedLetter = inputLetter();
    
    if (bandToGuess.toLowerCase().contains(guessedLetter)){
      rightLetters += guessedLetter + guessedLetter.toUpperCase();
    }
    else {
      pointsLost++;
      wrongLetters += " "+guessedLetter;
    }
  }
}
