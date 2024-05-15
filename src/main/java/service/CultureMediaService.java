package service;

import model.Video;
import model.View;

import java.util.List;

public interface CultureMediaService {
    Video add(Video video);

    View add(View view);

    List<Video> ListAllVideos();
}
