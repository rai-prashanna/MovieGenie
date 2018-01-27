package com.prashanna.mahout_webservice;

/**
 * Created by subash on 8/24/15.
 */
public class RatingModel {
    private int userID;
    private long movieID;
    private float rating;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public long getMovieID() {
        return movieID;
    }

    public void setMovieID(long movieID) {
        this.movieID = movieID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}