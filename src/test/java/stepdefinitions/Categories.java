package stepdefinitions;

import Utils.MyCast;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static HHPages.Categories.allCategoryNames;

public class Categories {
    Actor user = MyCast.user();

    @Then("User verify categories are displayed in alphabetical order")
    public void userVerifyCategoriesAreDisplayedInAlphabeticalOrder() {
        List<String> CategoryNames = allCategoryNames.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedStrings = new ArrayList<>(CategoryNames);
        Collections.sort(sortedStrings);
        user.wasAbleTo(Ensure.that(CategoryNames.equals(sortedStrings)).isTrue());
    }

}
