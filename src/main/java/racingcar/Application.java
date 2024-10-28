package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_THRESHOLD = 4;

    public static void main(String[] args) {
        List<Car> cars = inputCars();
        int attempts = inputAttempts();
        race(cars, attempts);
        announceWinners(cars);
    }

    private static List<Car> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return createCars(input.split(","));
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            validateName(name.trim());
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private static void race(List<Car> cars, int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            moveCars(cars);
            printStatus(cars);
            System.out.println();
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
                car.move();
            }
        }
    }

    private static void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private static void announceWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}