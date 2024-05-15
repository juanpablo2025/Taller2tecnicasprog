package service;

import exception.VideoNotFoundException;
import model.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.VideoRepository;
import repository.ViewsRepository;
import service.impl.CultureMediaServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CultureMediaServiceTest {
    private CultureMediaServiceImpl cultureMediaService;
    private VideoRepository videoRepository;

    @BeforeEach
    void setUp() {
        videoRepository = mock(VideoRepository.class);
        cultureMediaService = new CultureMediaServiceImpl(videoRepository, null);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        // Prepare test data
        List<Video> expectedVideos = List.of(
                new Video("01", "Title1", "Description1", 10.0),
                new Video("02", "Title2", "Description2", 15.0)
        );
        when(videoRepository.findAll()).thenReturn(expectedVideos);

        // Invoke the method under test
        List<Video> result = cultureMediaService.listAllVideos();

        // Verify the result
        assertEquals(expectedVideos, result);
        verify(videoRepository, times(1)).findAll();
    }
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        // Arrange
        VideoRepository videoRepository = mock(VideoRepository.class);
        ViewsRepository viewsRepository = mock(ViewsRepository.class); // Crear un mock para ViewsRepository
        when(videoRepository.findAll()).thenReturn(Collections.emptyList());

        CultureMediaService cultureMediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);

        // Act and Assert
        assertThrows(VideoNotFoundException.class, cultureMediaService::listAllVideos);
    }
}
