package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import static racingcar.Constants.*;
import static racingcar.Constants.ATTEMPTS_REGEXP;
import static racingcar.Utils.println;

public class ReadyToRace {
    protected List<String> inputStrings() {
        List<String> inputStringArr = new ArrayList<>();

        println(INPUT_CAR_NAMES);
        inputStringArr.add(Console.readLine());
        println(INPUT_ATTEMPTS);
        inputStringArr.add(Console.readLine());

        return inputStringArr;
    }

    protected List<Car> createCarObjects(final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    protected static boolean validateInput(final String regExp, String input) {
        if (input.isEmpty() || input.isBlank() || !input.matches(regExp)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean validateNameLimit(final List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueName(List<String> carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            if (!carNameSet.add(name)) {
                return false;
            }
        }
        return true;
    }

    protected static List<String> convertCarNames(final String nameInput) {
        List<String> carNames = new ArrayList<>();

        if (validateInput(CAR_NAME_REGEXP, nameInput)) {
            carNames = new ArrayList<>(Arrays.asList(nameInput.split(",")));
        }

        if (carNames.isEmpty() || !validateNameLimit(carNames) || !isUniqueName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    protected static int convertAttempts(final String countInput) {
        if (validateInput(ATTEMPTS_REGEXP, countInput)) {
            return Integer.parseInt(countInput);
        }
        return 0;
    }

}
