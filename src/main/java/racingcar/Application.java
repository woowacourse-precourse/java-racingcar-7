package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRacing carRacing = new CarRacing();
        carRacing.init();
    }

    public static class Car {
        final String name;
        int movedAmount;

        public Car(String name) {
            this.name = name;
            this.movedAmount = 0;
        }

        public void run() {
            int randomNumber = Utils.generateRandomValue();

            if (Utils.checkMoveCondition(randomNumber)) {
                moveForward();
            }
        }

        private void moveForward() {
            ++movedAmount;
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

            ArrayList<String> winners = racingStart(cars, attempts);
            printGameWinners(winners);

        }

        // 자동차 이름 5자 이하
        ArrayList<String> convertCarNames(String nameInput) {
            ArrayList<String> carNames = new ArrayList<>();

            if (validateInput(CAR_NAME_REGEXP, nameInput)) {
                carNames = new ArrayList<>(Arrays.asList(nameInput.split(",")));
            }

            if (carNames.size() < 2) {
                throw new IllegalArgumentException();
            }
            return carNames;
        }

        int convertAttempts(String countInput) {
            if (validateInput(ATTEMPTS_REGEXP, countInput)) {
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
            for (String name : carNames) {
                cars.add(new Car(name));
            }
            return cars;
        }

        ArrayList<String> racingStart(ArrayList<Car> cars, int attempts) {
            System.out.println("실행 결과");
            for (int i = 0; i < attempts; i++) {
                // 랜덤 값 생성하고 자동차 전진
                for (Car car : cars) {
                    car.run();
                }
                printGameStatus(cars);
            }
            return determineWinner(cars);
        }

        private void printGameStatus(ArrayList<Car> cars) {
            for (Car car : cars) {
                System.out.println(makeMovedAmountString(car.name, car.movedAmount));
            }
            System.out.println("\n");
        }

        public String makeMovedAmountString(String carName, int movedAmount) {
            String movedAmountString = "-".repeat(movedAmount);
            if (movedAmount == 0) {
                movedAmountString = "";
            }
            return String.format("%s : %s", carName, movedAmountString);
        }

        // TODO : 리팩토링해서 커밋하기
        private ArrayList<String> determineWinner(ArrayList<Car> cars) {
            int maxMovedAmount = 0;
            ArrayList<Car> candidateCars = new ArrayList<>();

            // 참가 자동차 배열을 순회하면서 movedAmount가 가장 큰 자동차 저장
            for (Car car : cars) {
                if (car.movedAmount > maxMovedAmount) {
                    maxMovedAmount = car.movedAmount;
                    candidateCars.clear();
                } else if (car.movedAmount < maxMovedAmount) {
                    continue;
                }
                candidateCars.add(car);
            }

            return getWinnerNames(candidateCars);
        }

        private void printGameWinners(ArrayList<String> winners) {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }

        private ArrayList<String> getWinnerNames(ArrayList<Car> winners) {
            ArrayList<String> winnerNames = new ArrayList<>();

            winners.forEach(car -> winnerNames.add(car.name));

            return winnerNames;
        }

    }

    public static class Utils {
        public static int generateRandomValue() {
            return pickNumberInRange(0, 9);
        }

        public static boolean checkMoveCondition(int randomNum) {
            return randomNum >= 4;
        }

    }
}