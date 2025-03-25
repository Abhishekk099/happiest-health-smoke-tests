package Utils;

import org.assertj.core.api.Assertions;

import java.util.List;

import static stepdefinitions.BasePage.getBreadCrumbElementNameList;

public class GenericLibrary {

    public static boolean assertBreadcrumbTextWithExpectedBreadcrumbText(String expectedText, String title) {
        List<String> breadcrumbELementList = getBreadCrumbElementNameList();
        System.out.println("breadcrumb list : " + breadcrumbELementList);
        StringBuilder actualBreadcrumb = new StringBuilder();
        for (int i=0;i<breadcrumbELementList.size();i++){
            if (i==0){
                actualBreadcrumb.append(breadcrumbELementList.get(i));
            }else {
                actualBreadcrumb.append(">").append(breadcrumbELementList.get(i));
            }
        }
        actualBreadcrumb.append(">").append(title);
        String resultString = actualBreadcrumb.toString();
        System.out.println("Actual string "+ resultString);
        System.out.println("Expected string " + expectedText);
        try {
            Assertions.assertThat(resultString).isEqualTo(expectedText);
            return true;
        }catch (AssertionError e){
            return false;
        }
    }
}
