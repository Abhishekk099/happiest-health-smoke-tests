package Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Random;

import static HHPages.HHEvolutionPage.ViewPhotoGallery;

public class FetchOTP {

    public static String generateOTP(int length) {
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        return otp.toString();
    }

    public static void main(String[] args) {
        int otpLength = 6; // Length of the OTP
        String otp = generateOTP(otpLength);
        System.out.println("Generated OTP: " + otp);
    }

    public static Performable fromCognitoForLogin() {
        return Task.where("Clicks on the view Photo Gallery ",
                Click.on(ViewPhotoGallery));
    }
}