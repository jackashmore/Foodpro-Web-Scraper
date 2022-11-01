import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author Jack Ashmore
 * @version 10/27/2022
 * 
 *          The Food Scraper class.
 *
 */
public class FoodScraper {

    /**
     * Our main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // write switch cases for the different dining hall's
        // if args[0] is Owens, West End, etc.
        // switch(dining hall name) {
        // case "owens":
        // take in scanner for food i want to check
        // return the
        final String pageUrl =
            "http://foodpro.dsa.vt.edu/menus/MenuAtLocation.aspx?locationNum=09&naFlag=1"; // owens
                                                                                           // url
        WebItem item = new WebItem();
        item.setUrl(pageUrl);
        try {
            final Document doc = Jsoup.connect(pageUrl).get();
//            for (Element row : doc.select("div.card-header")) {
//                if (row.select("div.card-header").text().equals("")) {
//                    continue;
//                }
//                else {
//
//                    final String restNames = row.select("div.card-header")
//                        .text();
////                    System.out.println(restNames);
//
//                }
//            }
//
//            for (Element row : doc.select("div.recipe_title")) {
//                if (row.select("div.recipe_title").text().equals("")) {
//                    continue;
//                }
//                else {
//                    final String foods = row.select("div.recipe_title").text();
////                    System.out.println(foods);
//                }
//            }

            for (Element name : doc.select("[href*=btn]")) {
                String restNames = name.select("[href*=btn]").text();
                System.out.println(restNames);
//            for (Element row : doc.select("[href*=label]")) {
//                if (row.select("[href*=label]").first().text().equals("")) {
//                    continue;
//                }
//                else {
//                    Element links = row.select("[href*=label]").first();
//                    String tags = row.select("[href*=label]").first().text();
//                    String linkAddr = links.absUrl("href");
//                    System.out.println(tags);
//                    System.out.println(linkAddr); // these two print statements
//                                                  // list the food with
//                                                  // associated links for ALL
//                                                  // foods in the dining hall
//                } // MAKE AN IF STATEMENT TO CHECK IF IT'S REACHED A NEW SECTION
//            }
        }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
