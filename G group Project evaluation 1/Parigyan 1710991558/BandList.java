import java.io.*;
import java.util.*;

public class BandList{
  private ArrayList<String> bands;
  //Constructor
  public BandList(String pathname) {
    bands = new ArrayList();
    File file = new File(pathname);
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        bands.add(sc.nextLine());
      }
    } catch (FileNotFoundException e) {
      System.out.println("Please make sure the file exists!");
    }
  }
  
  public String getRandomBand(){
    int bandIndex = (int)(Math.random()*bands.size());
    return bands.get(bandIndex);
  }
}
