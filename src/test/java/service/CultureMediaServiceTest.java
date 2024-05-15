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

    Video VideoA = new Video("100", "The Lion King", "_ _ _ _ _", 2.2);
    Video VideoB = new Video("200", "Finding Nemo", "_ _ _ _ _", 3.3);
    Video VideoC = new Video("300", "How to Train Your Dragon", "_ _ _ _ _", 4.4);
    Video VideoD = new Video("400", "The Wind Rises", "_ _ _ _ _", 5.5);
    Video VideoE = new Video("500", "The LEGO Movie", "_ _ _ _ _", 6.6);
    Video VideoF = new Video("500", "Song of the Sea", "_ _ _ _ _", 7.7);

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

    @Test
    void when_you_search_by_title_and_it_is_not_found_then_exception_should_be_thrown() {
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("better luck for the next");
        });
    }


    @Test
    void when_searching_for_nonexistent_title_then_throw_VideoNotFoundException() {
        // Arrange
        List<Video> videos = List.of(VideoA, VideoB, VideoC, VideoD, VideoE, VideoF);
        for (Video video : videos) {
            cultureMediaService.add(video);
        }

        // Act & Assert
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("Nonexistent Title");
        });
    }

    @Test
    void when_you_search_by_forDuration_and_it_is_found_then_no_exception_should_be_thrown() {
        List<Video> videos = List.of(VideoA, VideoB, VideoC, VideoD, VideoE, VideoF);

        for (Video video : videos) {
            cultureMediaService.add(video);
        }

        assertDoesNotThrow(() -> {
            cultureMediaService.find(3.3, 6.6);
        });
    }
}

