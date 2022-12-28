package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    // Databases
    HashMap<String, Movie> moviesDatabase = new HashMap<>();
    HashMap<String, Director> directorsDatabase = new HashMap<>();
    HashMap<Movie, Director> movieDirectorDB = new HashMap<>();
    HashMap<String, List<String>> director_movies = new HashMap<>();

    // Create - Add values to the database
    // 1. Add movie
    public String addMovie(Movie movie){
        String name = movie.getName();
        moviesDatabase.put(name, movie);
        return "Successfully added Movie to database";
    }

    // 2. Add Director
    public String addDirector(Director director){
        String name = director.getName();
        directorsDatabase.put(name, director);
        return "Successfully added Director to database";
    }

    // 3. Update pair an existing movie and director
    public String addMovieDirectorPair(String movieName, String directorName){
        if(director_movies.containsKey(directorName)){
            director_movies.get(directorName).add(movieName);
        }
        else{
            director_movies.put(directorName, new ArrayList<>());
            director_movies.get(directorName).add(movieName);
        }
        movieDirectorDB.put(moviesDatabase.get(movieName), directorsDatabase.get(directorName));
        return "Successfully added Movie-Director to database";
    }

    // 4. Get Movie associated with movieName
    public Movie getMovieByName(String movieName){
        if(moviesDatabase.containsKey(movieName)){
            return moviesDatabase.get(movieName);
        }
        return null;
    }

    // 5. Get Director associated directorName
    public Director getDirectorByName(String directorName){
        if(directorsDatabase.containsKey(directorName)){
            return directorsDatabase.get(directorName);
        }
        return null;
    }

    // 6. Get List of movie names by director name.
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> result = new ArrayList<>();
        for(Map.Entry<Movie, Director> entry : movieDirectorDB.entrySet()){
            String name = entry.getValue().getName();
            if(name.equals(directorName)){
                String name1 = entry.getKey().getName();
                result.add(name1);
            }
        }
        return director_movies.get(directorName);
    }

    // 7. List of All movie names
    public List<String> findAllMovies(){
        List<String> result = new ArrayList<>(moviesDatabase.keySet());
        return result;
    }

    // 8. Delete director and its movies from the records
    public String deleteDirectorByName(String directorName){
        for(Map.Entry<Movie, Director> entry : movieDirectorDB.entrySet()){
            String name = entry.getValue().getName();
            if(name.equals(directorName)){
                movieDirectorDB.remove(entry.getKey());
                moviesDatabase.remove(entry.getKey().getName());
                directorsDatabase.remove(directorName);
                return "Successfully deleted records associated with director";
            }
        }
        return null;
    }

    //(Note that there can be some movies on your watchlist that aren’t mapped to any of the director. Make sure you do not remove them.)
    // 9.  Delete all movies and directors
    public String deleteAllDirectors(){
        for(Map.Entry<Movie, Director> entry : movieDirectorDB.entrySet()){
            if(entry.getValue() != null){
                movieDirectorDB.remove(entry.getKey());
            }
        }
        return "Successfully removed the pair";
    }

}
