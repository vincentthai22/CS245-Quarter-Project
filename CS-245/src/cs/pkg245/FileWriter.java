/*
 * Vincent Thai 
 * 
 * 
 */
package cs.pkg245;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Vincent
 */
public class FileWriter {
    Scanner inputFile;
    PrintWriter oStream;
    int[] Scores;
    String[] names;
    String[] scores;
    int index;
    ArrayList<String> list = new ArrayList<String>(5);
    public static void main(String[] args) throws IOException{
        FileWriter n = new FileWriter("highscores.txt");
        
    }
    public FileWriter(String fileName) throws FileNotFoundException, IOException{
        index = 0;
       // oStream = new PrintWriter(fileName);
        inputFile = new Scanner(new File(fileName));
        names = new String[5];
        scores = new String[5];
//        HighScores h = new HighScores();
//        for(Object j : h.getScores())
//            writeScores(j.toString());
//        
          //  System.out.println("yes");
        readScores();
        inputFile.close();
    }
    public void updateScores(int num, String name) throws IOException{
        FileClearer f = new FileClearer();
        oStream = new PrintWriter("highscores.txt");
        scores[0] = num + "";
        names[0] = name;
        sortArrays();
        printArray();
        for(Object j : list){
            writeScores(j.toString());
            System.out.println(j.toString());
        }
        oStream.close();
    }
    public int getHighest(){
        int largest = 0;
        for(String i : scores)
            if (Integer.parseInt(i) < largest)
                largest = Integer.parseInt(i);
        return largest;
    }
    public void readScores(){
        int i = 0;
        String temp = "";
        while(inputFile.hasNextLine()){
              temp = (inputFile.nextLine());
            parseString(temp);
        }
       //printArray();
        sortArrays();
        printArray();
    }
    public void sortArrays(){
        int largest = Integer.parseInt(scores[0]),index = 0, tempNum = 0;
        String temp = "";
       
        for(int i = 0 ; i < names.length; i++){
            index = i;
            largest = 0;
            for(int j = 0; j < names.length; j++){
                if(Integer.parseInt(scores[j]) > largest){
                    largest = Integer.parseInt(scores[j]);
                    index = j;
                }    
            }
            temp = names[i];
            names[i] = names[index];
            names[index] = temp;
            tempNum = Integer.parseInt(scores[i]);
            scores[i] = scores[index];
            scores[index] = tempNum + "";
            
            
        }
    }
    public void printArray(){
        for(int i = 0 ; i < names.length ; i++){
            System.out.println(names[i] + "...." + scores[i]);
            list.add(names[i] + "...." + scores[i]);
        }
    }
    public void parseString(String temp){
        int i = 0;
        for(char c : temp.toCharArray()){
            if (c == '.'){
                if(index > 4)
                    index = 4;
                names[index] = temp.substring(0,i);
                scores[index] = temp.substring(i+4, temp.length());
                index++;
                break;
            }
            i++;
        }
    }
    public void writeScores(String input) throws IOException{
       oStream.println(input);
       oStream.flush(); 
    }
}
class FileClearer{
    FileClearer() throws FileNotFoundException{
        
       PrintWriter oStream = new PrintWriter("highscores.txt");
       oStream.close();
    }
}