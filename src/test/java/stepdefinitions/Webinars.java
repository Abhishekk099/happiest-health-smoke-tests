package stepdefinitions;

import Utils.MyCast;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;


public class Webinars {

    Actor user = MyCast.user();

    private Target imageWarning = Target.the("Image warning").locatedBy("//div[@id='yst_opengraph_image_warning']/p");

    public Target getImageWarning(){
        return imageWarning;
    }


}
