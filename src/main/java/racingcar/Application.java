package racingcar;// Application.java
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = getCarNames();
            int tryCount = getTryCount();
            RacingGame racingGame = new RacingGame(carNames);
            racingGame.play(tryCount);
            List<String> winners = racingGame.getWinners();
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        });
        return carNames;
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}

class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void play(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            printCars();
            System.out.println();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.move();
            }
        }
    }

    private void printCars() {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getPositionRepresentation()));
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
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
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionRepresentation() {
        return "-".repeat(position);
    }
}
