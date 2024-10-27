package racingcar.global.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.global.message.ErrorMessage;

public class ParseStringUtils {
    private ParseStringUtils() {
        // 인스턴스화 방지
    }

    public static List<String> splitCarNames(String carNamesInput) {
        if (carNamesInput.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessage.CONSECUTIVE_COMMAS.getMessage());
        }

        String[] carNamesArray = carNamesInput.split(",");
        List<String> carNamesList = new ArrayList<>();
        for (String name : carNamesArray) {
            validateName(name);
            addValidatedName(carNamesList, name);
        }

        return carNamesList;
    }

    private static void validateName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void addValidatedName(List<String> carNamesList, String name) {
        String trimmedName = name.trim();
        carNamesList.add(trimmedName);
    }


}
