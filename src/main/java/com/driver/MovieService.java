package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    // Create - Add values to the database
    // 1. Add movie
    public String addMovie(Movie movie){
        String result = movieRepository.addMovie(movie);
        return result;
    }

    // 2. Add Director
    public String addDirector(Director director){
        String result = movieRepository.addDirector(director);
        return result;
    }

    // 3. Update pair an existing movie and director
    public String addMovieDirectorPair(String movieName, String directorName){
        String result = movieRepository.addMovieDirectorPair(movieName, directorName);
        return result;
    }

    // 4. Get Movie associated with movieName
    public Movie getMovieByName(String movieName){
        Movie result = movieRepository.getMovieByName(movieName);
        return result;
    }

    // 5. Get Director associated directorName
    public Director getDirectorByName(String directorName){
        Director result = movieRepository.getDirectorByName(directorName);
        return result;
    }

    // 6. Get List of movie names by director name.
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> result = movieRepository.getMoviesByDirectorName(directorName);
        return result;
    }

    // 7. List of All movie names
    public List<String> findAllMovies(){
        List<String> result = movieRepository.findAllMovies();
        return result;
    }

    // 8. Delete director and its movies from the records
    public String deleteDirectorByName(String directorName){
        String result = movieRepository.deleteDirectorByName(directorName);
        return result;
    }

    //(Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)
    // 9.  Delete all movies and directors
    public String deleteAllDirectors(){
        String result = movieRepository.deleteAllDirectors();
        return result;
    }

}
