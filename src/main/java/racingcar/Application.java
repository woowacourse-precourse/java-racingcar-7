package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        RacingGame game = new RacingGame(carNamesInput, attemptCount);
        game.play();
    }

    static class RacingGame {
        private static final int forwardThreshold = 4;  // 자동차 전진 조건
        private final List<Car> cars;
        private final int attemptCount;

        public RacingGame(String carNamesInput, int attemptCount) {
            this.cars = createCars(carNamesInput);
            this.attemptCount = attemptCount;
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
                if (isMovable()) { // 기준 충족시 전진
                    car.move();
                }
            }
        }

        private boolean isMovable() {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            return randomNumber >= forwardThreshold;
        }

        private void printRoundResult() {
            for (Car car : cars) {
                System.out.println(car);
            }
            System.out.println();
        }

        private void printWinners() {
            int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
            List<String> winners = new ArrayList<>();
            for (Car car : cars) {
                if (car.getPosition() == maxPosition) {
                    winners.add(car.getName());
                }
            }
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

    static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
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
            String[] names = carNamesInput.split(",");
            List<String> carNames = new ArrayList<>();
            for (String name : names) {
                carNames.add(name.trim());
            }
            return carNames;
        }
    }
}