package racingcar;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidation {
    private static final Pattern KEYPATTERN = Pattern.compile("^[A-Za-z0-9]{1,5}$");
    private static final Pattern NUMPATTERN = Pattern.compile("^[1-9][0-9]*");

    static boolean isValidKeys(List<String> keys) {
        if (keys.isEmpty()) {
            return false;
        }

        for (String key : keys) {
            if (!KEYPATTERN.matcher(key).matches()) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidNumber(String numInput){
        if (numInput.isEmpty() | !NUMPATTERN.matcher(numInput).matches()) {
            return false;
        }
        return true;
    }
}
