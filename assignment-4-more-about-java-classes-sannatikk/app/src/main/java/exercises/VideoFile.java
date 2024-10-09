package exercises;

public class VideoFile implements Playable {

    public static String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String play() {
        return "Playing videofile: " + fileName;
    }

    public String pause(Integer seconds) {
        return "Videofile " + fileName + " paused for " + seconds + " seconds";
    }

    public String stop() {
        return "Videofile " +fileName + " stopped";
    }



}