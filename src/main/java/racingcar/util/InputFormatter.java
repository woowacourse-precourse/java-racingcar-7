package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputFormatter {

    private final static String DELIMITER = ",";

    public static List<String> getFormattedCarNames(String carInput) {
        String[] carNames = carInput.split(DELIMITER);
        List<String> beforeConvertCars = Arrays.stream(carNames).map(String::trim).toList();
        Validator.validateCarNames(beforeConvertCars);
        return beforeConvertCars;
    }

    public static int getFormattedCount(String countInput) {
        Validator.validateCount(countInput);
        return Integer.parseInt(countInput);
    }
}
