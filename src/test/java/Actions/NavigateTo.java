package Actions;

import CMSPages.CMSLoginPage;
import HHPages.HHAAEAdminLaunchPage;
import HHPages.HHEvolutionLaunchPage;
import HHPages.HHLandingPage;
import HHPages.HHVideoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theHHLandingPage() {
        return Task.where("{0} navigates to the Happiest Health Page",
                Open.browserOn().the(HHLandingPage.class));
    }
    public static Performable theHHVideoPage() {
        return Task.where("{0} navigates to video page",
                Open.browserOn().the(HHVideoPage.class));
    }

    public static Performable theHHEvolutionPage(){
        return Task.where("{0} navigates to evolution page",
                Open.browserOn().the(HHEvolutionLaunchPage.class));
    }

    public static Performable theHHAAEAdminPage(){
        return Task.where("{0} navigates to Ask an expert Admin page",
                Open.browserOn().the(HHAAEAdminLaunchPage.class));
    }
    public static Performable theCMSLoginPage() {
        return Task.where("{0} login to CMS login page",
                Open.browserOn().the(CMSLoginPage.class));
    }
}