/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohoenwa.databasecrud;

import com.prashanna.model.MovieIDDTO;
import com.sohoenwa.primefaceslogin.java.dao.UserDAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prashanna
 */
public class Filereader {
FileReader file;
BufferedReader br;
    public Filereader(String filename) {
    try {
        file=new FileReader("data/"+filename);
        br=new BufferedReader(file);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Filereader.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public static void writeToDBfromFile() {
        long counter = 0l;
        String line = "2";
        UserDAO udao = new UserDAO();
        MovieIDDTO movie = new MovieIDDTO();
        Filereader filereader = new Filereader("links.csv");
        try {
            while ((line = filereader.br.readLine()) != null) {

                String[] strarr = line.split(",");
                // System.out.println("size:"+strarr.length);
                movie.setMovieID(strarr[0]);
                movie.setImdbID(strarr[1]);
                if (counter != 0) {
                    udao.insert(movie);
                }
                counter++;
            }
            System.out.println("data enterd today::" + counter);
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
