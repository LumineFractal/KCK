package menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import static com.googlecode.lanterna.input.KeyType.Enter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

/**
 *
 * @author Kaveri
 */
public class Main {
    
    public static void menu() throws IOException, InterruptedException {
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

        boolean running = true;
        StringBuilder sb = new StringBuilder();
        
        screen.doResizeIfNecessary();
        while(running){
            screen.doResizeIfNecessary();
            KeyStroke keyPressed = terminal.pollInput();
            
            if(keyPressed != null){
                System.out.println(keyPressed);
                switch(keyPressed.getKeyType()){
                    case Escape:
                        running = false;
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
    
    public static void main(String[] args) throws IOException, InterruptedException {
        menu();
    }
}
