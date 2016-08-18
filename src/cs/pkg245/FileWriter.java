/**
 * *************************************************************
 * file: FileWriter.java
 * author: Vincent Thai && Luis Lopez
 * class: CS 245 – Programming Graphical User Interfaces
 *
 * assignment: program 1
 * date last modified: 8/17/2016
 *
 * purpose: Handles all the read and write from highscores.txt in order to store
 *          the updated scores on the highscores screen.
 *
 ***************************************************************
 */
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
    boolean isModify;
    ArrayList<String> list = new ArrayList<String>(5);

    public static void main(String[] args) throws IOException {
        FileWriter n = new FileWriter("highscores.txt", false);

    }

    public FileWriter(String fileName, boolean isModify) throws FileNotFoundException, IOException {
        index = 0;
        this.isModify = isModify;
        inputFile = new Scanner(new File(fileName));
        names = new String[5];
        scores = new String[5];
        readScores();
        inputFile.close();
    }

    /**
     * @author Vincent method : updateScores purpose: reads scores from .txt
     * file, stores the newest scores at the index of the lowest item in the
     * array representing the lowest of all highscores. It then sorts the array
     * and re-adds it to the .txt file.
     */
    public void updateScores(int num, String name) throws IOException {
        FileClearer f = new FileClearer();
        oStream = new PrintWriter("highscores.txt");
        scores[4] = num + "";
        names[4] = name;
        System.out.println(scores[0] + "...." + names[0]);
        sortArrays();
        list.clear();
        for (int i = 0; i < scores.length; i++) {
            list.add(names[i] + "...." + scores[i]);
        }
        for (Object j : list) {
            writeScores(j.toString());
            System.out.println(j.toString());
        }
        oStream.close();
    }

    /**
     * @author Vincent method : getLowest purpose: returns lowest of all high
     * scores
     */
    public int getLowest() {
        int smallest = 0;
        for (String i : scores) {
            if (Integer.parseInt(i) <= smallest) {
                smallest = Integer.parseInt(i);
            }
        }
        //System.out.println("Smallest : " + smallest);
        return smallest;
    }

    /**
     *
     * method : readScores purpose: Reads scores from file and adds them to
     * arraylist along with sorting and parsing each string.
     */
    public void readScores() {
        String temp = "";
        int i = 0;
        while (inputFile.hasNextLine()) {
            temp = (inputFile.nextLine());
            parseString(temp);
            // System.out.println(i++ + "\t" + temp);
        }
    }

    /**
     *
     * method : sortArrays purpose: Sorts using selection sort.
     */
    public void sortArrays() {
        int largest = Integer.parseInt(scores[0]), index = 0, tempNum = 0;
        String temp = "";

        for (int i = 0; i < names.length; i++) {
            index = i;
            largest = Integer.parseInt(scores[i]);
            for (int j = i; j < names.length; j++) {
                if (Integer.parseInt(scores[j]) > largest) {
                    largest = Integer.parseInt(scores[j]);
                    index = j;
                    //System.out.println("Largest : " + largest + "index = " + index);
                }
            }
            //System.out.println("swapping");
            temp = names[i];
            names[i] = names[index];
            names[index] = temp;
            tempNum = Integer.parseInt(scores[i]);
            scores[i] = scores[index];
            scores[index] = tempNum + "";

        }
    }

    /**
     *
     * method : printArrays purpose: Adds arrays to a arraylist to send to the
     * hgihscores class.
     */
    public void printArray() {
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "...." + scores[i]);
        }
        System.out.println(list);
    }

    /**
     *
     * method : parseString purpose: Parses string from text file.
     */
    public void parseString(String temp) {
        int i = 0;
        System.out.println(temp);
        for (char c : temp.toCharArray()) {
            if (c == '.') {
                if (index > 4) {
                    index = 4;
                }
                names[index] = temp.substring(0, i);
                scores[index] = temp.substring(i + 4, temp.length());
                list.add(names[index] + "...." + scores[index]);
                System.out.println(names[index] + "...." + scores[index]);
                index++;
                break;
            }
            i++;
        }
    }

    public void writeScores(String input) throws IOException {
        oStream.println(input);
        oStream.flush();
    }
}

class FileClearer {

    FileClearer() throws FileNotFoundException {

        PrintWriter oStream = new PrintWriter("highscores.txt");
        oStream.close();
    }
}
