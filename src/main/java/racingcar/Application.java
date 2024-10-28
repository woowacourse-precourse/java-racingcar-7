import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            List<Car> cars = initializeCars();
            int moves = getMoveCount();
            playGame(cars, moves);
            displayWinners(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Car> initializeCars() {
        System.out.println("자동차 이름을 입력하세요 (이름은 쉼표(,)로 구분).");
        String input = Console.readLine();
        String[] names = input.split(",");

        validateCarNames(names);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 입력되었습니다.");
            }
        }
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int moves = Integer.parseInt(Console.readLine());
        if (moves <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return moves;
    }

    private static void playGame(List<Car> cars, int moves) {
        for (int i = 0; i < moves; i++) {
            moveCars(cars);
            displayCarPositions(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private static void displayCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static void displayWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("우승자: " + String.join(", ", winners));
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
