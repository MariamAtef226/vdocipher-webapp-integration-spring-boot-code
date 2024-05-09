package com.VdoCipherIntegration.backend.controller;

import com.VdoCipherIntegration.backend.entity.Enums;
import com.VdoCipherIntegration.backend.repository.VideoRepository;
import com.VdoCipherIntegration.backend.entity.Video;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/v1/admin/videos", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class VideoTestController {

    private VideoRepository videoRepository;
    public VideoTestController(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }
    private static final String API_URL = "https://dev.vdocipher.com/api/videos?title=";
    private static final String API_SECRET = "PLACE YOUR APIKEY FROM YOUR ACCOUNT";

    // get credentials to begin video upload
    @PostMapping()
    public ResponseEntity<String> getCredentials(){
        String title = "Course X's Promotional Video"; // Customize it as you wish

        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Apisecret " + API_SECRET);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set up request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Make PUT request
        ResponseEntity<String> responseEntity =restTemplate.exchange(API_URL+title , HttpMethod.PUT, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        System.out.println(responseBody);
        return responseEntity;
    }

    // delete video by video id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable(name = "id") String id){
        RestTemplate restTemplate = new RestTemplate();


        // Define the URL of the external endpoint
        String url = "https://www.vdocipher.com/api/videos?videos=";

        // Append the video ID to the URL
        url += id;

        // prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Apisecret " + API_SECRET);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Prepare the HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Send a DELETE request to the external endpoint
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);

        // Return the response received from the external endpoint
        return response;
    }

    // store the video id and status to your database
    @PostMapping("/{id}")
    public ResponseEntity<String> addVideoToDatabase(@PathVariable(name="id") String vdoId){
        // A) create and entry for it in database
        Video newVideo = new Video();
        newVideo.setVideoStatus(Enums.VideoStatus.PROCESSING);
        newVideo.setTitle("NAME IT AS YOUT WISH");
        newVideo.setVdoId(vdoId);
        videoRepository.save(newVideo);

        // TODO: create a webhook for it to monitor state changes


        return  ResponseEntity.ok(new String("ADDED TO DATABASE!"));
    }

    // get otp for playing video at client-side
    @GetMapping("/{id}")
    public ResponseEntity<String> getOtp(@PathVariable(name="id") String videoId){
        String url = "https://dev.vdocipher.com/api/videos/"+videoId+"/otp";

        // Set up headers & body
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Apisecret " + API_SECRET);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"ttl\": 333}";

        // Set up request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Create RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Make POST request
        ResponseEntity<String> responseEntity =restTemplate.exchange(url , HttpMethod.POST, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        //System.out.println(responseBody);
        return responseEntity;
    }
}
