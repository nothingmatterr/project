package BridgePattern.Ex5;
 import java.io.*;
 import java.util.ArrayList;
 import java.util.Scanner;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
    public ArrayList<String> listVideos() throws FileNotFoundException {
        // đọc file rồi ném vào đây
        ArrayList<String> listVideo = new ArrayList<>();
        File file = new File("C:\\Users\\Asus\\Desktop\\String input.txt");
        try ( Scanner scanner = new Scanner(file) ) {
            while (scanner.hasNextLine()) {
                listVideo.add(scanner.nextLine());
            }
        }
        catch (Exception e) {
            e.fillInStackTrace();
        }
        return listVideo;
    }
    public String getVideoInfo(int id) throws FileNotFoundException {
        ArrayList<String> videoinfo = new ArrayList<String>();
        File file = new File("C:\\Users\\Asus\\Desktop\\VideoCache.txt");
        try (Scanner scanner = new Scanner(file) ) {
            videoinfo.add(scanner.nextLine());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return videoinfo.get(id);
    }
    public void downloadVideo(int id) throws FileNotFoundException {
        System.out.println("Your video are downloading " + this.getVideoInfo(id));
    }
}
