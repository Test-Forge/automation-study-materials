import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateNumbers {
    public static void main(String[] args) {

        String inputStr = "abc00123xyz456_0";  // Input String for matching
        String regexStr = "[0-9]+";            // Regex to be matched

        // Step 1: Compile a regex via static method Pattern.compile(), default is case-sensitive
        Pattern pattern = Pattern.compile(regexStr);
        // Pattern.compile(regex, Pattern.CASE_INSENSITIVE);  // for case-insensitive matching

        // Step 2: Allocate a matching engine from the compiled regex pattern,
        //         and bind to the input string
        Matcher matcher = pattern.matcher(inputStr);

        // Step 3: Perform matching and Process the matching results
        // Try Matcher.find(), which finds the next match
        while (matcher.find()) {
            System.out.println("find() found substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
        }

        // Try Matcher.matches(), which tries to match the ENTIRE input (^...$)
        if (matcher.matches()) {
            System.out.println("matches() found substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
        } else {
            System.out.println("matches() found nothing");
        }

        // Try Matcher.lookingAt(), which tries to match from the START of the input (^...)
        if (matcher.lookingAt()) {
            System.out.println("lookingAt() found substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
        } else {
            System.out.println("lookingAt() found nothing");
        }

        // Try Matcher.replaceFirst(), which replaces the first match
        String replacementStr = "**";
        String outputStr = matcher.replaceFirst(replacementStr); // first match only
        System.out.println(outputStr);

        // Try Matcher.replaceAll(), which replaces all matches
        replacementStr = "++";
        outputStr = matcher.replaceAll(replacementStr); // all matches
        System.out.println(outputStr);
    }
}