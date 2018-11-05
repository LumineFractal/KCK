package menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

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
    Block blok;
    ArrayList<Block> bloki;
    private int counter;
    
    public Game(Terminal m, Screen s, TextGraphics t){
        points=0;
        combo=0;
        hp=20;
        position=3;
        counter=0;
        this.terminal = m;
        this.screen = s;
        this.tg = t;
        this.gamerun = true;
        bloki = new ArrayList();
    }
    
    public void init() throws IOException{
        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(4, 1, "HP: ");
        for(int j= 8; j < 8 + hp; j++){
            tg.putString(j, 1, String.valueOf((char)847));
        }
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(4, 3, "Points: " + points);
        tg.putString(4, 5, "Combo: " + combo + "x");
        for(int i = 1; i < 40; i++){
            tg.setBackgroundColor(TextColor.ANSI.BLUE);
            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.putString(43, i, "###               ###");
            tg.putString(61, i, "###");
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(46, i, "               ");
        }
        showPosition();
    }
    
    public void run() throws IOException, InterruptedException {
        while (gamerun) {
            screen.doResizeIfNecessary();

            int time = 50;
            for (int i = 0; i < time; i++) {
                sleep(1);
                KeyStroke keyPressed = terminal.pollInput();

                if (keyPressed != null) {
                    System.out.println(keyPressed);
                    switch (keyPressed.getKeyType()) {
                        case Escape:
                            gamerun = false;
                            break;
                        case ArrowLeft:
                            if (position > 1) {
                                position -= 1;
                            }
                            showPosition();
                            break;
                        case ArrowRight:
                            if (position < 5) {
                                position += 1;
                            }
                            showPosition();
                            break;
                    }
                }
            }
            
           // sleep(70);
            if(counter<20){
                blok = new Block(terminal, screen, tg);
                bloki.add(blok);
                counter++;
            }
            blocksMove();
        }
        screen.clear();
    }
    
    public void blocksMove() throws IOException{
        for (Block blok1 : bloki) {
            blok1.show();
            if(blok1.place==38){
                checkCollisions();
            }
        }
    }
    
    public void showPosition() throws IOException{
        tg.setBackgroundColor(TextColor.ANSI.BLUE);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.putString(43, 40, "###");
        tg.putString(43, 41, "###");
        tg.putString(61, 40, "###");
        tg.putString(61, 41, "###");
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.RED);
        switch(position){
            case 1:
                tg.putString(46, 40, znak1);
                tg.putString(46, 41, znak1);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(49, 40, "            ");
                tg.putString(49, 41, "            ");
                break;
            case 2:
                tg.putString(46, 40, "   ");
                tg.putString(46, 41, "   ");
                tg.setForegroundColor(TextColor.ANSI.RED);
                tg.putString(49, 40, znak1);
                tg.putString(49, 41, znak1);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(52, 40, "         ");
                tg.putString(52, 41, "         ");
                break;
            case 3:
                tg.putString(46, 40, "      ");
                tg.putString(46, 41, "      ");
                tg.setForegroundColor(TextColor.ANSI.RED);
                tg.putString(52, 40, znak1);
                tg.putString(52, 41, znak1);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(55, 40, "      ");
                tg.putString(55, 41, "      ");
                break;
            case 4:
                tg.putString(46, 40, "         ");
                tg.putString(46, 41, "         ");
                tg.setForegroundColor(TextColor.ANSI.RED);
                tg.putString(55, 40, znak1);
                tg.putString(55, 41, znak1);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(58, 40, "   ");
                tg.putString(58, 41, "   ");
                break;
            case 5:
                tg.putString(46, 40, "            ");
                tg.putString(46, 41, "            ");
                tg.setForegroundColor(TextColor.ANSI.RED);
                tg.putString(58, 40, znak1);
                tg.putString(58, 41, znak1);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                break;
        }
        screen.refresh();
    }

    private void checkCollisions() throws IOException {
        if(Block.falsefull[position-1]==true){
            combo=0;
            hp-=2;
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.putString(4, 1, "HP: ");
            for(int j= 8; j < 8 + hp; j++){
                tg.putString(j, 1, String.valueOf((char)847));
            }
            for(int k = 8 + hp; k < 28; k++){
                tg.putString(k, 1, " ");
            }
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(68, 40, "Kolizja na pozycji " + position);
            screen.refresh();
        }
        combo++;
        points=points+combo;
        if(combo%100==0 && combo>0){
            if(hp<20){
                hp+=2;
            }
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.putString(4, 1, "HP: ");
            for(int j= 8; j < 8 + hp; j++){
                tg.putString(j, 1, String.valueOf((char)847));
            }
            for(int k = 8 + hp; k < 28; k++){
                tg.putString(k, 1, " ");
            }
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        }
        tg.putString(4, 3, "Points: " + points);
        tg.putString(4, 5, "Combo: " + combo + "x   ");
    }
}
