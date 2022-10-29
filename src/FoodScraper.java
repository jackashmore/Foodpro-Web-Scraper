import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * @author Jack Ashmore
 * @version 10/27/2022
 * 
 * The Food Scraper class. 
 *
 */
public class FoodScraper {
    
    /**
     * Our main method
     * @param args
     */
    public static void main(String[] args) {
        // write switch cases for the different dining hall's
        // if args[0] is Owens, West End, etc.
        // switch(dining hall name) {
        // case "owens":
        // take in scanner for food i want to check
        // return the
        final String pageUrl = "http://foodpro.dsa.vt.edu/menus/MenuAtLocation.aspx?locationNum=09&naFlag=1"; // owens url
        WebItem item = new WebItem();
        item.setUrl(pageUrl);
        try {
            final Document doc = Jsoup.connect(pageUrl).get();
            for (Element row : doc.select("div.card-header")) {
                if (row.select("div.card-header").text().equals("")) {
                    continue;
                }
                else {
                    
                    final String restNames = row.select("div.card-header").text();
                    System.out.println(restNames);
                    
                    
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
