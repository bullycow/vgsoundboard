import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.Scanner;


public class app {


    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


    }

    public File getAudioFile(String path) {
        return new File("");
    }

    public Clip getClip(String filePath) {
        File audioFile = getAudioFile(filePath);
        if(!audioFile.exists()) return null;
        try(AudioInputStream inputStream = AudioSystem.getAudioInputStream(audioFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            FloatControl gainCtrl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            System.out.print("Gain: ");
            float gainValue = in.nextFloat();
            System.out.println();
            gainCtrl.setValue(gainValue);
            return clip;
        }catch(IOException | LineUnavailableException |UnsupportedAudioFileException exception) {
           System.out.println("ERROR: " + exception.getMessage());
            return null;
        }
    }
}
