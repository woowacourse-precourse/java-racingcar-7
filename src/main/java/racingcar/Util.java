package racingcar;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static boolean isValidRoundNumber(String roundNumber) {
        try {
            Integer.parseInt(roundNumber);
            return Integer.parseInt(roundNumber) > 0;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean isValidCarNamesInput(String carNames) {
        String regex = "^([\\s\\w\\uAC00-\\uD7A3\\p{Punct}]{1,5})(,(?!$)[\\s\\w\\uAC00-\\uD7A3\\p{Punct}]{1,5})*$|^([\\s\\w\\uAC00-\\uD7A3\\p{Punct}]{1,5})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNames);
        return matcher.matches();
    }

    public static boolean hasDuplicates(String[] carNames) {
        HashSet<String> set = new HashSet<>();
        for (String str : carNames) {
            if (!set.add(str)) {
                return true;
            }
        }
        return false;
    }
}
