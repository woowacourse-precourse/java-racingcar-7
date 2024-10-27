package racingcar;

import static racingcar.Constant.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Car> inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        validateCarNamesInput(input);
        String[] carNameList = input.split(NAME_SEPARATOR);

        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            validateCarName(name,carList);
            carList.add(new Car(name));
        }
        return carList;
    }

    private static void validateCarNamesInput(String input){
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_NO_INPUT_ERROR);
        }
        if (input.contains(",,") || input.startsWith(NAME_SEPARATOR) || input.endsWith(NAME_SEPARATOR)) {
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

    public static int inputAttempt() {
        System.out.println(ATTEMPT_INPUT_MESSAGE);
        String attempt = Console.readLine();
        checkAttemptOK(attempt);
        return Integer.parseInt(attempt);
    }

    private static void checkAttemptOK(String attemptInput){
        if (!attemptInput.matches("\\d+")){
            throw new IllegalArgumentException(ATTEMPT_INPUT_ERROR_MESSAGE);
        }
    }
}

