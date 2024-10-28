package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int FORWARD_THRESHOLD = 4;

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        try {
            game.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class RacingGame {
    private List<Car> cars;
    private int tryCount;

    public void play() {
        initializeGame();
        race();
        announceWinners();
    }

    private void initializeGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        cars = createCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        tryCount = parsePositiveNumber(Console.readLine());
    }

    private List<Car> createCars(String input) {
        String[] names = input.split(",");
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            validateName(name.trim());
            carList.add(new Car(name.trim()));
        }

        return carList;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
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
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
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
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

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
