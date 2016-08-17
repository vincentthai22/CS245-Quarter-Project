/*
 * Vincent Thai 
 * 
 * 
 */
package cs.pkg245;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Vincent
 */
public class FileWriter {
    Scanner inputFile;
    PrintWriter oStream;
    int[] Scores;
    public static void main(String[] args) throws IOException{
        FileWriter n = new FileWriter("highscores.txt");
        
    }
    public FileWriter(String fileName) throws FileNotFoundException, IOException{
        oStream = new PrintWriter(fileName);
        inputFile = new Scanner(new File(fileName));
        HighScores h = new HighScores();
        for(Object s : h.getScores()){
            writeScores(s.toString());
        }
        readScores();
        inputFile.close();
        oStream.close();
    }
    public void readScores(){
        while(inputFile.hasNext()){
        
        }
    }
    public void writeScores(String input) throws IOException{
       oStream.println(input);
       oStream.flush(); 
    }
}
