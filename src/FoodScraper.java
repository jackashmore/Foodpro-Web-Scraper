import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Jack Ashmore
 * @version 11/2/2022
 * 
 *          The Food Scraper class. User inputs a dining hall name and a food
 *          name for an item found in the dining hall. Opens a web page in the
 *          user's default browser with the nutrition info for the item.
 *
 */
public class FoodScraper {

    /**
     * The main method. Takes in an input for a dining hall and then a food.
     * 
     * @param args
     *            Our string argument (none for my case)
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean wrongInput;
        String pageUrl = "";
        Desktop browser = Desktop.getDesktop();

        do {
            wrongInput = false;
            System.out.println("Enter a dining hall name: ");
            String dHallName = input.nextLine().toLowerCase();
            switch (dHallName) {
                case "owens":
                    pageUrl =
                        "https://foodpro.dsa.vt.edu/menus/MenuAtLocation.aspx?locationNum=09&naFlag=1";
                    break;
                case "west end":
                    pageUrl =
                        "https://foodpro.students.vt.edu/menus/MenuAtLocation.aspx?locationNum=16&naFlag=1";
                    break;
                case "burger 37":
                    pageUrl =
                        "https://foodpro.students.vt.edu/menus/MenuAtLocation.aspx?locationNum=18&naFlag=1";
                    break;
                case "deets":
                case "dx":
                    pageUrl =
                        "https://foodpro.students.vt.edu/menus/MenuAtLocation.aspx?locationNum=07&naFlag=1";
                    break;
                case "turner":
                    pageUrl =
                        "https://foodpro.students.vt.edu/menus/MenuAtLocation.aspx?locationNum=14&naFlag=1";
                    break;
                default:
                    System.out.println(
                        "Please enter a valid dining hall name.");
                    wrongInput = true;
            }

        }
        while (wrongInput);

        try {
            final Document doc = Jsoup.connect(pageUrl).get();
            Map<String, String> foodMap = new TreeMap<>(
                String.CASE_INSENSITIVE_ORDER);

            for (Element label : doc.select("[href*=label]")) {
                if (label.select("[href*=label]").first().text().equals("")) {
                    continue;
                }
                else {
                    Element links = label.select("[href*=label]").first();
                    String foodName = label.select("[href*=label]").first()
                        .text().toLowerCase();
                    String linkAddr = links.absUrl("href");
                    foodMap.put(foodName, linkAddr);
                }
            }

            wrongInput = false;
            String link;
            do {
                System.out.println("Enter the name of a food: ");
                String food = input.nextLine().toLowerCase();
                link = findPartial(foodMap, food);
                try {
                    if (!link.equals(null)) {
                        break;
                    }
                }
                catch (NullPointerException e) {
                    System.out.println("Please enter a valid food name.");
                    wrongInput = true;
                }

            }

            while (wrongInput);

            browser.browse(new URI(link));
            input.close();
            System.exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }


    /**
     * Returns a value for a partial key in a map given a prefix.
     * 
     * @param map
     *            The map to iterate through.
     * @param pre
     *            The prefix or partial key.
     * @return The value, if it exists.
     */
    public static String findPartial(Map<String, String> map, String pre) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> e = it.next();
            String key = e.getKey();
            if (key.startsWith(pre)) {
                return e.getValue();
            }
            if (key.compareTo(pre) > 0) {
                return null;
            }
        }
        return null;
    }
}
