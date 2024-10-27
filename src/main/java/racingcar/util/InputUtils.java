package racingcar.util;

import static racingcar.util.Constant.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class InputUtils {
    public static List<Car> createCarListFromInput(String NameInput) {
        validateCarNamesInput(NameInput);
        String[] carNameList = NameInput.split(NAME_SEPARATOR);

        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            validateCarName(name,carList);
            carList.add(new Car(name));
        }
        return carList;
    }

    public static int getAttemptCountFromInput(String attemptInput) {
        checkAttemptOK(attemptInput);
        return Integer.parseInt(attemptInput);
    }

    private static void validateCarNamesInput(String input){
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_NO_INPUT_ERROR);
        }

        boolean isInvalidCommaUsage = input.contains(",,") || input.startsWith(NAME_SEPARATOR) || input.endsWith(NAME_SEPARATOR);

        if (isInvalidCommaUsage) {
            throw new IllegalArgumentException(NAME_INPUT_INVALID_COMMA);
        }
    }

    private static void validateCarName(String name, List<Car> carList){
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_INPUT_LENGTH_ERROR);
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_INPUT_BLANK_ERROR);
        }
        if(carList.stream().anyMatch(car -> car.getName().equals(name))){
            throw new IllegalArgumentException(NAME_INPUT_DUPLICATE_ERROR);
        }
    }

    private static void checkAttemptOK(String attemptInput){
        if (!attemptInput.matches("\\d+")){
            throw new IllegalArgumentException(ATTEMPT_INPUT_ERROR_MESSAGE);
        }
    }
}

