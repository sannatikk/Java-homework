package oamk.stream;

// class VideoFile
public class VideoFile implements Playable {

    private Metadata videoFileData;
    private String fileName;

    public VideoFile(String videoFileName){;

        this.fileName = videoFileName;

        // parse so that a dash separates the author and the name of the video and a dot separates the name and the file type

        String[] parts = videoFileName.split("-");
        String author = parts[0].trim();

        String[] parts2 = parts[1].split("\\.");
        String name = parts2[0].trim();

        String fileType = parts2[1].trim();

        videoFileData = new Metadata(author, name, fileType);

    }

    public Metadata getVideoFileData() {
        return videoFileData;
    }

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
