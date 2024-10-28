package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
        }
    }

    private static class Car {
        private final String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        public void move() {
            position++;
        }

        public String getPositionDisplay() {
            return "-".repeat(position);
        }
    }
}
