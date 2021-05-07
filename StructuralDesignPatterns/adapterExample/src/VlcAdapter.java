public class VlcAdapter implements Mp3Player{
    VlcPlayer vlcPlayer = new VlcPlayer();
    @Override
    public void playMedia(String songName) {
        vlcPlayer.playMp3(songName);
    }
}
