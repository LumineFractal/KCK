package menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import static com.googlecode.lanterna.input.KeyType.Enter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
    private double musicVolume;
    
    public Menu(Terminal m, Screen s, TextGraphics t){
        this.terminal = m;
        this.screen = s;
        this.tg = t;
        musicVolume = 0.2;
        scoresM = new Scores();
    }
    
    public double getMusicVolume() {
        return musicVolume;
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
        tg.putString(54, 20, "         OPTIONS           ");
        tg.putString(54, 22, "         QUIT GAME         ");
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
        tg.putString(54, 20, "         OPTIONS           ");
        tg.putString(54, 22, "         QUIT GAME         ");
        screen.refresh();
    }
    
        public void third() throws IOException{
        tg.putString(54, 16, "         NEW GAME          ");
        tg.putString(54, 18, "         SCOREBOARD        ");
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 20, "-->");
        tg.putString(63, 20, "OPTIONS");
        tg.putString(78, 20, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(54, 22, "         QUIT GAME         ");
        screen.refresh();
    }
    
    public void forth() throws IOException{
        tg.putString(54, 16, "         NEW GAME          ");
        tg.putString(54, 18, "         SCOREBOARD        ");
        tg.putString(54, 20, "         OPTIONS           ");
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 22, "-->");
        tg.putString(63, 22, "QUIT GAME");
        tg.putString(78, 22, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        screen.refresh();
    }
    
    public void scoreboard() throws FileNotFoundException, ParseException, IOException, InterruptedException{
        scoresM.readScores();
        
        screen.clear();
        show();
        for(int i = 0; i < scoresM.scores.size(); i++) {
            tg.putString(54, 16+(i*2), (i+1) + "   " +  scoresM.scores.get(i).getName() + "   " +
                    scoresM.scores.get(i).getPoints() + "   " +
                    scoresM.scores.get(i).getTime() + "   " + scoresM.scores.get(i).getDate());
        }
        //tg.putString(5, 16, "PRESS ANY KEY TO GO TO MENU");
        screen.refresh();
        while(true){
            tg.setForegroundColor(TextColor.ANSI.BLACK);
            tg.setBackgroundColor(TextColor.ANSI.YELLOW);
            tg.putString(5, 16, "PRESS ANY KEY TO GO BACK TO MENU");
            screen.refresh();
            tg.setForegroundColor(TextColor.ANSI.DEFAULT);
            tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
            sleep(500);
            tg.putString(5, 16, "PRESS ANY KEY TO GO BACK TO MENU");
            screen.refresh();
            sleep(500);
            //terminal.readInput();
            if((terminal.pollInput())!=null){
                break;
            }
        }
        screen.clear();
        show();
    }

    public void options() throws IOException {
        screen.clear();
        show();
        
        int choiceOptions = 0;
        boolean runO = true;
        int i = 0;
        int ef = 0;
        tg.putString(54, 16, "         SOUND SETTINGS     ");
        tg.putString(62, 34, "Music by Anamanaguchi");
        tg.putString(62, 35, "License CC BY-NC-SA 3.0 US");
        
        while(runO){
            KeyStroke keyOptions = terminal.pollInput();
            
            if(choiceOptions%3 == 0){
                tg.putString(54, 29, "   ");
                for(i = 0; i< Music.getLevel()*20; i+=2){
                    tg.putString(63+i, 18, "\u2588");
                }
                for(int j = i; j<20; j+=2){
                    tg.putString(63+j, 18, "_");
                }

                for(int k = 0; k<i; k++){
                    tg.putString(61+k, 21, " ");
                }
                for(int l = i; l<21; l++){
                    tg.putString(61+l, 21, " ");
                }
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(61+i, 21, "\u25B2");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                for(int k = 0; k<i; k++){
                    tg.putString(61+k, 22, " ");
                }
                for(int l = i; l<21; l++){
                    tg.putString(61+l, 22, " ");
                }
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.YELLOW);
                tg.putString(54, 22, "-->");
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(61+i, 22, "|");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                //1
                for(ef = 0; ef< Effect.getLevel()*20; ef+=2){
                    tg.putString(63+ef, 25, "\u2588");
                }
                for(int j = ef; j<20; j+=2){
                    tg.putString(63+j, 25, "_");
                }

                for(int k = 0; k<ef; k++){
                    tg.putString(61+k, 28, " ");
                }
                for(int l = ef; l<21; l++){
                    tg.putString(61+l, 28, " ");
                }
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(61+ef, 28, "\u25B2");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                for(int k = 0; k<ef; k++){
                    tg.putString(61+k, 29, " ");
                }
                for(int l = ef; l<21; l++){
                    tg.putString(61+l, 29, " ");
                }
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(61+ef, 29, "|");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(40, 22, "MUSIC");
                tg.putString(40, 29, "SOUND EFFECTS");
                
                tg.putString(54, 32, "        BACK TO MENU       ");
                screen.refresh();
            }else if(choiceOptions%3 == 1){
                tg.putString(54, 22, "   ");
                for(ef = 0; ef< Effect.getLevel()*20; ef+=2){
                    tg.putString(63+ef, 25, "\u2588");
                }
                for(int j = ef; j<20; j+=2){
                    tg.putString(63+j, 25, "_");
                }

                for(int k = 0; k<ef; k++){
                    tg.putString(61+k, 28, " ");
                }
                for(int l = ef; l<21; l++){
                    tg.putString(61+l, 28, " ");
                }
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(61+ef, 28, "\u25B2");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                for(int k = 0; k<ef; k++){
                    tg.putString(61+k, 29, " ");
                }
                for(int l = ef; l<21; l++){
                    tg.putString(61+l, 29, " ");
                }
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.YELLOW);
                tg.putString(54, 29, "-->");
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(61+ef, 29, "|");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);

                tg.putString(54, 32, "        BACK TO MENU       ");
                screen.refresh();
            }else{
                tg.putString(54, 22, "   ");
                tg.putString(54, 29, "   ");
                tg.setForegroundColor(TextColor.ANSI.BLACK);
                tg.setBackgroundColor(TextColor.ANSI.YELLOW);
                tg.putString(54, 32, "-->");
                tg.putString(62, 32, "BACK TO MENU");
                tg.putString(78, 32, "<--");
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                screen.refresh();
            }
            if(keyOptions != null){
                if(choiceOptions==2 && keyOptions.getKeyType()==Enter){
                    runO=false;
                }
                else{
                    if(choiceOptions == 0){
                        switch(keyOptions.getKeyType()){
                        case ArrowLeft:
                            if(i>0){
                                i-=2;
                                Music.setLevel(i/20.00);
                                musicVolume = i/20.00;
                            }
                            break;
                        case ArrowRight:
                           if(i<20){
                                i+=2;
                                Music.setLevel(i/20.00);
                                musicVolume = i/20.00;
                            }
                            break;
                        case ArrowDown:
                            if(choiceOptions==0 || choiceOptions==1)
                                choiceOptions++;
                            else{
                                choiceOptions=0;
                            }
                            break;
                        case ArrowUp:
                            if(choiceOptions==1 || choiceOptions==2)
                                choiceOptions--;
                            else{
                                choiceOptions=2;
                            }
                            break;
                        case Escape:
                            runO=false;
                            break;
                        default:
                            break;
                        }
                    }
                    else if(choiceOptions == 1){
                        switch(keyOptions.getKeyType()){
                        case ArrowLeft:
                            if(ef>0){     
                                Effect.playEffect(2);
                                ef-=2;
                                Effect.setLevel(ef/20.00);
                            }
                            break;
                        case ArrowRight:
                           if(ef<20){ 
                                Effect.playEffect(2);
                                ef+=2;
                                Effect.setLevel(ef/20.00);
                            }
                            break;
                        case ArrowDown:
                            if(choiceOptions==0 || choiceOptions==1)
                                choiceOptions++;
                            else{
                                choiceOptions=0;
                            }
                            break;
                        case ArrowUp:
                            if(choiceOptions==1 || choiceOptions==2)
                                choiceOptions--;
                            else{
                                choiceOptions=2;
                            }
                            break;
                        case Escape:
                            runO=false;
                            break;
                        default:
                            break;
                        }
                    }
                    else{
                        switch(keyOptions.getKeyType()){
                        case ArrowDown:
                            if(choiceOptions==0 || choiceOptions==1)
                                choiceOptions++;
                            else{
                                choiceOptions=0;
                            }
                            break;
                        case ArrowUp:
                            if(choiceOptions==1 || choiceOptions==2)
                                choiceOptions--;
                            else{
                                choiceOptions=2;
                            }
                            break;
                        case Escape:
                            runO=false;
                            break;
                        } 
                    }
                }
            }
        }    
            
        screen.clear();
        show();
    }

    public void firstDiff() throws IOException{
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 16, "-->");
        tg.putString(63, 16, "EASY");
        tg.putString(78, 16, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(54, 18, "         NORMAL            ");
        tg.putString(54, 20, "         HARD              ");
        screen.refresh();
    }
    
    public void secondDiff() throws IOException{
        tg.putString(54, 16, "         EASY              ");
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 18, "-->");
        tg.putString(63, 18, "NORMAL");
        tg.putString(78, 18, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(54, 20, "         HARD              ");
        screen.refresh();
    }
    
        public void thirdDiff() throws IOException{
        tg.putString(54, 16, "         EASY              ");
        tg.putString(54, 18, "         NORMAL            ");
        tg.setForegroundColor(TextColor.ANSI.BLACK);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(54, 20, "-->");
        tg.putString(63, 20, "HARD");
        tg.putString(78, 20, "<--");
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        screen.refresh();
    }
    
    public void difficulty() throws IOException, InterruptedException, FileNotFoundException, ParseException {
        screen.clear();
        show();
        
        boolean runD = true;
        int choiceD = 0;
        Game game;
        
        while(runD){
            KeyStroke keyPressedD = terminal.pollInput();
            
            switch (choiceD) {
                case 0:
                    firstDiff();
                    break;
                case 1:
                    secondDiff();
                    break;
                default:
                    thirdDiff();
                    break;
            }
        
        
            if(choiceD>3000)
                choiceD-=2700;
            
            if(keyPressedD != null){
                System.out.println(keyPressedD);
                switch(keyPressedD.getKeyType()){
                    case Escape:
                        runD = false;
                        break;
                    case ArrowDown:
                        choiceD = (choiceD + 1) % 3;
                        break;
                    case ArrowUp:
                        choiceD = (choiceD + 2) % 3;
                        break;
                    case Enter:
                        switch (choiceD%3) {
                            case 0:
                                game = new Game(terminal, screen, tg, this.scoresM, 100);
                                game.init();
                                Music.stop();
                                Music.playMenu(2);
                                Music.setLevel(getMusicVolume());
                                game.run();
                                Music.playMenu(1);
                                Music.setLevel(getMusicVolume());
                                show();
                                break;
                            case 1:
                                game = new Game(terminal, screen, tg, this.scoresM, 70);
                                game.init();
                                Music.stop();
                                Music.playMenu(2);
                                Music.setLevel(getMusicVolume());
                                game.run();
                                Music.playMenu(1);
                                Music.setLevel(getMusicVolume());
                                show();
                                break;
                            case 2:
                                game = new Game(terminal, screen, tg, this.scoresM, 40);
                                game.init();
                                Music.stop();
                                Music.playMenu(2);
                                Music.setLevel(getMusicVolume());
                                game.run();
                                Music.playMenu(1);
                                Music.setLevel(getMusicVolume());
                                show();
                                break;
                        }
                        runD=false;
                        break;
                }
            }
        }
    }
}
