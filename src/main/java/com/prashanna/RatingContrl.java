/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prashanna;

import com.prashanna.model.MovieIDDTO;
import com.sohoenwa.primefaceslogin.java.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prashanna
 */
public class RatingContrl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String indexstr = request.getParameter("index");
        int index = Integer.valueOf(indexstr);
//        String forward = "/rating.jsp";
        String forward = "/index.jsp";
        if (indexstr.equalsIgnoreCase("0")) {
            index = 1;

        } else {
//            if(index==10){
//           forward="/AnonyRecommenderServlet?userID=999";
//            }

            //  index=(int) ((((Math.random())*27303))+1);
            index++;
        }
        String movielensid = String.valueOf(index);
        UserDAO udao = new UserDAO();
        MovieIDDTO moviedto = new MovieIDDTO();
        //moviedto.setMovieID(movielensid);
        moviedto = udao.getImdbIDbyMID(movielensid);
        System.out.println("moviedto:::" + moviedto.getImdbID());
        Movie movieobj = new Movie(moviedto.getImdbID());
        request.setAttribute("movieobj", movieobj);
        // String movielens=moviedto.getMovieID();
        request.setAttribute("moviedto", moviedto);

        request.setAttribute("index", index);
        System.out.println("inex:::" + index);
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RatingContrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RatingContrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
