package BridgePattern.Ex5;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface ThirdPartyYouTubeLib {
    public ArrayList<String> listVideos() throws FileNotFoundException;
    public String getVideoInfo(int id) throws FileNotFoundException;
    public void downloadVideo(int id) throws FileNotFoundException;
}
