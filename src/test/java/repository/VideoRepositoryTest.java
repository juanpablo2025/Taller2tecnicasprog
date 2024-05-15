package repository;

import model.Video;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoRepositoryTest {

    private VideoRepository videoRepository;

    @BeforeEach
    void setUp() {
        videoRepository = new VideoRepositoryImpl();

        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)
        );

        videos.forEach(videoRepository::save);
    }

    @Test
    void findAll_ShouldReturnAllVideos_WhenCalled() {
        List<Video> videos = videoRepository.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void find_ShouldReturnVideosWithTitleContainingKeyword_WhenCalled() {
        List<Video> videos = videoRepository.find("Clic");
        assertEquals(2, videos.size());
    }

    @Test
    void find_ShouldReturnVideosWithinSpecifiedDurationRange_WhenCalled() {
        List<Video> videos = videoRepository.find(4.5, 5.5);
        assertEquals(3, videos.size());
    }

    @Test
    void find_ShouldReturnEmptyList_WhenNoVideosMatchTitle() {
        List<Video> videos = videoRepository.find("Fake");
        assertEquals(0, videos.size());
    }

    @Test
    void find_ShouldReturnEmptyList_WhenNoVideosMatchDurationRange() {
        List<Video> videos = videoRepository.find(0.1, 0.3);
        assertEquals(0, videos.size());
    }
}
