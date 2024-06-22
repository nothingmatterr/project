package BridgePattern.Ex5;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CachedYoutubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;
    private ArrayList<String > listCached;
    private String videoCache;
    protected boolean needReset;
    public CachedYoutubeClass(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

     public ArrayList<String> listVideos() throws FileNotFoundException {
        if (listCached == null || needReset) {
            listCached = service.listVideos();
        }
        return listCached;
     }
     public String  getVideoInfo(int id) throws FileNotFoundException {
        if (videoCache == null || needReset) {
            videoCache = service.getVideoInfo(id);
        }
        return videoCache;
     }
     public void downloadVideo(int id) throws FileNotFoundException {
        if (this.getVideoInfo(id) != null || needReset) {
           service.downloadVideo(id);
        }
     }
}
