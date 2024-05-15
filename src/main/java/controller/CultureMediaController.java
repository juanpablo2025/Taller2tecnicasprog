package controller;

import exception.VideoNotFoundException;
import model.Video;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.CultureMediaService;

import java.util.List;

@RestController
public class CultureMediaController {

    private final CultureMediaService cultureMediaService;

    public CultureMediaController(CultureMediaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> listAllVideos() {
        try {
            List<Video> videos = cultureMediaService.listAllVideos();
            return new ResponseEntity<>(videos, HttpStatus.OK);
        } catch (VideoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/videos")
    public ResponseEntity<Video> add(@RequestBody Video video) {
        return ResponseEntity.status( HttpStatus.OK ).body(cultureMediaService.add(video));
    }
}
