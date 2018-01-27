/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.prashanna.mahout_webservice;

//import org.apache.mahout.cf.taste.common.TasteException;
//import org.apache.mahout.cf.taste.model.DataModel;
//import org.apache.mahout.cf.taste.model.Preference;
//import org.apache.mahout.cf.taste.model.PreferenceArray;
//import org.apache.mahout.cf.taste.recommender.RecommendedItem;
//import org.apache.mahout.cf.taste.recommender.Recommender;

import com.prashanna.RecMovieAnonymous;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.prashanna.RecMovieAnonymous.SetAnonymousUserpreference;

//------------------------this is under construction............... 
//   ---------------------   by LORD PRASHANNA


public final class AnonymousRecommenderServlet extends HttpServlet {

    private static final int NUM_TOP_PREFERENCES = 20;
    private static final int DEFAULT_HOW_MANY = 10;
    private static final Logger log = LoggerFactory.getLogger(AnonymousRecommenderServlet.class);
    private RecMovieAnonymous anonymousRecommender;
    //private Recommender anonymousRecommender;
    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("Initializing recommender servlet!!");
        super.init(config);
        //String recommenderClassName = config.getInitParameter("recommender-class");
       String AnonymousrecommenderClassName=config.getInitParameter("Anonymous-recommender-class");
//        if (recommenderClassName == null) {
//            throw new ServletException("Servlet init-param \"recommender-class\" is not defined");
//        }
//        RecommenderSingleton.initializeIfNeeded(recommenderClassName);
//        recommender = RecommenderSingleton.getInstance().getRecommender();
        if (AnonymousrecommenderClassName == null) {
           throw new ServletException("Servlet init-param \"recommender-class\" is not defined");        }
       AnonymousRecommenderSingleton.initializeIfNeeded(AnonymousrecommenderClassName);
       anonymousRecommender=AnonymousRecommenderSingleton.getInstance().getRecommender();
       
        log.info("Finished initializing recommender!!");
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            String userIDString = request.getParameter("userID");
            if (userIDString == null) {
                throw new ServletException("userID was not specified");
            }
            long userID = Long.parseLong(userIDString);
            
            String howManyString = request.getParameter("howMany");
            int howMany = howManyString == null ? DEFAULT_HOW_MANY : Integer.parseInt(howManyString);
            boolean debug = Boolean.parseBoolean(request.getParameter("debug"));
            String format = request.getParameter("format");
            if (format == null) {
                format = "text";
            }
            List<RecommendedItem> items;
             HttpSession session = request.getSession(false);
           ArrayList<RatingModel> rating;
        rating = (ArrayList<RatingModel>)session.getAttribute("sessionList");
            items=anonymousRecommender.recommend(SetAnonymousUserpreference(rating), howMany);
            setSessionListWithRecommendeItem(request, items);
            
//        try {
//            items = recommender.recommend(userID, howMany);
//            
//        }
//        catch (TasteException te) {
//            throw new ServletException(te);
//        } 
             RequestDispatcher view = request.getRequestDispatcher("/se");

        view.forward(request, response);
        try {
        if ("text".equals(format)) {
                writePlainText(response, userID, debug, items);
            } else if ("xml".equals(format)) {
                writeXML(response, items);
            } else if ("json".equals(format)) {
                writeJSON(response, items);
            } else {
                throw new ServletException("Bad format parameter: " + format);
            }    
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(AnonymousRecommenderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TasteException ex) {
            java.util.logging.Logger.getLogger(AnonymousRecommenderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        } catch (TasteException ex) {
            java.util.logging.Logger.getLogger(AnonymousRecommenderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    private static void writeXML(HttpServletResponse response, Iterable<RecommendedItem> items) throws IOException {
        response.setContentType("application/xml");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter writer = response.getWriter();
        writer.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?><recommendedItems>");
        for (RecommendedItem recommendedItem : items) {
            writer.print("<item><value>");
            writer.print(recommendedItem.getValue());
            writer.print("</value><id>");
            writer.print(recommendedItem.getItemID());
            writer.print("</id></item>");
        }
        writer.println("</recommendedItems>");
    }

    private static void writeJSON(HttpServletResponse response, Iterable<RecommendedItem> items) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter writer = response.getWriter();
        writer.print("{\"recommendedItems\":{\"item\":[");
        for (RecommendedItem recommendedItem : items) {
            writer.print("{\"value\":\"");
            writer.print(recommendedItem.getValue());
            writer.print("\",\"id\":\"");
            writer.print(recommendedItem.getItemID());
            writer.print("\"},");
        }
        writer.println("]}}");
    }

    private void writePlainText(HttpServletResponse response,
            long userID,
            boolean debug,
            Iterable<RecommendedItem> items) throws IOException, TasteException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter writer = response.getWriter();
//        if (debug) {
//            writeDebugRecommendations(userID, items, writer);
//        } else {
//            writeRecommendations(items, writer);
//        }
     
        writeRecommendations(items, writer);
    }

    private static void writeRecommendations(Iterable<RecommendedItem> items, PrintWriter writer) {
        for (RecommendedItem recommendedItem : items) {
        	writer.print(recommendedItem.getItemID());
           		writer.print('\t');
             writer.println(recommendedItem.getValue());
        }
    }

//    private void writeDebugRecommendations(long userID, Iterable<RecommendedItem> items, PrintWriter writer)
//            throws TasteException {
//        DataModel dataModel = recommender.getDataModel();
//        writer.print("User:");
//        writer.println(userID);
//        writer.print("Recommender: ");
//        writer.println(recommender);
//        writer.println();
//        writer.print("Top ");
//        writer.print(NUM_TOP_PREFERENCES);
//        writer.println(" Preferences:");
//        PreferenceArray rawPrefs = dataModel.getPreferencesFromUser(userID);
//        int length = rawPrefs.length();
//        PreferenceArray sortedPrefs = rawPrefs.clone();
//        sortedPrefs.sortByValueReversed();
//        // Cap this at NUM_TOP_PREFERENCES just to be brief
//        int max = Math.min(NUM_TOP_PREFERENCES, length);
//        for (int i = 0; i < max; i++) {
//            Preference pref = sortedPrefs.get(i);
//            writer.print(pref.getValue());
//            writer.print('\t');
//            writer.println(pref.getItemID());
//        }
//        writer.println();
//        writer.println("Recommendations:");
//        for (RecommendedItem recommendedItem : items) {
//            writer.print(recommendedItem.getValue());
//            writer.print('\t');
//            writer.println(recommendedItem.getItemID());
//        }
//    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //@Override
//    public String toString() {
//        return "RecommenderServlet[recommender:" + recommender + ']';
//    }
    
public void setSessionListWithRecommendeItem(HttpServletRequest request, List<RecommendedItem> listRecommended) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("sessionRecommended")==null){
            //session = request.getSession();
            List<RecommendedItem> sessionRecomm = new ArrayList<RecommendedItem>();
            sessionRecomm.addAll(listRecommended);
            
            session.setAttribute("sessionRecommended",sessionRecomm);

        }
//        else{
//            ArrayList<RatingModel> fetchArray = new ArrayList<RatingModel>();
//            fetchArray=(ArrayList<RatingModel>)session.getAttribute("sessionList");
//            fetchArray.add(rate);
//            session.setAttribute("sessionList",fetchArray);
//        }
       
    }
}
