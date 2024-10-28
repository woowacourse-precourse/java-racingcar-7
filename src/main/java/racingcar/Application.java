package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
    }
}

class RacingGame {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_FORWARD_VALUE = 4;

    public List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public int inputRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    public void raceOnce(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= MIN_FORWARD_VALUE) {
                car.moveForward();
            }
        }
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
        this.position++;//자동차 전진
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
