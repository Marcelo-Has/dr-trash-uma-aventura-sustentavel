package jogo;

import jplay.Sound;
import jplay.URL;

public class Som {
    
    public static Sound musica;
    
    //Liga a música com loop
    public static void play(String audio){
        stop();
        musica = new Sound(URL.audio(audio));
        Som.musica.play();
        Som.musica.setRepeat(true);
    }
    
    //Liga a música sem loop
    public static void playUma(String audio){
        musica = new Sound(URL.audio(audio));
        Som.musica.play();
        
    }
    
    ////Para a música
    public static void stop(){
        if(Som.musica != null){
            musica.stop();
        }
    }
    
}
