package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    // Create - Add values to the database
    // 1. Add movie
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String result = movieService.addMovie(movie);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 2. Add Director
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String result = movieService.addDirector(director);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 3. Update movie-director pair
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName,@RequestParam("director") String directorName){
        String result = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 4. Get Movie associated with movieName
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
        Movie result = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 5. Get Director associated directorName
    @GetMapping("/movies/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String directorName){
        Director result = movieService.getDirectorByName(directorName);
        return result;
    }

    // 6. Get List of movie names by director name.
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String> result = movieService.getMoviesByDirectorName(directorName);
        return result;
    }

    // 7. List of All movie names
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> result = movieService.findAllMovies();
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    // 8. Delete director and its movies from the records
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String directorName){
        String result = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

//    (Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)
    // 9.  Delete all movies and directors
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String result = movieService.deleteAllDirectors();
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

}
