import java.util.regex.*;
import java.util.*;

public class ValidateEmail {
    private Pattern pattern;
    private Matcher matcher;
    public String validateEmailAddress(String emailAddress) {

        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher   = regexPattern.matcher(emailAddress);
        if(regMatcher.matches()) {
            return "Valid Email Address";
        } else {
            return "Invalid Email Address";
        }
    }
    public static void main(String[] args) {

        String emailAddress = "suryaprakash.pisay@gmail.com";
        ValidateEmail validations = new ValidateEmail();
        System.out.println(validations.validateEmailAddress(emailAddress));
    }
}