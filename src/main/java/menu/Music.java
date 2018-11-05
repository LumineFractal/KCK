/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Kaveri
 */

class Music {
    private static Clip clip;
    private static double level = 1;

    static void playMenu(int choose) {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            if(choose == 1){
                clip.open(AudioSystem.getAudioInputStream(new File("FloraFauna.wav")));
            }else{
                clip.open(AudioSystem.getAudioInputStream(new File("HelixNebula.wav")));
            }
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        clip.loop(100);
        clip.setMicrosecondPosition(1500000);
        clip.start();
    }

    static void setLevel(double slevel) {
        level = slevel;
        Music.setVolume();
    }

    static double getLevel() {
        return level;
    }

    static void setVolume() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float) (Math.log(getLevel()) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);

        BooleanControl muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
        muteControl.setValue(true);

        muteControl.setValue(false);
    }

    static void stop() {
        clip.stop();
    }
}
