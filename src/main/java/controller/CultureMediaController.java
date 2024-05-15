package controller;

import exception.VideoNotFoundException;
import model.Video;
import service.CultureMediaService;

import java.util.List;

public class CultureMediaController
{

    private final CultureMediaService cultureMediaService;


    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> ListAllVideos() throws VideoNotFoundException {
        List<Video> videos = cultureMediaService.listAllVideos();
        return videos;
    }

}
