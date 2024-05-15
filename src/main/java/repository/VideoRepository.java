package repository;

import model.VideoModel;

import java.util.List;

public interface VideoRepository {
    List<VideoModel> findAll();
    VideoModel save(VideoModel video);
    List<VideoModel> find(String title);
    List<VideoModel> find(Double fromDuration, Double toDuration);
}
