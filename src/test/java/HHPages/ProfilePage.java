package HHPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfilePage extends PageObject {
    public static Target ProfileSection = Target.the("Profile section").located(By.xpath("//li[contains(@class,'MuiListItem-root')]/following::li[@id='profile-happiest-health']"));

    public static Target ProfileIcon = Target.the("Profile Icon").located(By.xpath("//img[@alt='profile-icon']"));

    public static Target RegistrationForm = Target.the("Registration Form").located(By.xpath("//div[@class=\"otpVerified_field__d08c_\"]"));

    public static Target CategoriesIcon = Target.the("Categories Icon").located(By.xpath("//p[text()='Categories']"));

    public static Target InvalidUserMessage = Target.the("Invalid mobile number. Outside India?").located(By.xpath("//p[text()= 'Invalid mobile number. Outside India?']"));

    public static Target EmailId = Target.the("Email ID").located(By.name("email"));

    public static Target UserName = Target.the("User Name").located(By.xpath("//span[contains(text(),'Manju')]"));

    public static Target OTPMessage = Target.the("We have sent OTP Message").located(By.xpath("//span[contains(text(),'We have sent the OTP')]"));

    public static Target GetOTP = Target.the("Get OTP button Enable").located(By.xpath("//button[text()='Get OTP']"));

    public static Target CheckBox = Target.the("Accept check box").located(By.name("consent-checkbox"));
}
