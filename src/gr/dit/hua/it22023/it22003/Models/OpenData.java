package gr.dit.hua.it22023.it22003.Models;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.dit.hua.it22023.it22003.Controler;
import gr.dit.hua.it22023.it22003.Models.weather.OpenWeatherMap;
import gr.dit.hua.it22023.it22003.Models.wikipedia.MediaWiki;

import java.io.IOException;
import java.net.URL;

/**City description and weather information using OpenData with Jackson JSON processor.
* @since 29-2-2020
* @version 1.0
* @author John Violos */
public class OpenData {

/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
* @param city The Wikipedia article and OpenWeatherMap city. 
* @param country The country initials (i.e. gr, it, de).
* @param appid Your API key of the OpenWeatherMap.*/ 
  public static City RetrieveData(String city, String country, String appid) throws IOException {
        double[] features = new double[9];
        ObjectMapper mapper = new ObjectMapper();
        OpenWeatherMap weather_obj = (OpenWeatherMap)mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&APPID=" + appid), OpenWeatherMap.class);
        features[7] = weather_obj.getMain().getTemp();
        features[8] = (double)weather_obj.getClouds().getAll();
        MediaWiki mediaWiki_obj = (MediaWiki)mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles=" + city + "&format=json&formatversion=2"), MediaWiki.class);
//	 System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
        return new City(city, features, weather_obj.getCoord().getLat(), weather_obj.getCoord().getLon());
    }
public static void main(String[] args) throws IOException {
//	String appid ="217d0917e9cae78fdb32d8e85bfa0e4b";
//	RetrieveData("Rome","it",appid);
//	RetrieveData("Athens","gr",appid);
//	RetrieveData("New York","ny",appid);
//	RetrieveData("London","uk",appid);
}

/** Counts the number of times a criterion occurs in the city wikipedia article.
 @param cityArticle  The String of the retrieved wikipedia article.
 @param criterion The String of the criterion we are looking for.
 @return An integer, the number of times the criterion-string occurs in the wikipedia article.
 */
public static int countCriterionfCity(String cityArticle, String criterion) {
	cityArticle=cityArticle.toLowerCase();
	int index = cityArticle.indexOf(criterion);
	int count = 0;
	while (index != -1) {
		count++;
		cityArticle = cityArticle.substring(index + 1);
		index = cityArticle.indexOf(criterion);
	}
	return count;
}

}