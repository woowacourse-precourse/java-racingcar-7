package racingcar.validator;

import java.util.List;

public class CarNamesValidator {
    protected static void isValidLength(List<String> tokens) {
        // test
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("Invalid car name length: length = 0");
            }
            if (token.length() > 5) {
                throw new IllegalArgumentException("Invalid car name length: length > 5");
            }
        }
    }
    protected static List<String> separate(String userResponse) {
        // separate by comma
        return List.of(userResponse.split("[,]"));
    }
    public static List<String> isCarNamesValid(String userResponse) {
        List<String> tokens = separate(userResponse);
        /*
        Debugging printing
        System.out.println(tokens);
        System.out.println(tokens.size());
         */
        isValidLength(tokens);
        return tokens;
    }
}
