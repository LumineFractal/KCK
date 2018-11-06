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
class Effect {
    private static Clip clip;
    private static double level = 1;

    static void playEffect(int choose){
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            if(choose == 1){
                clip.open(AudioSystem.getAudioInputStream(new File("gameover.wav")));
                clip.loop(100);
            }else if(choose == 3){
                clip.open(AudioSystem.getAudioInputStream(new File("empty.wav")));
            }
            else{
                clip.open(AudioSystem.getAudioInputStream(new File("collision.wav")));
            }
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        clip.setMicrosecondPosition(1);
        clip.start();
    }

    static void setLevel(double slevel) {
        level = slevel;
        Effect.setVolume();
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
