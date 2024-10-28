package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        try {
            RacingGame game = new RacingGame(carNamesInput, attemptCount);
            game.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static class RacingGame {
        private static final int forwardThreshold = 4;
        private final List<Car> cars;
        private final int attemptCount;

        public RacingGame(String carNamesInput, int attemptCount) {
            validateAttemptCount(attemptCount);
            this.cars = createCars(carNamesInput);
            this.attemptCount = attemptCount;
        }

        private void validateAttemptCount(int attemptCount) {
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 최소 1회 이상입니다.");
            }
        }

        private List<Car> createCars(String carNamesInput) {
            List<String> carNames = RacingGameInputValidator.validateCarNames(carNamesInput);
            List<Car> cars = new ArrayList<>();
            for (String name : carNames) {
                cars.add(new Car(name));
            }
            return cars;
        }

        public void play() {
            System.out.println("\n실행 결과");
            for (int i = 0; i < attemptCount; i++) {
                playRound();
                printRoundResult();
            }
            printWinners();
        }

        private void playRound() {
            for (Car car : cars) {
                if (isMovable()) {
                    car.move();
                }
            }
        }

        private boolean isMovable() {
            return Randoms.pickNumberInRange(0, 9) >= forwardThreshold;
        }

        private void printRoundResult() {
            for (Car car : cars) {
                System.out.println(car);
            }
            System.out.println();
        }

        private void printWinners() {
            int maxPosition = cars.stream()
                    .mapToInt(Car::getPosition)
                    .max()
                    .orElse(0);

            List<String> winners = cars.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .map(Car::getName)
                    .collect(Collectors.toList());

            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

    static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            validateName(name);
            this.name = name;
        }

        private void validateName(String name) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        public void move() {
            position++;
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " : " + "-".repeat(position);
        }
    }

    static class RacingGameInputValidator {
        public static List<String> validateCarNames(String carNamesInput) {
            if (carNamesInput == null || carNamesInput.isBlank()) {
                throw new IllegalArgumentException("자동차 이름을 입력하세요.");
            }

            List<String> carNames = List.of(carNamesInput.split(","))
                    .stream()
                    .map(String::trim)
                    .collect(Collectors.toList());

            if (carNames.isEmpty() || carNames.contains("")) {
                throw new IllegalArgumentException("유효한 자동차 이름이 아닙니다.");
            }

            return carNames;
        }
    }
}