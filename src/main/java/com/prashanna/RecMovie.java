/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prashanna;

/**
 *
 * @author prashanna
 */
import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;
import org.apache.mahout.cf.taste.common.*;
import java.io.*;
import java.util.*;
import java.net.URL;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.Resources;

//------------------------this is under construction............... 
//   ---------------------   by LORD PRASHANNA
public class RecMovie implements Recommender {

     final Recommender recommender;
    public final DataModel model;
    public final UserSimilarity similarity;
    public final UserNeighborhood neighborhood;

    public RecMovie() throws IOException, TasteException {
        
        this(new FileDataModel(readResourceToTempFile("movies.csv")));
        
    }
    public RecMovie(DataModel datamodel) throws TasteException,IOException{
       
        this.model=datamodel;
        similarity = new PearsonCorrelationSimilarity(model);
        neighborhood = new NearestNUserNeighborhood(2, similarity, model);
        recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        
    }

    @Override
    public List<RecommendedItem> recommend(long userID, int howMany) throws TasteException {
        IDRescorer rescorer = NullRescorer.getItemInstance();
        return recommender.recommend(userID, howMany, rescorer);
    }

    @Override
    public List<RecommendedItem> recommend(long userID, int howMany, IDRescorer rescorer) throws TasteException {
        return recommender.recommend(userID, howMany, rescorer);
    }

    @Override
    public float estimatePreference(long userID, long itemID) throws TasteException {
        IDRescorer rescorer = NullRescorer.getItemInstance();
        return (float) rescorer.rescore(itemID, recommender.estimatePreference(userID, itemID));
    }

    @Override
    public void setPreference(long userID, long itemID, float value) throws TasteException {
        recommender.setPreference(userID, itemID, value);
    }

    @Override
    public void removePreference(long userID, long itemID) throws TasteException {
        recommender.removePreference(userID, itemID);
    }

    @Override
    public DataModel getDataModel() {
        return recommender.getDataModel();
    }

    @Override
    public void refresh(Collection<Refreshable> alreadyRefreshed) {
        recommender.refresh(alreadyRefreshed);
    }

    public static File readResourceToTempFile(String resourceName) throws IOException {
        String absoluteResource = resourceName.startsWith("/") ? resourceName : '/' + resourceName;
        InputSupplier<? extends InputStream> inSupplier;
        try {
            URL resourceURL = Resources.getResource(RecMovie.class, absoluteResource);
            inSupplier = Resources.newInputStreamSupplier(resourceURL);
        } catch (IllegalArgumentException iae) {
            File resourceFile = new File(resourceName);
            inSupplier = Files.newInputStreamSupplier(resourceFile);
        }
        File tempFile = File.createTempFile("test", null);
        tempFile.deleteOnExit();
        Files.copy(inSupplier, tempFile);
        return tempFile;
    }
}

//}
