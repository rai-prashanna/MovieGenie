package com.sohoenwa.primefaceslogin.java.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.prashanna.model.MovieIDDTO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class UserDAO {   
    private Connection connection;

    public UserDAO() {
        connection = Database.getConnection();
    }
     public  boolean checklogin(String user, String password) {
        
        PreparedStatement ps = null;
        try {
            
            ps = connection.prepareStatement(
                    "select user, pass from userinfo where user= ? and pass= ? ");
            ps.setString(1, user);
            ps.setString(2, password);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("user"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(connection);
        }
    }
     public void insert(MovieIDDTO movie){
         
        PreparedStatement ps = null;
        
         try {
             ps=connection.prepareStatement("insert into links(movieId, imdbId ) values (?, ?)");
             ps.setInt(1,Integer.parseInt(movie.getMovieID()));
            ps.setInt(2, Integer.parseInt(movie.getImdbID()));
             ps.executeUpdate();
         } catch (SQLException ex) {
             //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Exception"+ex);
         }
     }
     public MovieIDDTO getImdbIDbyMID(String id){
         MovieIDDTO movieIDDTO=new MovieIDDTO();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from links where movieId=?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                movieIDDTO.setMovieID(id);
                movieIDDTO.setImdbID("tt0"+rs.getString("imdbId"));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return movieIDDTO;
     }
//      public List<User> getAllUsers() {
//        List<User> users = new ArrayList<User>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from users");
//            while (rs.next()) {
//                User user = new User();
//                user.setUname(rs.getString("uname"));
//                user.setPassword(rs.getString("password"));
//                user.setEmail(rs.getString("email"));
//                user.setRegisteredon(rs.getDate("registeredon"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return users;
//    }
}