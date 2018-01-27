/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohoenwa.databasecrud;

import com.prashanna.Movie;
import com.prashanna.StringsTOMovies;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prashanna
 */
public class NewClass {

    public static void main(String[] args) throws Exception {
        Movie movie=new Movie("tt0113627");
       movie.setYoutubeurl("");
       int index=0;
        System.out.println("video url:::"+ movie.getYoutubeurl());
        for (int i = 0; i < 10; i++) {
       index=(int) ((((Math.random())*27304))+index+1);
        System.out.println("print random"+index);     
        }
       
//      UserDAO udao = new UserDAO();
//      MovieIDDTO movie = new MovieIDDTO();
//      String line = "2";
//      movie = udao.getImdbIDbyMID(line);
//     System.out.println("movie data::" + "tt0" + movie.getImdbID());
//        
       
    
       
//       String mi1="1";
//       String mi2="2";
//         List<String> recommendeIds = new ArrayList<String>();
//         recommendeIds.add(mi1);
//         recommendeIds.add(mi2);
//         List<Movie> movieobjlist = StringsTOMovies.getMovie(recommendeIds);
//       Movie movie1=new Movie("tt0113228");
//        System.out.println(movie1.plot);
//        for (Movie movy : movieobjlist) {
//            System.out.println("---------------------------------");
//            System.out.println("movieplot::");
//            System.out.println(movy.plot);
//            System.out.println("movievideoid::");
//            System.out.println("+++++++++++++++");
//            
//        }
    ///    Filereader filereader=new Filereader("links.csv");
       // filereader.writeToDBfromFile();
    }

   
    
    
}