package test;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import stepdefinitions.UrlVerificationSteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class UrlVerificationTest {

    @Steps
    UrlVerificationSteps urlVerificationSteps;


    @Test
    public void testUrlVerification() throws IOException {
        urlVerificationSteps.verifyUrlsFromExcel();
    }
}