package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
            String carNamesInput = Console.readLine();
            List<String> carNames = RacingGameInputValidator.validateCarNames(carNamesInput);

            System.out.print("시도할 횟수는 몇 회인가요?\n");
            int attemptCount = RacingGameInputValidator.validateAttemptCount(Console.readLine());

            RacingGame racingGame = new RacingGame(carNames, attemptCount);
            racingGame.play();
            racingGame.printWinners();

    }

    public static class RacingGame {
        private final List<Car> cars;
        private final int attemptCount;

        public RacingGame(List<String> carNames, int attemptCount) {
            this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
            this.attemptCount = attemptCount;
        }

        public void play() {
            for (int i = 0; i < attemptCount; i++) {
                cars.forEach(car -> {
                    if (Randoms.pickNumberInRange(0, 9) >= 4) {
                        car.move();
                    }
                });
                printRaceStatus();
            }
        }

        private void printRaceStatus() {
            for (Car car : cars) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        public void printWinners() {
            int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
            List<String> winners = cars.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .map(Car::getName)
                    .collect(Collectors.toList());

            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

    public static class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
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
    }

    public static class RacingGameInputValidator {

        public static List<String> validateCarNames(String input) {
            List<String> carNames = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());

            for (String name : carNames) {
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
                }
                if (name.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
                }
            }
            return carNames;
        }

        public static int validateAttemptCount(String input) {
            try {
                int attemptCount = Integer.parseInt(input);
                if (attemptCount <= 0) {
                    throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
                }
                return attemptCount;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
            }
        }
    }
}