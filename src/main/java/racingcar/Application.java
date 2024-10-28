package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = initializeCars();

        int attempts = getAttempts();

        startRace(cars, attempts);
    }

    private static List<Car> initializeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return createCars(input);
    }

    private static List<Car> createCars(String input) {
        List<String> names = Arrays.asList(input.split(","));
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptInput = Console.readLine();
        return validateAttemptInput(attemptInput);
    }

    private static int validateAttemptInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int attempts = Integer.parseInt(input);
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return attempts;
    }

    private static void startRace(List<Car> cars, int attempts) {
        Race race = new Race(cars);
        race.startRace(attempts);
    }
}
