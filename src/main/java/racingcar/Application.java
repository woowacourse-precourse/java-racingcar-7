package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carName = Console.readLine();
            List<String> carNames = List.of(carName.split(",")).stream().map(String::trim).collect(Collectors.toList());

            System.out.println("시도할 횟수는 몇 회인가요?");
            int round = Integer.parseInt(Console.readLine());

            RacingGame game = new RacingGame(carNames, round);
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class RacingGame {
    private final List<Car> cars;
    private final int round;

    public RacingGame(List<String> carNames, int round) {
        if (round < 1) {
            throw new IllegalArgumentException("1 이상의 정수여야 합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.round = round;
    }

    public void start() {
        for (int i = 0; i < round; i++) {
            race();
            printStatus();
        }
        // 승자 출력
    }

    private void race() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private void printStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
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

    public String getPositionString() {
        return "-".repeat(position);
    }
}
