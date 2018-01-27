package com.prashanna;


import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by Shiva on 15/08/22.
 */
public class Movie {
    public String	title="";
    public String	year="";
    public String	rated="";
    public String	released="";
    public String	runtime="";
    public String	genre="";
    public String	director="";
    public String	writer="";
    public String	actors="";
    public String	plot="";
    public String	language="";
    public String	country="";
    public String	awards="";
    public String	poster="";
    public String	imdbRating="";
    public String	imdbVotes="";
    public String	imdbID="";
    public String	type="";
    public String youtubeurl="";

    public String getYoutubeurl() {
        return youtubeurl;
    }

    public void setYoutubeurl(String youtubeurl) throws Exception {
        this.youtubeurl =getVideoURL();
    }
    //Getter Methods
    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    //public String   videoId="";

    public Movie(String ImdbId) throws Exception {
        Document Xml=ImdbXML.ImdbIdToXMLDom(ImdbId);

        title= ImdbXML.TagFromXML(Xml,"title");
        year= ImdbXML.TagFromXML(Xml,"year");
        rated= ImdbXML.TagFromXML(Xml,"rated");
        released= ImdbXML.TagFromXML(Xml,"released");
        runtime= ImdbXML.TagFromXML(Xml,"runtime");
        genre= ImdbXML.TagFromXML(Xml,"genre");
        director= ImdbXML.TagFromXML(Xml,"director");
        writer= ImdbXML.TagFromXML(Xml,"writer");
        actors= ImdbXML.TagFromXML(Xml,"actors");
        plot= ImdbXML.TagFromXML(Xml,"plot");
        language= ImdbXML.TagFromXML(Xml,"language");
        country= ImdbXML.TagFromXML(Xml,"country");
        awards= ImdbXML.TagFromXML(Xml,"awards");
        poster= ImdbXML.TagFromXML(Xml,"poster");
        imdbRating= ImdbXML.TagFromXML(Xml,"imdbRating");
        imdbVotes= ImdbXML.TagFromXML(Xml,"imdbVotes");
        imdbID= ImdbXML.TagFromXML(Xml,"imdbID");
        type= ImdbXML.TagFromXML(Xml, "type");

        //videoId=Trailer.VideoID(this.title+"+"+this.year);


    }

    public void LongDetail(){
        System.out.println("Title\t:"+this.title);
        System.out.println("Year\t:"+this.year);
        System.out.println("Rated\t:"+this.rated);
        System.out.println("Released\t:"+this.released);
        System.out.println("Runtime\t:"+this.runtime);
        System.out.println("Genre\t:"+this.genre);
        System.out.println("Director\t:"+this.director);
        System.out.println("Writer\t:"+this.writer);
        System.out.println("Actors\t:"+this.actors);

        System.out.println("Plot\t:"+this.plot);
        System.out.println("Language\t:"+this.language);
        System.out.println("Country\t:"+this.country);
        System.out.println("Awards\t:"+this.awards);
        System.out.println("Poster\t:"+this.poster);
        System.out.println("Imdb Rating\t:"+this.imdbRating);
        System.out.println("Imdb Votes\t:"+this.imdbVotes);
        System.out.println("Imdb ID\t:"+this.imdbID);
        System.out.println("Type\t:"+this.type);

        //System.out.println("Youtube VideoId\t:"+this.videoId);
    }

    public String getVideoURL() throws Exception
    {
        return "https://www.youtube.com/embed/"+Trailer.VideoID(this.title+"%20"+this.year);
    }



    //==================================================================//
    //=========

    private static class ImdbXML {

        //
        public static Document ImdbIdToXMLDom(String ImdbId)
                throws Exception
        {
            try {
                String stringXml=ImdbIdToString(ImdbId);
                Document XML=StringToXmlDom(stringXml);
                return XML;
            }
            catch (Exception e) {
                return null;
            }

        }

        //Not Available exception is handled
        public static String TagFromXML(Document XML,String Tag)
                throws Exception
        {
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList) xPath.evaluate("//root/movie/"+"@"+Tag, XML, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node1 = nodes.item(i);
                //System.out.println(node1.getTextContent());
                return node1.getTextContent();
            }
            return "Not Available";
        }

        private static String ImdbIdToString(String ImdbId)
                throws Exception
        {
            try {
                String details = "";
                String parameters = "i=" + ImdbId + "&plot=short&r=xml";
                URL webSite = new URL("http://www.omdbapi.com/?" + parameters);
                URLConnection con = webSite.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    details += inputLine + "\n";
                in.close();

                //display details
                // System.out.print(details);
                return details;
            }
            catch (Exception e)
            {
                //if no net other other problems
                String NullXmlString="<root response=\"True\">\n" +
                        "<movie title=\"-\" year=\"-\" rated=\"-\" released=\"-\" runtime=\"-\" " +
                        "genre=\"-\" director=\"-\" " + "writer=\"-\" actors=\"-\" plot=\"-\" language=\"-\" " +
                        "country=\"-\" awards=\"-\" poster=\"-\" " +
                        "metascore=\"-\" imdbRating=\"-\" imdbVotes=\"-\" imdbID=\"-\" type=\"-\"/>\n" +
                        "</root>";
                return NullXmlString;
            }
        }
        private static Document StringToXmlDom(String xmlSource)
                throws SAXException, ParserConfigurationException, IOException
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlSource)));
        }
    }

    private static class Trailer {

        //Exception is handled
        public static String VideoID(String name)
                throws Exception
        {
            String videoId="";
            try {
                String details="";
                String query=name+"+trailer";
                String authKey="AIzaSyDkLnQHwt1yzbbBGCDni7f_1iQDfC6JVAQ";
                String url="https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&type=video";
                url=url+"&q="+query+"&key="+authKey;
                url=url.replace(' ','_');//replacing the whitespace-space in URL with underscore
                URL webSite = new URL(url);
                System.out.println(url);
                URLConnection con = webSite.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    details+=inputLine+"\n";
                in.close();

                //System.out.print(details);
                JSONObject jsonObject=new JSONObject(details);
                videoId=jsonObject.getJSONArray("items").getJSONObject(0).//first search object
                        getJSONObject("id").getString("videoId");//method on first item object
                //System.out.println(videoId);

                return videoId;
            }
            catch (Exception e)
            {
                return "ErrorVideoId";//here return a video id made by ourself for videos not found or error
            }
        }
    }

}




