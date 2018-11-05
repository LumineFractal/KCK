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
    boolean[] me;
    private int position;
    private static final String znak1 = String.valueOf((char) 926) + String.valueOf((char) 926) + String.valueOf((char) 926);
    private static final String znak2 = String.valueOf((char) 178) + String.valueOf((char) 178) + String.valueOf((char) 178);
    Block blok;
    ArrayList<Block> bloki;
    private int counter;

    public Game(Terminal m, Screen s, TextGraphics t) {
        points = 0;
        combo = 0;
        hp = 20;
        position = 3;
        counter = 0;
        this.terminal = m;
        this.screen = s;
        this.tg = t;
        this.gamerun = true;
        bloki = new ArrayList();
    }

    public void init() throws IOException {
        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.RED);
        tg.putString(4, 1, "HP: ");
        for (int j = 8; j < 8 + hp; j++) {
            tg.putString(j, 1, String.valueOf((char) 847));
        }
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(4, 3, "Points: " + points);
        tg.putString(4, 5, "Combo: " + combo + "x");
        for (int i = 1; i < 40; i++) {
            tg.setBackgroundColor(TextColor.ANSI.BLUE);
            tg.setForegroundColor(TextColor.ANSI.GREEN);
            tg.putString(43, i, "###               ###");
            tg.putString(61, i, "###");
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(46, i, "               ");
        }
        showPosition(znak1);
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
                            showPosition(znak1);
                            break;
                        case ArrowRight:
                            if (position < 5) {
                                position += 1;
                            }
                            showPosition(znak1);
                            break;
                    }
                }
            }

            // sleep(70);
            if (counter < 20) {
                blok = new Block(terminal, screen, tg);
                bloki.add(blok);
                counter++;
            }
            blocksMove();
        }
        screen.clear();
    }

    public void blocksMove() throws IOException, InterruptedException {
        for (Block blok1 : bloki) {
            blok1.show();
            if (blok1.place == 38) {
                checkCollisions();
            }
        }
    }

    public void showPosition(String znak) throws IOException {
        me = new boolean[5];
        tg.setBackgroundColor(TextColor.ANSI.BLUE);
        tg.setForegroundColor(TextColor.ANSI.GREEN);
        tg.putString(43, 40, "###");
        tg.putString(43, 41, "###");
        tg.putString(61, 40, "###");
        tg.putString(61, 41, "###");
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.setForegroundColor(TextColor.ANSI.RED);
        switch (position) {
            case 1:
                me[0] = true;
                me[1] = false;
                me[2] = false;
                me[3] = false;
                me[4] = false;
                break;
            case 2:
                me[0] = false;
                me[1] = true;
                me[2] = false;
                me[3] = false;
                me[4] = false;
                break;
            case 3:
                me[0] = false;
                me[1] = false;
                me[2] = true;
                me[3] = false;
                me[4] = false;
                break;
            case 4:
                me[0] = false;
                me[1] = false;
                me[2] = false;
                me[3] = true;
                me[4] = false;
                break;
            case 5:
                me[0] = false;
                me[1] = false;
                me[2] = false;
                me[3] = false;
                me[4] = true;
                break;
        }
        for (int i = 0; i < 5; i++) {
            if (me[i] == true) {
                tg.setForegroundColor(TextColor.ANSI.RED);
                tg.putString(46 + (i * 3), 40, znak);
                tg.putString(46 + (i * 3), 40 + 1, znak);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            } else {
                tg.putString(46 + (i * 3), 40, "   ");
                tg.putString(46 + (i * 3), 40 + 1, "   ");
            }
        }
        screen.refresh();
    }

    private void checkCollisions() throws IOException, InterruptedException {
        if (Block.falsefull[position - 1] == true) {
            combo = 0;
            hp -= 2;
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.putString(4, 1, "HP: ");
            for (int j = 8; j < 8 + hp; j++) {
                tg.putString(j, 1, String.valueOf((char) 847));
            }
            for (int k = 8 + hp; k < 28; k++) {
                tg.putString(k, 1, " ");
            }
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.putString(68, 40, "Kolizja na pozycji " + position);

            // screen.refresh();
            showPosition(znak2);
            sleep(200);
            showPosition(znak1);
        }
        combo++;
        points = points + combo;
        if (combo % 100 == 0 && combo > 0) {
            if (hp < 20) {
                hp += 2;
            }
            tg.setForegroundColor(TextColor.ANSI.RED);
            tg.putString(4, 1, "HP: ");
            for (int j = 8; j < 8 + hp; j++) {
                tg.putString(j, 1, String.valueOf((char) 847));
            }
            for (int k = 8 + hp; k < 28; k++) {
                tg.putString(k, 1, " ");
            }
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        }
        tg.putString(4, 3, "Points: " + points);
        tg.putString(4, 5, "Combo: " + combo + "x   ");
    }
}
