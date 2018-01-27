/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prashanna.mahout_webservice;

import com.prashanna.GetSessionAttr;
import com.prashanna.Movie;
import com.prashanna.StringsTOMovies;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prashanna
 */
public class servletsd extends HttpServlet {

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

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mid = "";
        mid = request.getParameter("getdetail");
        String forward = "";
        if (mid != null) {
            try {

//                mid=request.getParameter("action");
                System.out.println("movieid from servletsd:::" + mid);

                Movie movie = new Movie(mid);
                movie.setYoutubeurl("");
                System.out.println("movie url:::"+movie.youtubeurl);
                request.setAttribute("movie", movie);
                //System.out.println("movie youtube link::"+movie.youtubetag);
                forward = "/video.jsp";
            } catch (Exception ex) {
                Logger.getLogger(servletsd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            System.out.println("movieid from servletsd:::" + mid);

            List<String> recommendeIds = new ArrayList<String>();
            List<RecommendedItem> recommendemovie = GetSessionAttr.getSessionListRecommended(request, "sessionRecommended");

            for (RecommendedItem recommendedItem : recommendemovie) {

                recommendeIds.add(String.valueOf(recommendedItem.getItemID()));

            }

            List<Movie> movieobjlist = null;
            try {
                movieobjlist = StringsTOMovies.getMovie(recommendeIds);
            } catch (Exception ex) {
                Logger.getLogger(servletsd.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("movielist", movieobjlist);
            String status= "recommendationDone";
            request.setAttribute("recomStatus",status);
//            forward = "/listrecomm.jsp";
            forward = "/index.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);

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
/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
