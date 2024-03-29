package menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Kaveri
 */
public class Scores {
    File file;
    Scanner skaner;
    ArrayList<Score> scores = new ArrayList();
    
    public void readScores() throws FileNotFoundException, ParseException{
        if(file==null){
            file = new File("scoreboard.txt"); 
        }
        if(skaner==null){
            skaner = new Scanner(file);
        } 
        while(skaner.hasNextLine()){
            Score tmp = new Score();
            tmp.setName(skaner.next());
            tmp.setPoints(skaner.nextInt());
            tmp.setDate(skaner.next());
            tmp.setTime(skaner.next());
            scores.add(tmp);
            System.out.println(tmp.getName());
            System.out.println(tmp.getPoints());
            System.out.println(tmp.getDate());
            System.out.println(tmp.getTime());
        }
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score p1, Score p2) {
                return p2.getPoints() - p1.getPoints();
            }
        });
    }
    
     public void saveScores() throws FileNotFoundException, ParseException{
        PrintWriter zapis = new PrintWriter("scoreboard.txt");
        int size = scores.size();
        for(int i=0; i<size; i++){
            if(i==size-1){
                zapis.print(scores.get(i).toString());
            }else
                zapis.println(scores.get(i).toString());
        }
        zapis.close();
        
    }
}
