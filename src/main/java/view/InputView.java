package view;

import camp.nextstep.edu.missionutils.Console;
import view.domain.InputResult;
import view.message.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String CARS_REGEX = "^(\\s*[a-zA-Z]+\\s*)(,\\s*[a-zA-Z]+\\s*)*$";
    private static final String COUNT_REGEX = "^[0-9]+$";

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT = "시도할 횟수는 몇 회인가요?";

    private void validateCars(String cars) throws IllegalArgumentException {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MESSAGE.getMessage());
        }
        if (!cars.matches(CARS_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.SHAPE_MESSAGE.getMessage());
        }

        String[] carName = cars.split(",");

        Arrays.stream(carName)
                .filter(car -> car.isEmpty() || car.length() > 5)
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_MESSAGE.getMessage());
                });

        Set<String> duplicateCarName = new HashSet<>();
        Arrays.stream(carName)
                .filter(car -> !duplicateCarName.add(car))
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ErrorMessage.EXIST_CAR_NAME_MESSAGE.getMessage());
                });
    }

    private int validateCount(String count) throws IllegalArgumentException {
        if (count == null || count.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MESSAGE.getMessage());
        }
        if (!count.matches(COUNT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.SHAPE_MESSAGE.getMessage());
        }

        return Integer.parseInt(count);
    }

    public final InputResult input() throws IllegalArgumentException {
        System.out.println(INPUT_CAR_NAME);
        String cars = Console.readLine();
        validateCars(cars);
        System.out.println(INPUT_COUNT);
        String count = Console.readLine();
        int gameCount = validateCount(count);
        System.out.println();
        Console.close();

        return new InputResult(cars, gameCount);
    }
}
