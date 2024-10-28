package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int attempts = getAttempts();
        validateCarNames(carNames);
        validateAttempts(attempts);

        List<Car> cars = createCars(carNames);
        race(cars, attempts);
        printWinners(findWinners(cars));
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void race(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            raceRound(cars);
            printRoundResults(cars);
        }
    }

    private static void raceRound(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveForward();
            }
        }
    }

    private static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    // 우승자 결정
    private static List<Car> findWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    // 우승자 출력
    private static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}