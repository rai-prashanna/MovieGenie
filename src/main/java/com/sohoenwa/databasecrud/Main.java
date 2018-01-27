package com.sohoenwa.databasecrud;


import java.util.ArrayList;
import java.util.List;
import com.sohoenwa.databasecrud.Movie;
public class Main
{

    public static void main(String [] args) throws Exception{
        //ImdbIdList Initialization
        List<String> ImdbIdList=new ArrayList<String>();
            ImdbIdList.add("tt0290218");
            ImdbIdList.add("tt0053125");
            ImdbIdList.add("tt0119488");
            ImdbIdList.add("tt0290218");

        MultipleMovieList webRequest=new MultipleMovieList();
        List<Movie> movieList=new ArrayList<Movie>();//list of movie initialization
        movieList=webRequest.Start(ImdbIdList);//putting list of movie object in list

        for (Movie m:movieList)
            m.LongDetail();

    }
}