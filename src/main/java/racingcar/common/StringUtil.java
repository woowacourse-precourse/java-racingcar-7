package racingcar.common;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private static final String DELIMITER = ",";

    public static List<String> splitByComma(String string) {
        return Arrays.stream(string.split(DELIMITER))
                .peek(s -> StringSizeValidator.checkLimitedSize(s,5))
                .peek(StringSizeValidator::checkBlank)
                .toList();
    }

    public static long parseToNumeric(String secondLine) {
        try {
            BigInteger bigInt = new BigInteger(secondLine);
            validateIsLong(secondLine, bigInt);
            return bigInt.longValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid number format: " + secondLine);
        }
    }

    private static void validateIsLong(String secondLine, BigInteger bigInt) {
        if (!(bigInt.compareTo(BigInteger.valueOf((Long.MIN_VALUE))) > 0
                && bigInt.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) < 0)) {
            throw new IllegalArgumentException("number out of range for type long: " + secondLine);
        }
    }

}
