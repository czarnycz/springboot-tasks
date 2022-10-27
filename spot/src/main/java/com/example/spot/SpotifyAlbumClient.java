package com.example.spot;

import com.example.spot.dto.SpotifyAlbumDto;
import com.example.spot.dto.SpotifyTrackDto;
import com.example.spot.model.SpotifyAlbum;
import com.example.spot.model2.SpotifyTrack;
import com.example.spot.model2.Track;
import com.example.spot.repository.Trackrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class SpotifyAlbumClient {

    private final Trackrepository repo;


    @GetMapping("/album/{authorName}")
    public List<SpotifyAlbumDto> getAlbumsByAuthor(OAuth2Authentication details, @PathVariable String authorName) {
        String jwt = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyAlbum> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q="+ authorName + "&type=track&market=US&limit=20&offset=5",
                HttpMethod.GET,
                httpEntity,
                SpotifyAlbum.class);

        List<SpotifyAlbumDto> spotifyAlbumDtos = exchange.getBody().getTracks().getItems().stream()
                .map(item-> new SpotifyAlbumDto(item.getName(),item.getAlbum().getImages().get(0).getUrl()))
                .collect(Collectors.toList());


        return spotifyAlbumDtos;
    }

    @GetMapping("/track/{trackName}")
    public List<SpotifyTrackDto> getTrack(OAuth2Authentication details, @PathVariable String trackName){
        String jwt = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyTrack> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q="+ trackName + "&type=track&market=US&limit=1&offset=5",
                HttpMethod.GET,
                httpEntity,
                SpotifyTrack.class);

       List<SpotifyTrackDto> spotifyTrackDtos = exchange.getBody().getTrack().getItems().stream()
               .map(item-> new SpotifyTrackDto(item.getName(),item.getAlbum().getImages().get(0).getUrl()))
               .collect(Collectors.toList());

       return spotifyTrackDtos;

    }


    @PostMapping("/add-track")
    public void save(@RequestBody com.example.spot.entity.Track track) {
        repo.save(track);
    }
}