/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Kaveri
 */
public class Block {
    int type;
    int place;
    Terminal terminal;
    Screen screen;
    TextGraphics tg;
    Random rand = new Random();
    static int empty = 0;
    
    public Block(Terminal m, Screen s, TextGraphics t){
        if(empty==0){
            type = rand.nextInt(8) +1;
            empty++;
        }else{
            type=9;
            empty=0;
        }
        place = -2;
        this.terminal = m;
        this.screen = s;
        this.tg = t;
    }
    
    public void show() throws IOException{
        if(place==38){
            place=0;
            if(empty==0){
                type = 9;
                empty++;
            }else{
                type = rand.nextInt(8)+1;
                empty=0;
            }
        }
        else{
            place+=2;
        }

        switch(type){
            case 1:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(49, place, "         ");
                tg.putString(49, place+1, "         ");
                tg.putString(46, place, "@@@");
                tg.putString(46, place+1, "@@@");
                tg.putString(58, place, "@@@");
                tg.putString(58, place+1, "@@@");
                break;
            case 2:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(49, place, "   ");
                tg.putString(49, place+1, "   ");
                tg.putString(55, place, "      ");
                tg.putString(55, place+1, "      ");
                tg.putString(46, place, "@@@");
                tg.putString(46, place+1, "@@@");
                tg.putString(52, place, "@@@");
                tg.putString(52, place+1, "@@@");
                break;
            case 3:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(46, place, "      ");
                tg.putString(46, place+1, "      ");
                tg.putString(55, place, "   ");
                tg.putString(55, place+1, "   ");
                tg.putString(52, place, "@@@");
                tg.putString(52, place+1, "@@@");
                tg.putString(58, place, "@@@");
                tg.putString(58, place+1, "@@@");
                break;
            case 4:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(46, place, "   ");
                tg.putString(46, place+1, "   ");
                tg.putString(55, place, "      ");
                tg.putString(55, place+1, "      ");
                tg.putString(49, place, "@@@@@@");
                tg.putString(49, place+1, "@@@@@@");
                break;
            case 5:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(49, place, "      ");
                tg.putString(49, place+1, "      ");
                tg.putString(58, place, "   ");
                tg.putString(58, place+1, "   ");
                tg.putString(46, place, "@@@");
                tg.putString(46, place+1, "@@@");
                tg.putString(55, place, "@@@");
                tg.putString(55, place+1, "@@@");
                break;
            case 6:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(49, place, "      ");
                tg.putString(49, place+1, "      ");
                tg.putString(58, place, "   ");
                tg.putString(58, place+1, "   ");
                tg.putString(46, place, "@@@");
                tg.putString(46, place+1, "@@@");
                tg.putString(55, place, "@@@");
                tg.putString(55, place+1, "@@@");
                break;
            case 7:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(46, place, "   ");
                tg.putString(46, place+1, "   ");
                tg.putString(52, place, "         ");
                tg.putString(52, place+1, "         ");
                tg.putString(49, place, "@@@");
                tg.putString(49, place+1, "@@@");
                break;
            case 8:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(46, place, "         ");
                tg.putString(46, place+1, "         ");
                tg.putString(58, place, "   ");
                tg.putString(58, place+1, "   ");
                tg.putString(55, place, "@@@");
                tg.putString(55, place+1, "@@@");
                break;
            default:
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.setForegroundColor(TextColor.ANSI.GREEN);
                tg.putString(43, place, "###");
                tg.putString(43, place+1, "###");
                tg.putString(61, place, "###");
                tg.putString(61, place+1, "###");
                tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                tg.putString(46, place, "               ");
                tg.putString(46, place+1, "               ");
                break;
        }
        screen.refresh();
    }
}
