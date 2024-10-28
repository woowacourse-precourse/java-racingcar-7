package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.Cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static racingcar.error.RacingException.*;

public abstract class InputView {

    private InputView() {
    }

    public static Cars readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();
        checkIfCarNamesValid(carNames);
        Cars cars = new Cars();
        Arrays.stream(carNames.split(","))
                .map(Car::new)
                .forEach(cars::add);
        return cars;
    }

    public static int readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String count = Console.readLine();
        checkIfCarNamesValid(count);
        return Integer.parseInt(count);
    }

    public void checkIfCountValid(String count) {
        isInputEmpty(count);
        if (!count.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException(WRONG_COUNT_ERROR.getDescription());
        }
    }

    private static void checkIfCarNamesValid(String carNames) {
        isInputEmpty(carNames);
        isWrongFormat(carNames);
        isCarNameLengthValid(carNames);
        isCarNameDuplicate(carNames);
    }

    private static void isInputEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_ERROR.getDescription());
        }
    }

    private static void isWrongFormat(String carNames) {
        if (!carNames.matches("^(?!,)(?!.*,,)[a-zA-Z0-9,]+(?<! ,)$")) {
            throw new IllegalArgumentException(WRONG_FORMAT_ERROR.getDescription());
        }
    }

    private static void isCarNameLengthValid(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getDescription());
            }
        }
    }

    private static void isCarNameDuplicate(String carNames) {
        String[] names = carNames.split(",");
        Set<String> set = new HashSet<>();
        for (String name : names) {
            if (!set.add(name)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR.getDescription());
            }
        }
    }
}
