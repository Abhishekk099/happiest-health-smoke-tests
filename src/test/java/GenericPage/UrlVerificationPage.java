package GenericPage;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlVerificationPage extends PageObject {
    private static final Logger log = LoggerFactory.getLogger(UrlVerificationPage.class);

    public boolean verifyUrl(String url) {
        try{
            getDriver().get(url);
            System.out.println(waitFor(ExpectedConditions.urlToBe(url)));
            try{
                String header=getDriver().findElement(By.xpath("//body//h1")).getText();
                if(header.contains("error")){
                    return false;
                }else { return true;}

            }
            catch(Exception e){
                log.error("e: ", e);
                return false;
            }}
        catch(Exception x){
            log.error("e: ", x);
            return false;
        }

    }
}