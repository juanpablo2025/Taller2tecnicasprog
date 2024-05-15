package service;

import exception.VideoNotFoundException;
import model.Video;
import model.View;

import java.util.List;

public interface CultureMediaService
{

    Video add(Video video);
    View add(View view);

    List<Video> listAllVideos() throws VideoNotFoundException;
    List<Video> find(String title) throws VideoNotFoundException;
    List<Video> find(double fromDuration, double toDuration) throws VideoNotFoundException;

}
