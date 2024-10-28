package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.play();
    }
}

class RacingGame {
    private static final int FORWARD_THRESHOLD = 4;

    private List<Car> cars;
    private int tryCount;

    public void play() {
        try {
            initializeGame();
            race();
            announceWinners();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initializeGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateInput(input);
        cars = createCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        tryCount = parsePositiveNumber(Console.readLine());
    }

    private void validateInput(String input) {
        String[] names = input.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("경주를 위해서는 최소 2대 이상의 자동차가 필요합니다.");
        }

        for (String name : names) {
            validateName(name.trim());
        }
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private List<Car> createCars(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int parsePositiveNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private void race() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            moveAllCars();
            printCurrentPositions();
            System.out.println();
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
                car.move();
            }
        }
    }

    private void printCurrentPositions() {
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
    }

    private void announceWinners() {
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.printf("최종 우승자 : %s%n", String.join(", ", winners));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
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