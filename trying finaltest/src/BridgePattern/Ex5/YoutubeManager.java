package BridgePattern.Ex5;

import java.io.FileNotFoundException;

public class YoutubeManager {
    protected ThirdPartyYouTubeLib service;
    public YoutubeManager(ThirdPartyYouTubeLib service) {
        this.service = service;
    }
    public void renderVideoPage(int id) throws FileNotFoundException {
        String info = service.getVideoInfo(id);
    }
}
