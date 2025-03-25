package stepdefinitions;

import GenericPage.UrlVerificationPage;
import Utils.ExcelUtility;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.util.List;

public class UrlVerificationSteps {
    UrlVerificationPage urlVerificationPage;
    ExcelUtility excelUtility = new ExcelUtility("src/test/resources/urls.xlsx"); // Path to Excel file

    @Given("Verify URLs from Excel and update status")
    public void verifyUrlsFromExcel() throws IOException {
        List<String> urls = excelUtility.readUrls();
        for (int i = 0; i < urls.size(); i++) {
            boolean isAccessible = urlVerificationPage.verifyUrl(urls.get(i));
            excelUtility.updateStatus(i, isAccessible ? "PASS" : "FAIL");
        }
    }
}