package gr.dit.hua.it22023.it22003.Models.OpenData;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Models.OpenData.weather.OpenWeatherMap;
import gr.dit.hua.it22023.it22003.Models.OpenData.wikipedia.MediaWiki;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * City description and weather information using OpenData with Jackson JSON processor.
 *
 * @author John Violos
 * @version 1.0
 * @since 29-2-2020
 */
public class OpenData
{
    
    /**
     * Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
     *  @param city    The Wikipedia article and OpenWeatherMap city.
     * @param country The country initials (i.e. gr, it, de).
     * @param appid   Your API key of the OpenWeatherMap.
     */
    public static void RetrieveData(String city , String country , String appid) throws IOException
    {
        Date date = new Date();
        
        double[] features = new double[9];
        
        ObjectMapper mapper = new ObjectMapper();
        OpenWeatherMap weather_obj = mapper.readValue(new URL(
                "http://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "," +
                country +
                "&APPID=" +
                appid) , OpenWeatherMap.class);
        
        features[7] = weather_obj.getMain().getTemp();
        features[8] = (double) weather_obj.getClouds().getAll();
        
        MediaWiki mediaWiki_obj = mapper.readValue(new URL(
                "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles=" +
                city +
                "&format=json&formatversion=2") , MediaWiki.class);
        String article = mediaWiki_obj.getQuery().getPages().get(0).getExtract();
    
        for (int i = 0; i < Utils.criteria.length; i++)
        {
            features[i] = countCriterionCity(article , Utils.criteria[i]);
        }
    
        new City(city , features , weather_obj.getCoord().getLat() , weather_obj.getCoord().getLon() , date);
    }
    
    /**
     * Counts the number of times a criterion occurs in the city wikipedia article.
     *
     * @param cityArticle The String of the retrieved wikipedia article.
     * @param criterion   The String of the criterion we are looking for.
     * @return An integer, the number of times the criterion-string occurs in the wikipedia article.
     */
    public static int countCriterionCity(String cityArticle , String criterion)
    {
        cityArticle = cityArticle.toLowerCase();
        int index = cityArticle.indexOf(criterion);
        int count = 0;
        while (index != - 1)
        {
            count++;
            cityArticle = cityArticle.substring(index + 1);
            index       = cityArticle.indexOf(criterion);
        }
        return count;
    }
    
}