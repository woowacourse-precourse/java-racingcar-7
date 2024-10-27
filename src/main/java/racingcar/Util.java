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

    public static void throwExceptionInputIsNotValid(String carNames, String round, String[] splitCarNames) {
        if (Util.isValidCarNamesInput(carNames) && Util.isValidRoundNumber(round)) {
            if (Util.hasDuplicates(splitCarNames)) {
                throw new IllegalArgumentException("입력한 자동차 이름에 중복이 있습니다.");
            }
        } else {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
