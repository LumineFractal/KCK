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
        menu1.first();  
        int choice = 0;
        
        boolean running = true;
        StringBuilder sb = new StringBuilder();
        Game game;
        
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
                default:
                    menu1.third();
                    break;
            }
                    
            if(choice>3000)
                    choice-=2700;
            
            if(keyPressed != null){
                System.out.println(keyPressed);
                switch(keyPressed.getKeyType()){
                    case Escape:
                        running = false;
                        break;
                    case ArrowDown:
                        choice = (choice + 1) % 3;
                        break;
                    case ArrowUp:
                        choice = (choice + 2) % 3;
                        break;
                    case Enter:
                        switch (choice%3) {
                            case 0:
                                game = new Game(terminal, screen, tg);
                                game.init();
                                game.run();
                                menu1.show();
                                break;
                            case 1:
                                menu1.scoreboard();
                                break;
                            default:
                                running = false;
                                break;
                        }
                        break;
                                      
                    //przykladowny kod z neta
                    /*case ArrowDown:
                        tg.setForegroundColor(TextColor.ANSI.BLUE);
                        tg.setBackgroundColor(TextColor.ANSI.GREEN);
                        tg.putString(1, 1, "Size: " + screen.getTerminalSize().getColumns() + " x " + screen.getTerminalSize().getRows());
                        screen.refresh();
                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                    case Character:
                        sb.append(keyPressed.getCharacter());
                        System.out.println(keyPressed.getCharacter());
                        break;
                    case Enter:
                        screen.clear();
                        tg.putString(10, 10, sb.toString(), SGR.BOLD);
                        screen.refresh();
                        sb = new StringBuilder();
                        break;
                    case ArrowLeft:
                        int row = 5, col = 60;
                        for(SGR sgr : SGR.values()){
                            tg.putString(col,row++, sgr.name(), sgr);
                            System.out.println(sgr.name());
                            screen.refresh();
                        }
                        break;
                    case ArrowUp:
                        tg.setForegroundColor(TextColor.ANSI.MAGENTA);
                        for(int i=20; i<40; i++){
                            tg.putString(i, 20, String.valueOf(Symbols.BLOCK_SOLID));
                            //Thread.sleep(100);
                            screen.refresh();
                        }
                        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                        
                        
                    */         
                }
            }
        }
        
        /*Thread.currentThread();
        while(screen.readInput()==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        screen.stopScreen();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException, ParseException {
        menu();
    }
}
