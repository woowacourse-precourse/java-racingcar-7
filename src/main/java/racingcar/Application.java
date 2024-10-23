package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRacing carRacing = new CarRacing();
        carRacing.init();
    }

    public static class Car {
        final String name;
        public Car(String name) {
            this.name = name;
        }
    }

    public static class CarRacing {
        private static final String CAR_NAME_REGEXP = "[\\w\\s,]+";
        private static final String ATTEMPTS_REGEXP = "\\d+";

        public void init() {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
            String nameInput = Console.readLine();
            System.out.println("시도할 횟수는 몇 회인가요?");
            String attemptsInput = Console.readLine();

            int attempts = convertAttempts(attemptsInput);
            ArrayList<Car> cars = createCarObjects(convertCarNames(nameInput));

            racingStart(cars, attempts);

        }

        ArrayList<String> convertCarNames(String nameInput) {
            ArrayList<String> carNames = new ArrayList<>();

            if(validateInput(CAR_NAME_REGEXP, nameInput)) {
                carNames = new ArrayList<>(Arrays.asList(nameInput.split(",")));
            }
            // 자동차 이름이 하나만 입력된 경우 -> 경주를 진행할 수 없다.
            if (carNames.size() < 2) {
                throw new IllegalArgumentException();
            }
            return carNames;
        }

        int convertAttempts(String countInput) {
            if(validateInput(ATTEMPTS_REGEXP, countInput)) {
                return Integer.parseInt(countInput);
            }
            return 0;
        }

        boolean validateInput(final String regExp, String input) {
            if (input.isEmpty() || input.isBlank() || !input.matches(regExp)) {
                throw new IllegalArgumentException();
            }
            return true;
        }

        ArrayList<Car> createCarObjects(ArrayList<String> carNames) {
            ArrayList<Car> cars = new ArrayList<>();
            for(String name: carNames) {
                cars.add(new Car(name));
            }
            return cars;
        }

        ArrayList<String> racingStart(ArrayList<Car> cars, int attempts) {
            return new ArrayList<>();
        }

    }
}