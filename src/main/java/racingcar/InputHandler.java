package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler {
    public static List<Car> inputCarNames() {
        List<String> carNames = readCarNames();
        validateCarNames(carNames);
        return createCars(carNames);
    }

    private static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(Console.readLine().split(","));
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("자동차는 2개 이상이여야 합니다.");
        }

        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }

        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int inputTryCount() {
        int tryCount = readTryCount();
        validatTryCount(tryCount);
        return tryCount;
    }

    private static int readTryCount() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력해야 합니다.");

        }
    }

    private static void validatTryCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1번 이상이어야 합니다.");
        }
        System.out.println();
    }
}
