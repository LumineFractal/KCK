package menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

/**
 *
 * @author Kaveri
 */
public class Game {
    private int points;
    private int combo;
    private int hp;
    Terminal terminal;
    Screen screen;
    TextGraphics tg;
    boolean gamerun;
    private int position;
    private static final String znak1 = String.valueOf((char)926) + String.valueOf((char)926) + String.valueOf((char)926);
    
    public Game(Terminal m, Screen s, TextGraphics t){
        points=0;
        combo=0;
        hp=20;
        position=3;
        this.terminal = m;
        this.screen = s;
        this.tg = t;
        this.gamerun = true;
    }
    
    public void init() throws IOException{
        screen.clear();
        tg.putString(4, 1, "HP: ");
        for(int j= 8; j < 8 + hp; j++){
            tg.putString(j, 1, String.valueOf((char)847));
            //tg.putString(j, 1, String.valueOf((char)926));
        }
        tg.putString(4, 3, "Points: " + points);
        tg.putString(4, 5, "Combo: " + combo + "x");
        for(int i = 1; i < 40; i++){
            tg.putString(40, i, "   ###               ###   ");
            
            //test znakow
            /*
            tg.putString(30, i, String.valueOf((char)(150+i)));
            tg.putString(31, i, String.valueOf((char)(190+i)));
            tg.putString(32, i, String.valueOf((char)(230+i)));
            tg.putString(33, i, String.valueOf((char)(270+i)));
            tg.putString(34, i, String.valueOf((char)(310+i)));
            tg.putString(35, i, String.valueOf((char)(350+i)));
            tg.putString(36, i, String.valueOf((char)(390+i)));
            tg.putString(37, i, String.valueOf((char)(430+i)));
            tg.putString(38, i, String.valueOf((char)(470+i)));
            tg.putString(70, i, String.valueOf((char)(510+i)));
            tg.putString(71, i, String.valueOf((char)(550+i)));
            tg.putString(72, i, String.valueOf((char)(590+i)));
            tg.putString(73, i, String.valueOf((char)(630+i)));
            tg.putString(74, i, String.valueOf((char)(670+i)));
            tg.putString(75, i, String.valueOf((char)(710+i)));
            tg.putString(76, i, String.valueOf((char)(750+i)));
            tg.putString(77, i, String.valueOf((char)(790+i)));
            tg.putString(78, i, String.valueOf((char)(830+i)));
            tg.putString(79, i, String.valueOf((char)(870+i)));
            tg.putString(80, i, String.valueOf((char)(910+i)));
            tg.putString(81, i, String.valueOf((char)(950+i)));
            tg.putString(82, i, String.valueOf((char)(990+i)));
            tg.putString(83, i, String.valueOf((char)(1030+i)));
            tg.putString(84, i, String.valueOf((char)(1070+i)));
            tg.putString(85, i, String.valueOf((char)(1110+i)));
            tg.putString(86, i, String.valueOf((char)(1150+i)));
            tg.putString(87, i, String.valueOf((char)(1190+i)));
            tg.putString(88, i, String.valueOf((char)(1230+i)));
            tg.putString(89, i, String.valueOf((char)(1270+i)));
            tg.putString(90, i, String.valueOf((char)(1310+i)));
            tg.putString(91, i, String.valueOf((char)(1350+i)));
            tg.putString(92, i, String.valueOf((char)(1390+i)));
            tg.putString(93, i, String.valueOf((char)(1430+i)));
            tg.putString(94, i, String.valueOf((char)(1470+i)));
            tg.putString(95, i, String.valueOf((char)(1510+i)));
            tg.putString(96, i, String.valueOf((char)(1550+i)));
            tg.putString(97, i, String.valueOf((char)(1590+i)));
            tg.putString(98, i, String.valueOf((char)(1630+i)));
            tg.putString(99, i, String.valueOf((char)(1670+i)));
            tg.putString(100, i, String.valueOf((char)(1710+i)));
            tg.putString(101, i, String.valueOf((char)(1750+i)));
            tg.putString(102, i, String.valueOf((char)(1790+i)));
            tg.putString(103, i, String.valueOf((char)(1830+i)));
            tg.putString(104, i, String.valueOf((char)(1870+i)));
            */
        }
        showPosition();
    }
    
    public void run() throws IOException{
        while(gamerun){
            screen.doResizeIfNecessary();
            KeyStroke keyPressed = terminal.pollInput();
            
            if(keyPressed != null){
                System.out.println(keyPressed);
                switch(keyPressed.getKeyType()){
                    case Escape:
                        gamerun = false;
                        break;
                    case ArrowLeft:
                        if(position>1){
                            position-=1;
                        }
                        showPosition();
                        break;
                    case ArrowRight:
                        if(position<5){
                            position+=1;
                        }
                        showPosition();
                        break;
                }
            }
        }
        screen.clear();
    }
    
    public void showPosition() throws IOException{
        switch(position){
            case 1:
                tg.putString(40, 40, "   ###" + znak1 + "            ###   ");
                tg.putString(40, 41, "   ###" + znak1 + "            ###   ");
                break;
            case 2:
                tg.putString(40, 40, "   ###   " + znak1 + "         ###   ");
                tg.putString(40, 41, "   ###   " + znak1 + "         ###   ");
                break;
            case 3:
                tg.putString(40, 40, "   ###      " + znak1 + "      ###   ");
                tg.putString(40, 41, "   ###      " + znak1 + "      ###   ");
                break;
            case 4:
                tg.putString(40, 40, "   ###         " + znak1 + "   ###   ");
                tg.putString(40, 41, "   ###         " + znak1 + "   ###   ");
                break;
            case 5:
                tg.putString(40, 40, "   ###            " + znak1 + "###   ");
                tg.putString(40, 41, "   ###            " + znak1 + "###   ");
                break;
        }
        screen.refresh();
    }
}
