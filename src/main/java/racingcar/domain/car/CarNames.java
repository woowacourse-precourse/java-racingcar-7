package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.Constant;
import racingcar.exception.ErrorMessage;

public class CarNames {
    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = new ArrayList<>(carNames);
    }

    public static CarNames from(String input) {
        validateInputBlank(input);
        String[] names = getNames(input);
        for (String name : names) {
            validateNameBlank(name);
            validateNameTooLong(name);
        }
        validateDuplicatedName(names);
        return new CarNames(Arrays.asList(names));
    }

    private static void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_CAR_NAME_INPUT.getMessage());
        }
    }

    private static void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_CAR_NAME.getMessage());
        }
    }

    private static void validateNameTooLong(String name) {
        if (name.length() > Constant.CAR_NAME_LENGTH_CRITERIA) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LONG_CAR_NAME.getMessage());
        }
    }

    private static void validateDuplicatedName(String[] names) {
        Set<String> cars = new HashSet<>(Arrays.asList(names));
        if (cars.size() != names.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private static String[] getNames(String input) {
        String[] names = input.split(Constant.DELIMITER);
        Arrays.setAll(names, i -> names[i].trim());
        return names;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
