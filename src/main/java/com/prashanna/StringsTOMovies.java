/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prashanna;

import com.prashanna.model.MovieIDDTO;
import com.sohoenwa.primefaceslogin.java.dao.UserDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author prashanna
 */
public class StringsTOMovies {
    public static List<Movie> getMovie(List<String> movieids) throws Exception {
        List<String> imdbIDs = new ArrayList<String>();
        List<Movie> movies = new ArrayList<Movie>();
        //mapping from movielensid to ImdbID
        for (Iterator<String> iterator = movieids.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            UserDAO udao = new UserDAO();
            MovieIDDTO movie = new MovieIDDTO();

            movie = udao.getImdbIDbyMID(next);
            String imdbID = movie.getImdbID();
            imdbIDs.add(imdbID);
            // new Movie(imdbID);
        }
        //mapping from String to Movie objects
        for (Iterator<String> iterator = imdbIDs.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            Movie movie=new Movie(next);
            //movie.setImdbID(next);
            movies.add(movie);

        }
        return movies;

    }
//    public static List<>

    
}
