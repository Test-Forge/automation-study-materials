import java.util.regex.Pattern;
import java.util.regex.MatchResult;
public class ValidatePhone {
    public static void main(String[] args) {
        // Validate phone number
        boolean isMatch = Pattern.compile("^\\+?[1-9][0-9]{7,14}$")
                .matcher("+12223334444")
                .find(); // returns true

        // Extract a phone number from a string
        String[] matches = Pattern.compile("\\+?[1-9][0-9]{7,14}")
                .matcher("You can reach me out at +12223334444 and +56667778888")
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new); // returns ["+12223334444", "+56667778888"]
    }
}