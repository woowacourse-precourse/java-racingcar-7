package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = getCarNames();
        validateCarNames(carNames);
        int moveCount = getMoveCount();
        RacingGame racingGame = new RacingGame(carNames, moveCount);
        racingGame.play();
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static void validateCarNames(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }


    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static class Car {
        private final String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

        public void move() {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                position++;
            }
        }

        public String getPositionDisplay() {
            return name + " : " + "-".repeat(position);
        }

        public int getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }
    }

    public static class RacingGame {
        private final List<Car> cars;
        private final int moveCount;

        public RacingGame(String carNames, int moveCount) {
            this.cars = createCars(carNames);
            this.moveCount = moveCount;
        }

        private List<Car> createCars(String carNames) {
            List<Car> cars = new ArrayList<>();
            for (String name : carNames.split(",")) {
                cars.add(new Car(name.trim()));
            }
            return cars;
        }

        public void play() {
            for (int i = 0; i < moveCount; i++) {
                playRound();
                System.out.println();
            }
            printWinners();
        }

        private void playRound() {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getPositionDisplay());
            }
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
}