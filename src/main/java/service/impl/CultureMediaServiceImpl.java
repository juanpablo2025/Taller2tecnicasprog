package service.impl;


import model.Video;
import model.View;
import repository.VideoRepository;
import repository.ViewsRepository;
import service.CultureMediaService;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService
{
    private VideoRepository videoRepository;
    private ViewsRepository viewRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewRepository)
    {
        this.videoRepository = videoRepository;
        this.viewRepository = viewRepository;
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
        View viewAdd = viewRepository.add(view);
        return viewAdd;
    }

    @Override
    public List<Video> ListAllVideos()
    {
        List<Video> videos = videoRepository.findAll();
        return videos;
    }

}
