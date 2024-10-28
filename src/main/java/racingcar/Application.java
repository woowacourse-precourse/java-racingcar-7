package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.start();
    }
}

class RacingGame {
    private List<Car> cars;
    private int attemptCount;

    public void start() {
        cars = getCars();
    }

    private List<Car> getCars() {
        System.out.println("경주할 자동차 이름 입력 (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }

    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }

    class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}