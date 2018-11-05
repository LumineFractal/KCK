/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

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
    
    public Block(Terminal m, Screen s, TextGraphics t){
        type = rand.nextInt(12) +1;
        place = -2;
        this.terminal = m;
        this.screen = s;
        this.tg = t;
    }
    
    public void show() throws IOException{
        if(place==38){
            place=0;
            type = rand.nextInt(12)+1;
        }
        else{
            place+=2;
        }
        switch(type){
            case 1:
                tg.putString(40, place, "   ###@@@         @@@###   ");
                tg.putString(40, place+1, "   ###@@@         @@@###   ");
                break;
            case 2:
                tg.putString(40, place, "   ###@@@   @@@      ###   ");
                tg.putString(40, place+1, "   ###@@@   @@@      ###   ");
                break;
            case 3:
                tg.putString(40, place, "   ###      @@@   @@@###   ");
                tg.putString(40, place+1, "   ###      @@@   @@@###   ");
                break;
            case 4:
                tg.putString(40, place, "   ###   @@@@@@      ###   ");
                tg.putString(40, place+1, "   ###   @@@@@@      ###   ");
                break;
            case 5:
                tg.putString(40, place, "   ###@@@      @@@   ###   ");
                tg.putString(40, place+1, "   ###@@@      @@@   ###   ");
                break;
            case 6:
                tg.putString(40, place, "   ###            @@@###   ");
                tg.putString(40, place+1, "   ###            @@@###   ");
                break;
            case 7:
                tg.putString(40, place, "   ###   @@@         ###   ");
                tg.putString(40, place+1, "   ###   @@@         ###   ");
                break;
            case 8:
                tg.putString(40, place, "   ###         @@@   ###   ");
                tg.putString(40, place+1, "   ###         @@@   ###   ");
                break;
            default:
                tg.putString(40, place, "   ###               ###   ");
                tg.putString(40, place+1, "   ###               ###   ");
                break;
        }
        screen.refresh();
    }
}
