package com.prashanna.mahout_webservice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by subash on 8/24/15.
 */
public class ServletRating extends HttpServlet {
    
    private long movieid;
    private int userid;
    private float rating;
    final int ratingsize=7;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
//        String forward = "rating.jsp";
        String forward = "index.jsp";
        String rec="";
        if (action == null) {
            movieid = Long.parseLong(request.getParameter("movieid"));
            
            rating = Float.parseFloat(request.getParameter("rating"));
            userid = 999;
            RatingModel rate = new RatingModel();
            rate.setMovieID(movieid);
            rate.setRating(rating);
            rate.setUserID(userid);
            
            response.setContentType("text/html");
            HttpSession session = request.getSession(false);
            if (session.getAttribute("sessionList") == null) {
                session = request.getSession();
                ArrayList<RatingModel> sessionList = new ArrayList<RatingModel>();
                sessionList.add(rate);
                
                session.setAttribute("sessionList", sessionList);
                
            } else {
                ArrayList<RatingModel> fetchArray = new ArrayList<RatingModel>();
                fetchArray = (ArrayList<RatingModel>) session.getAttribute("sessionList");
                fetchArray.add(rate);
                session.setAttribute("sessionList", fetchArray);
            }
            ArrayList<RatingModel> rating;
            rating = (ArrayList<RatingModel>) session.getAttribute("sessionList");
            
            if (rating.size() > ratingsize) {
                forward = "/AnonyRecommenderServlet?userID=999";
                 rec="ok";
            } else {
                forward = "/RatingContrl?index=" + request.getParameter("movieid");
            }
        }
        else if (action.equalsIgnoreCase("skip"))
        {
            forward="/RatingContrl?index=" + request.getParameter("movieid");
        }
        else if (action.equalsIgnoreCase("skip")){
          //movieid
            forward = "/RatingContrl?index=" + request.getParameter("movieid");
        }
        else{
          //movieid
            forward = "/RatingContrl?index=" + request.getParameter("movieid");
        }
        
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        
        view.forward(request, response);
    }
}
