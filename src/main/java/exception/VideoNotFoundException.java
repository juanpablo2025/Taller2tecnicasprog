package exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CultureMediaException{
    public VideoNotFoundException() {
        super("Video not found");
    }
    public VideoNotFoundException(String title) {
        super(MessageFormat.format("The video {0} was not found", title));
    }
}
