package menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import static com.googlecode.lanterna.input.KeyType.Enter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Kaveri
 */
public class Main {
    
    public static void menu() throws IOException, InterruptedException, FileNotFoundException, ParseException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        TextGraphics tg = screen.newTextGraphics();
        screen.startScreen();
        
        //Bezpieczne wymiary na moim lapku: 170/50(1366px/768px)
        tg.putString(24, 10, "MAKE THIS WINDOW BIGGER");
        tg.putString(24, 11, "USING RIGHT DOWN CORNER");
        tg.putString(24, 12, "AND THEN PRESS ANY KEY");
        screen.refresh();
        terminal.readInput();//czeka na klawisz
        screen.doResizeIfNecessary();
        screen.clear();
        screen.refresh();                 
        
        Menu menu1 = new Menu(terminal, screen, tg);
        menu1.show();
        Music.playMenu(1);
        Music.setLevel(0.2);
        Effect.playEffect(3);
        Effect.setLevel(0.2);
        menu1.first();  
        int choice = 0;
        
        boolean running = true;
        
        screen.doResizeIfNecessary();
        while(running){
            screen.doResizeIfNecessary();
            KeyStroke keyPressed = terminal.pollInput();
            
            switch (choice) {
                case 0:
                    menu1.first();
                    break;
                case 1:
                    menu1.second();
                    break;
                case 2:
                    menu1.third();
                    break;
                default:
                    menu1.forth();
                    break;
            }
                    
            if(choice>3000)
                    choice-=2800;
            
            if(keyPressed != null){
                System.out.println(keyPressed);
                switch(keyPressed.getKeyType()){
                    case Escape:
                        running = false;
                        break;
                    case ArrowDown:
                        choice = (choice + 1) % 4;
                        break;
                    case ArrowUp:
                        choice = (choice + 3) % 4;
                        break;
                    case Enter:
                        switch (choice%4) {
                            case 0:
                                menu1.difficulty();
                                break;
                            case 1:
                                menu1.scoreboard();
                                break;
                            case 2:
                                menu1.options();
                                break;
                            default:
                                running = false;
                                break;
                        }
                        break;
                }
            }
        }
        screen.stopScreen();
    }
     
    public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException, ParseException {
        menu();
    }
}
