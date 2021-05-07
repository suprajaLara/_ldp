public class MXAdapter implements Mp3Player{
    MXPlayer mxPlayer = new MXPlayer();
    @Override
    public void playMedia(String fileName) {
        mxPlayer.playFile(fileName);
    }
}
