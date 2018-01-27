/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prashanna;

import com.prashanna.mahout_webservice.RatingModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

/**
 *
 * @author prashanna
 */
public class GetSessionAttr {
    public static List<RatingModel> getSessionListFromRequest(HttpServletRequest request, String sessionName) {
        HttpSession session = request.getSession(false);
        ArrayList<RatingModel> rating;
        rating = (ArrayList<RatingModel>) session.getAttribute(sessionName);
        return rating;
        //sessionList
    }

    

    public static List<RecommendedItem> getSessionListRecommended(HttpServletRequest request, String sessionName) {
        HttpSession session = request.getSession(false);
        List<RecommendedItem> recommendedItem;
        recommendedItem = (ArrayList<RecommendedItem>) session.getAttribute(sessionName);
        return recommendedItem;
        //sessionRecommended
    }
}
