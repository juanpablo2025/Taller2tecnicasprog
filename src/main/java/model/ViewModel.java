package model;

import java.time.LocalDateTime;

public record ViewModel(String userFullName, LocalDateTime startPlayingTime, Integer age, VideoModel video) {

}
