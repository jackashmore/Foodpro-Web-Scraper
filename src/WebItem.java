
/**
 * @author Jack Ashmore
 * @version 10/27/2022
 * 
 * The WebItem class. Stores different info about the items I'm scraping.
 *
 */
public class WebItem {
    private String diningHallName;
    private String foodName;
    private String pageUrl;
    
    public WebItem() {
        diningHallName = null;
        foodName = null;
        pageUrl = null;
    }
    /**
     * Returns the dining hall name.
     * @return The dining hall name
     */
    public String getDHallName() {
        return diningHallName;
    }
    
    /**
     * Sets the dining hall name.
     * @param name The new name to set
     */
    public void setDHallName(String name) {
        diningHallName = name;
    }
    
    /**
     * Returns the name of the food.
     * @return The food name
     */
    public String getFoodName() {
        return foodName;
    }
    
    /**
     * Sets the food name.
     * @param name The new name to set.
     */
    public void setFoodName(String name) {
        foodName = name;
    }
    
    /**
     * Returns the page URL.
     * @return The URL
     */
    public String getUrl() {
        return pageUrl;
    }
    
    /**
     * Sets the page URL.
     * @param url The URL to set
     */
    public void setUrl(String url) {
        pageUrl = url;
    }
}
