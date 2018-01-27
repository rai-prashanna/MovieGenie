package com.prashanna;

/**
 *
 * @author prashanna
 */
import com.prashanna.mahout_webservice.RatingModel;
import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.common.*;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.PlusAnonymousUserDataModel;
import org.apache.mahout.cf.taste.impl.recommender.NullRescorer;
import org.apache.mahout.cf.taste.recommender.IDRescorer;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

//------------------------this is under construction............... 
//   ---------------------   by LORD PRASHANNA

public class RecMovieAnonymous extends RecMovie {

    private final PlusAnonymousUserDataModel plusAnonymousModel;
    public static final long TEMP_USER_ID = Long.MIN_VALUE;
    private PreferenceArray tempPrefs;

    public RecMovieAnonymous() throws IOException, TasteException {
      // this(new FileDataModel(readResourceToTempFile("movies.csv")));
        this(new FileDataModel(readResourceToTempFile("movies.csv")));
  
    }
    
    public RecMovieAnonymous(DataModel model) throws TasteException, IOException{
         super(new PlusAnonymousUserDataModel(model));
        plusAnonymousModel =(PlusAnonymousUserDataModel) getDataModel();
        
    }
//    
//    @Override
//    public List<RecommendedItem> recommend(long userID, int howMany) throws TasteException {
//        IDRescorer rescorer = NullRescorer.getItemInstance();
//        return recommender.recommend(userID, howMany, rescorer);
//    }
//
//    @Override
//    public List<RecommendedItem> recommend(long userID, int howMany, IDRescorer rescorer) throws TasteException {
//        List<RecommendedItem> recommendations=null;
//        try {
//            //return recommender.recommend(userID, howMany, rescorer);
//            recommendations= this.recommend(SetAnonymousUserpreference() , howMany);
//        } catch (IOException ex) {
//            Logger.getLogger(RecMovieAnonymous.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return recommendations;
//    }

    public synchronized List<RecommendedItem> recommend(
            PreferenceArray anonymousUserPrefs, int howMany)
            throws TasteException {
        plusAnonymousModel.setTempPrefs(anonymousUserPrefs);
        List<RecommendedItem> recommendations = recommend(PlusAnonymousUserDataModel.TEMP_USER_ID, howMany,null);
        plusAnonymousModel.clearTempPrefs();
        return recommendations;

    }
    public static PreferenceArray SetAnonymousUserpreference(List<RatingModel> list) throws IOException{
        
            PreferenceArray anonymousPrefs
                    = new GenericUserPreferenceArray(list.size());
            anonymousPrefs.setUserID(0,TEMP_USER_ID);
            for (int i = 0; i < list.size(); i++) {
            RatingModel rmodel = list.get(i);
            anonymousPrefs.setItemID(i,rmodel.getMovieID());
            anonymousPrefs.setValue(i, rmodel.getRating());
            
        }
            
            return anonymousPrefs; 
//PreferenceArray anonymousPrefs
//                    = new GenericUserPreferenceArray(5);
//            anonymousPrefs.setUserID(0,TEMP_USER_ID);
//            anonymousPrefs.setItemID(0, 217L);
//            anonymousPrefs.setValue(0, 5f);
//            anonymousPrefs.setItemID(1, 127L);
//            anonymousPrefs.setValue(1, 4.0f);
//            anonymousPrefs.setItemID(2, 184L);
//            anonymousPrefs.setValue(2, 3.0f);
//            anonymousPrefs.setItemID(3, 507L);
//            anonymousPrefs.setValue(3, 4.0f);
//            anonymousPrefs.setItemID(4, 350L);
//            anonymousPrefs.setValue(4, 4.0f);
//            return anonymousPrefs; 
    }
    
//    public static void main(String[] args) throws IOException, TasteException {
//        RecMovieAnonymous recAno=new RecMovieAnonymous();
//        List<RecommendedItem> recommendedItems=recAno.recommend(SetAnonymousUserpreference(), 9);
//        System.out.println(recommendedItems);
//    }
   
}
