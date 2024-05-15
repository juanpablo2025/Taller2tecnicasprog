package service.impl;


import exception.VideoNotFoundException;
import model.Video;
import model.View;
import repository.VideoRepository;
import repository.ViewsRepository;
import service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService{
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository)
    {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public Video add(Video video)
    {
        Video videoAdd = videoRepository.save(video);
        return videoAdd;
    }

    @Override
    public View add(View view)
    {
        View viewAdd = viewsRepository.save(view);
        return viewAdd;
    }

    @Override
    public List<Video> listAllVideos() throws VideoNotFoundException
    {

        List<Video> videos = videoRepository.findAll();
        if(videos.isEmpty())

        {
            throw new VideoNotFoundException();
        }

        else

        {
            return videos;
        }
    }
}