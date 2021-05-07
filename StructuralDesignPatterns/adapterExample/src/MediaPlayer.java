public class MediaPlayer{
    Mp3Player mp3;
    public void play(String file) {
        mp3.playMedia(file);
       System.out.println("Playing Song");
    }
    public void setPlayer(Mp3Player mp3Player){
        this.mp3 = mp3Player;
    }
}
