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

/**
 *
 * @author Kaveri
 */
public class Menu {
    Terminal terminal;
    Screen screen;
    TextGraphics tg;
    private int current;
    
    public Menu(Terminal m, Screen s, TextGraphics t){
        this.terminal = m;
        this.screen = s;
        this.tg = t;
        this.current = 1;
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
        
        //ver 2
        /*
        tg.putString(10, 10, " ______  ______  ________  _________  ___   ___       ______   ______  ________  ______      ");
        tg.putString(10, 11, "/_____/\\/_____/\\/_______/\\/________/\\/__/\\ /__/\\     /_____/\\ /_____/\\/_______/\\/_____/\\     ");
        tg.putString(10, 12, "\\:::_ \\ \\::::_\\/\\::: _  \\ \\__.::.__\\/\\::\\ \\\\  \\ \\    \\:::_ \\ \\\\:::_ \\ \\::: _  \\ \\:::_ \\ \\    ");
        tg.putString(10, 13, " \\:\\ \\ \\ \\:\\/___/\\::(_)  \\ \\ \\::\\ \\   \\::\\/_\\ .\\ \\    \\:(_) ) )\\:\\ \\ \\ \\::(_)  \\ \\:\\ \\ \\ \\   ");
        tg.putString(10, 14, "  \\:\\ \\ \\ \\::___\\/\\:: __  \\ \\ \\::\\ \\   \\:: ___::\\ \\    \\: __ `\\ \\:\\ \\ \\ \\:: __  \\ \\:\\ \\ \\ \\  ");
        tg.putString(10, 15, "   \\:\\/.:| \\:\\____/\\:.\\ \\  \\ \\ \\::\\ \\   \\: \\ \\\\::\\ \\    \\ \\ `\\ \\ \\:\\_\\ \\ \\:.\\ \\  \\ \\:\\/.:| | ");
        tg.putString(10, 16, "    \\____/_/\\_____\\/\\__\\/\\__\\/  \\__\\/    \\__\\/ \\::\\/     \\_\\/ \\_\\/\\_____\\/\\__\\/\\__\\/\\____/_/ ");
        tg.putString(10, 17, " _________  ______       ______  ______  __      ________  ___   __   ______                 ");
        tg.putString(10, 18, "/________/\\/_____/\\     /_____/\\/_____/\\/_/\\    /_______/\\/__/\\ /__/\\/_____/\\                ");
        tg.putString(10, 19, "\\__.::.__\\/\\:::_ \\ \\    \\:::_ \\ \\:::_ \\ \\:\\ \\   \\::: _  \\ \\::\\_\\\\  \\ \\:::_ \\ \\               ");
        tg.putString(10, 20, "   \\::\\ \\   \\:\\ \\ \\ \\    \\:(_) \\ \\:\\ \\ \\ \\:\\ \\   \\::(_)  \\ \\:. `-\\  \\ \\:\\ \\ \\ \\              ");
        tg.putString(10, 21, "    \\::\\ \\   \\:\\ \\ \\ \\    \\: ___\\/\\:\\ \\ \\ \\:\\ \\___\\:: __  \\ \\:. _    \\ \\:\\ \\ \\ \\             ");
        tg.putString(10, 22, "     \\::\\ \\   \\:\\_\\ \\ \\    \\ \\ \\   \\:\\_\\ \\ \\:\\/___/\\:.\\ \\  \\ \\. \\`-\\  \\ \\:\\/.:| |            ");
        tg.putString(10, 23, "      \\__\\/    \\_____\\/     \\_\\/    \\_____\\/\\_____\\/\\__\\/\\__\\/\\__\\/ \\__\\/\\____/_/            ");
        */
        screen.refresh();
        
        //screen.refresh();
        //terminal.readInput();//czeka na klawisz
        //screen.doResizeIfNecessary();
        //screen.clear();
        //screen.refresh();
        
//  ███╗   ███╗███████╗███╗   ██╗██╗   ██╗
//  ████╗ ████║██╔════╝████╗  ██║██║   ██║
//  ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║
//  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║
//  ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝
//  ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ 
//                                        
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
}
