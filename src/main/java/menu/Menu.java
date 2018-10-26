package menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Kaveri
 */
public class Menu {
    Terminal terminal;
    Screen screen;
    TextGraphics tg;
    Scores scoresM;
    
    public Menu(Terminal m, Screen s, TextGraphics t){
        this.terminal = m;
        this.screen = s;
        this.tg = t;
        scoresM = new Scores();
    }
    
    public void show() throws IOException{
        tg.putString(30, 1, "██████╗ ███████╗ █████╗ ████████╗██╗  ██╗    ██████╗  ██████╗  █████╗ ██████╗ ");
        tg.putString(30, 2, "██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██║  ██║    ██╔══██╗██╔═══██╗██╔══██╗██╔══██╗");
        tg.putString(30, 3, "██║  ██║█████╗  ███████║   ██║   ███████║    ██████╔╝██║   ██║███████║██║  ██║");
        tg.putString(30, 4, "██║  ██║██╔══╝  ██╔══██║   ██║   ██╔══██║    ██╔══██╗██║   ██║██╔══██║██║  ██║");
        tg.putString(30, 5, "██████╔╝███████╗██║  ██║   ██║   ██║  ██║    ██║  ██║╚██████╔╝██║  ██║██████╔╝");
        tg.putString(30, 6, "╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝    ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═════╝ ");
        tg.putString(30, 7, "████████╗ ██████╗     ██████╗  ██████╗ ██╗      █████╗ ███╗   ██╗██████╗      ");
        tg.putString(30, 8, "╚══██╔══╝██╔═══██╗    ██╔══██╗██╔═══██╗██║     ██╔══██╗████╗  ██║██╔══██╗     ");
        tg.putString(30, 9, "   ██║   ██║   ██║    ██████╔╝██║   ██║██║     ███████║██╔██╗ ██║██║  ██║     ");
        tg.putString(30, 10, "   ██║   ██║   ██║    ██╔═══╝ ██║   ██║██║     ██╔══██║██║╚██╗██║██║  ██║     ");
        tg.putString(30, 11, "   ██║   ╚██████╔╝    ██║     ╚██████╔╝███████╗██║  ██║██║ ╚████║██████╔╝     ");
        tg.putString(30, 12, "   ╚═╝    ╚═════╝     ╚═╝      ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝      ");
        
        screen.refresh();
    }
    
    public void first() throws IOException{
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 16, "-->");
        tg.putString(63, 16, "NEW GAME");
        tg.putString(78, 16, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(54, 18, "         SCOREBOARD        ");
        tg.putString(54, 20, "         QUIT GAME         ");
        screen.refresh();
    }
    
    public void second() throws IOException{
        tg.putString(54, 16, "         NEW GAME          ");
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 18, "-->");
        tg.putString(63, 18, "SCOREBOARD");
        tg.putString(78, 18, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(54, 20, "         QUIT GAME         ");
        screen.refresh();
    }
    
    public void third() throws IOException{
        tg.putString(54, 16, "         NEW GAME          ");
        tg.putString(54, 18, "         SCOREBOARD        ");
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 20, "-->");
        tg.putString(63, 20, "QUIT GAME");
        tg.putString(78, 20, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        screen.refresh();
    }
    
    public void scoreboard() throws FileNotFoundException, ParseException, IOException{
        scoresM.readScores();
        
        screen.clear();
        show();
        for(int i = 0; i < scoresM.scores.size(); i++) {
            tg.putString(54, 16+(i*2), (i+1) + "   " +  scoresM.scores.get(i).getName() + "   " +
                    scoresM.scores.get(i).getPoints() + "   " +
                    scoresM.scores.get(i).getTime() + "   " + scoresM.scores.get(i).getDate());
        }
        tg.putString(5, 16, "PRESS ANY KEY TO GO TO MENU");
        screen.refresh();
        terminal.readInput();
        screen.clear();
        show();
    }
}
