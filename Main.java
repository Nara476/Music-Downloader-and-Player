package MusicPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        File file = new File("MusicPlayer\\BleachSong.wav");
        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audio = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            String userInput = "";
            while (!userInput.equalsIgnoreCase("Q"))
            {
                System.out.println("Enter P to play");
                System.out.println("Enter S to Stop");
                System.out.println("Enter R to Reset");
                System.out.println("Enter Q to Quit");
                userInput = scanner.nextLine().toUpperCase();
                switch (userInput)
                {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.stop();
                    default -> System.out.println("Not a valid entry");
                }
            }

        }
        catch(LineUnavailableException e)
        {
            System.out.println("Couldn't find the line");
        }
        catch (UnsupportedAudioFileException e)
        {
            System.out.println("Unsupported music file");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Couldn't locate the file");
        }
        catch(IOException e)
        {
            System.out.println("Something went Wrong");
        }
        finally {
            System.out.println("played the music");
        }
    }

}
