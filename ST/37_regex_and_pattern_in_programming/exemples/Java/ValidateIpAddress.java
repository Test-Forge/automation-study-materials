import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.Arrays;
public class ValidateIpAddress {
    public static void main(String[] args) {
        // Validate if a string is an IPv4 address
        boolean isMatch = Pattern.compile("^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")
                .matcher("192.168.0.1")
                .find();
        System.out.println(isMatch); // prints true

        // Extract IPv4 addresses from a string
        String[] matches = Pattern.compile("(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")
                .matcher("My server IP addresses are 192.168.0.1 and 192.168.0.2")
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(matches)); // prints [192.168.0.1, 192.168.0.2]
    }
}