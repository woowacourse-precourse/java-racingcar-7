package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String DELIMITER = ",";
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;

    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int attempts = inputAttempts();
        List<Car> cars = initializeCars(carNames);

        race(cars, attempts);
        announceWinners(cars);
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNames(input);
        String[] names = input.split(DELIMITER);
        return List.of(names);
    }

    private static void validateCarNames(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        for (String name : input.split(DELIMITER)) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }

    private static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attempts = Integer.parseInt(input);
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
        return attempts;
    }

    private static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void race(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            moveCars(cars);
            printRaceStatus(cars);
            System.out.println();
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX) >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    private static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static void announceWinners(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private static List<Car> getWinners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}
