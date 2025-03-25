package stepdefinitions;

import Utils.MyCast;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import Actions.*;

import static Utils.CommonUtils.moveToElement;
import static net.serenitybdd.core.Serenity.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static stepdefinitions.BasePage.*;


public class CMSCommonSteps {

    Actor user = MyCast.user();
    static String imgSrcForFeaturedImage = "";
    static String imgSrcForAuthorImage = "";
    static String dateTimeMonthYear = "";
    static String imgSrcForVideoThumbnail="";

    @And("User click on {string} trash button")
    public void userClickOnTrashButton(String title) {
        System.out.println("(//a[text()='" + title + "'])[1]/following::a[text()='Trash'][1]");
        WebDriver driver = getDriver();
        WebElement Title = driver.findElement(By.linkText(title));
        moveToElement(driver,Title);
        WebElement Trash = driver.findElement(By.xpath("(//a[text()='" + title + "'])[1]/following::a[text()='Trash'][1]"));
        moveToElement(driver,Trash);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Trash);
    }
   	@And("User click on {string} edit button")
    public void userClickOneditButton(String title) {
        System.out.println("(//a[text()='" + title + "'])[1]/following::a[text()='Edit'][1]");
        WebDriver driver = getDriver();
        WebElement Title = driver.findElement(By.linkText(title));
        moveToElement(driver,Title);
        WebElement Edit = driver.findElement(By.xpath("(//a[text()='" + title + "'])[1]/following::a[text()='Edit'][1]"));
        moveToElement(driver,Edit);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Edit);
    }
    @And("User stores and clicks the img url of first image in Media Library for featured image")
    public void userStoresAndClicksTheImgUrlOfFirstImageInMediaLibraryForFeaturedImage() {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='attachments-wrapper'])[1]//div[@class='thumbnail']//img")));
        for (WebElement element: list) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
            WebElement Select = driver.findElement(By.xpath("//button[normalize-space(text())='Set featured image']"));
            if (Select.isEnabled()) {
                imgSrcForFeaturedImage = element.getAttribute("src");
                System.out.println("img src : " + imgSrcForFeaturedImage);
                break;
            }
        }

    }

    @And("User checks if image warning comes then again select another image")
    public void userChecksIfImageWarningComesThenAgainSelectAnotherImage() {
        boolean warningDisplayed;
        Webinars webinars = new Webinars();
        try{
            user.wasAbleTo(Ensure.that(webinars.getImageWarning()).isDisplayed());
            warningDisplayed = true;
        }catch (NoSuchElementException | TimeoutException e){
            warningDisplayed =false;
        }
        int count = 1;
        while (warningDisplayed){
            user.wasAbleTo(Click.on(By.linkText("Remove featured image")));
            user.wasAbleTo(Click.on(By.linkText("Set featured image")));
            WebDriver driver = Serenity.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='attachments-wrapper'])[1]//div[@class='thumbnail']//img")));
            for (int i=count;i<list.size();i++) {
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].click();", list.get(i));
                WebElement Select = driver.findElement(By.xpath("//button[normalize-space(text())='Set featured image']"));
                if (Select.isEnabled()) {
                    imgSrcForFeaturedImage = list.get(i).getAttribute("src");
                    System.out.println("img src : " + imgSrcForFeaturedImage);
                    break;
                }
            }
            user.wasAbleTo(ClickOn.buttonUsingButtonText("Set featured image"));

            if (webinars.getImageWarning().isVisibleFor(user)) {
                count++;
            }else {
                warningDisplayed =false;
            }
        }
    }
    
     @And("User stores and clicks the img url of first image in Media Library for select image")
    public  void userStoresAndClicksTheImgUrlOfFirstImageInMediaLibraryForSelectImage() {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='attachments-wrapper'])[2]//div[@class='thumbnail']//img")));
        for (WebElement element: list) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
            WebElement Select = driver.findElement(By.xpath("//button[normalize-space(text())='Select']"));
            if (Select.isEnabled()) {
                imgSrcForFeaturedImage = element.getAttribute("src");
                System.out.println("img src : " + imgSrcForFeaturedImage);
                break;
            }
        }
    }
    
    
    @And("User stores and clicks the img url of first image in Media Library for author pic for {string}")
    public  void userStoresAndClicksTheImgUrlOfFirstImageInMediaLibraryForAuthorPicFor(String name) {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='attachments-wrapper'])[1]//div[@class='thumbnail']//img")));
        for (WebElement element: list) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
            WebElement Select = driver.findElement(By.xpath("//button[normalize-space(text())='"+name+"']"));
            if (Select.isEnabled()) {
                imgSrcForFeaturedImage = element.getAttribute("src");
                System.out.println("img src : " + imgSrcForFeaturedImage);
                break;
            }
        }
    }

    @Then("User validate img src of image with {string} title for webinar and video")
    public void userValidateImgSrcOfImageWithTitleForWebinarAndVideo(String title) {
        WebDriver driver = Serenity.getDriver();
        WebElement image = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]/preceding::img[2]"));
        assertThat("image is not displayed ", image.isDisplayed());
        String actualImgSrc = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]/preceding::img[2]")).getAttribute("src");
        String expectedImgSrc = imgSrcForFeaturedImage;
        System.out.println("Actual image src: " + actualImgSrc);
        System.out.println("Expected image src: " + expectedImgSrc);
        assertThat("img src is not same of content of CMS and website", actualImgSrc.equalsIgnoreCase(expectedImgSrc));
    }

    @Then("User validate img src of image with {string} title")
    public void userValidateImgSrcOfImageWithTitle(String title) {
        WebDriver driver = Serenity.getDriver();
        WebElement image = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]/preceding::img[1]"));
        assertThat("image is not displayed ", image.isDisplayed());
        String actualImgSrc = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]/preceding::img[1]")).getAttribute("src");
        String expectedImgSrc = imgSrcForFeaturedImage;
        System.out.println("Actual image src: " + actualImgSrc);
        System.out.println("Expected image src: " + expectedImgSrc);
        assertThat("img src is not same of content of CMS and website", actualImgSrc.equalsIgnoreCase(expectedImgSrc));
    }

    @And("User stores and clicks the img url of first image in Media Library for author pic")
    public void userStoresAndClicksTheImgUrlOfFirstImageInMediaLibraryForAuthorPic() {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='attachments-wrapper'])[2]//div[@class='thumbnail']//img")));
        for (WebElement element: list) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
            WebElement Select = driver.findElement(By.xpath("//button[normalize-space(text())='Select']"));
            if (Select.isEnabled()) {
                imgSrcForAuthorImage = element.getAttribute("src");
                System.out.println("img src : " + imgSrcForAuthorImage);
                break;
            }
        }
    }








    @Then("User enters {string} in {string} textarea field")
    public void userEntersInTextareaField(String text, String label) {
        user.wasAbleTo(EnterValueInto.theGivenTextAreaField(text,label));
    }

    @And("User clicks on {string} input field")
    public void userClicksOnInputField(String label) {
        user.wasAbleTo(ClickOn.theGivenInputField(label));
    }




    @And("User selects date month year in {string} {string} {string} format and time value {string} from date picker")
    public void userSelectsDateMonthYearInFormatAndTimeValueFromDatePicker(String dateFormat, String monthFormat, String yearFormat, String timeValue) {
        WebDriver driver = Serenity.getDriver();
        String currentDate = getCurrentDate(dateFormat);
        WebElement selectMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        WebElement selectYear = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        WebElement selectDate = driver.findElement(By.xpath("//a[normalize-space()='" + currentDate + "']"));
        String currentMonth = getCurrentMonth(monthFormat.toUpperCase());
        String currentYear = getCurrentYear(yearFormat.toUpperCase());

        Select select = new Select(selectMonth);
        select.selectByVisibleText(currentMonth);

        select = new Select(selectYear);
        select.selectByVisibleText(currentYear);

        selectDate.click();

        WebElement selectTime = driver.findElement(By.xpath("//select[@data-unit='hour']"));
        select = new Select(selectTime);
        select.selectByVisibleText(timeValue);
    }

    @And("User stores data of {string} input field")
    public void userStoresDataOfInputField(String label) {
        WebDriver driver = Serenity.getDriver();
        WebElement inputField = driver.findElement(By.xpath("//label[normalize-space(text())='" + label + "']/parent::div/following-sibling::*//input"));
        dateTimeMonthYear = inputField.getText();
    }

    @And("User selects the option which comes after entering speaker name")
    public void userSelectsTheOptionWhichComesAfterEnteringSpeakerName() {
        WebDriver driver = Serenity.getDriver();
        WebElement option = driver.findElement(By.xpath("//span[@class='acf-selection']"));
        option.click();
    }

    @And("User clicks on {string} link of {string} label")
    public void userClicksOnLinkOfLabel(String linkName, String label) {
        WebDriver driver = Serenity.getDriver();
        WebElement link = driver.findElement(By.xpath("//*[normalize-space(text())='Speaker Photo']/following::a[normalize-space(text())='Add Image']"));
        link.click();
    }



    @And("User hit enter key after entering webinar speaker")
    public void userHitEnterKeyAfterEnteringWebinarSpeaker() throws InterruptedException {
        WebDriver driver = Serenity.getDriver();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[normalize-space(text())='Speakers']/parent::div/following-sibling::*//input[not(@type='hidden')]")).sendKeys(Keys.ENTER);
    }

    @And("User enters values in {string} input field")
    public void userEntersValuesInInputField(String label, DataTable dt) throws InterruptedException {
        List<String> values = dt.asList(String.class);
        WebDriver driver = Serenity.getDriver();
        WebElement WebinarSpeakerField = driver.findElement(By.xpath("//label[normalize-space(text())='" + label + "']/parent::div/following-sibling::*//input[not(@type='hidden')]"));
        for (String value: values){
            WebinarSpeakerField.sendKeys(value);
            Thread.sleep(3000);
            WebinarSpeakerField.sendKeys(Keys.ENTER);
        }
    }
    @And("User selects {string} checkbox in CMS page")
    public void userSelectsCheckboxInCMSPage(String CheckBoxValue) {
        user.attemptsTo(ClickOn.theWebminarCheckbox(CheckBoxValue));
    }

    @And("User clicks on {string} link with {string} label")
    public void userClicksOnLinkWithLabel( String linkName, String label) {
        user.wasAbleTo(ClickOn.linkWithLinkNameAndLabel(linkName,label));
    }
    
     @Then("User add Hyperlink {string} in content")
    public void userAddHyperlinkInContent(String Hyperlink) throws InterruptedException {
        user.attemptsTo(ClickOn.addLinkButtonInContent());
        WebDriver driver = Serenity.getDriver();

        WebElement e = driver.findElement(By.xpath("//input[@class='ui-autocomplete-input']"));
        e.click();
        e.sendKeys(Hyperlink);
        e.sendKeys(Keys.ENTER);


    }
    
    @And("User clicks on view post link")
    public void userClicksOnViewPostLink() {
        user.attemptsTo(ClickOn.viewPostLink());
    }

    @And("User stores and clicks the img url of first image in Media Library for Video thumbnail pic")
    public void userStoresAndClicksTheImgUrlOfFirstImageInMediaLibraryForVideoThumbnailPic() {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@class='attachments-wrapper'])[2]//div[@class='thumbnail']//img")));
        for (WebElement element: list) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
            WebElement Select = driver.findElement(By.xpath("//button[normalize-space(text())='Select']"));
            if (Select.isEnabled()) {
                imgSrcForVideoThumbnail = element.getAttribute("src");
                System.out.println("img src : " + imgSrcForVideoThumbnail);
                break;
            }
        }
    }

    @And("User clicks on {string} Add New Post")
    public void userClicksOnAddNewPost(String contentName) {
        user.wasAbleTo(ClickOn.ContentAddNewPost(contentName));
    }
}
