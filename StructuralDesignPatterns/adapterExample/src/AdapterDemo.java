public class AdapterDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();

        Mp3Player vlcAdapter = new VlcAdapter();
        mediaPlayer.setPlayer(vlcAdapter);
        mediaPlayer.play("vandemataram.mp3");

        Mp3Player mxAdapter = new MXAdapter();
        mediaPlayer.setPlayer(mxAdapter);
        mediaPlayer.play("vandemataram.mp3");
    }
}
