package HHPages;


import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Categories {

    public static List<WebElement> allCategoryNames = Serenity.getDriver().findElements(By.xpath("(//div[contains(@class,'elementor-hidden-mobile')]//div[@class='elementor-shortcode'])[1]//span[@class='sho-category-name']"));
}
