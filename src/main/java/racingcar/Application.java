package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = getCarNames();
        int moveCount = getMoveCount();
        List<Car> cars = createCars(carNamesInput);

        // 이후 기능 구현
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 입력 유효성 검증
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty() || name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
        return input;
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int moveCount = Integer.parseInt(input);
            if (moveCount <= 0) {
                throw new IllegalArgumentException("이동 횟수는 양의 정수여야 합니다.");
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 정수로 입력해야 합니다.");
        }
    }

    private static List<Car> createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    // Car 중첩 클래스
    private static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            if (name.length() > 5 || name.length() == 0) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            this.name = name;
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
    }
}
