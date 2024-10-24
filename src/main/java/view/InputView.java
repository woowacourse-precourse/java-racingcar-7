package view;

import camp.nextstep.edu.missionutils.Console;
import view.domain.InputResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    private static final String CARS_REGEX = "^(\\s*[a-zA-Z]+\\s*)(,\\s*[a-zA-Z]+\\s*)*$";
    private static final String COUNT_REGEX = "^[0-9]+$";

    private static final String EMPTY_MESSAGE = "입력 값이 존재하지 않습니다.";
    private static final String SHAPE_MESSAGE = "입력 형태가 올바르지 않습니다.";

    private void validateCars(String cars) throws IllegalArgumentException {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        if (!cars.matches(CARS_REGEX)) {
            throw new IllegalArgumentException(SHAPE_MESSAGE);
        }

        String[] carName = cars.split(",");

        Arrays.stream(carName)
                .filter(car -> car.isEmpty() || car.length() > 5)
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
                });

        Set<String> duplicateCarName = new HashSet<>();
        Arrays.stream(carName)
                .filter(car -> !duplicateCarName.add(car))
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
                });
    }

    private int validateCount(String count) throws IllegalArgumentException {
        if (count == null || count.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        if (!count.matches(COUNT_REGEX)) {
            throw new IllegalArgumentException(SHAPE_MESSAGE);
        }

        return Integer.parseInt(count);
    }

    public final InputResult input() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        validateCars(cars);
        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        int gameCount = validateCount(count);
        System.out.println();
        Console.close();

        return new InputResult(cars, gameCount);
    }
}
