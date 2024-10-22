package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class CarRacing {
    private static Car[] cars;
    private static int tryCount;

    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();
        CarRacing.cars = Arrays.stream(carNames.split(","))
                .peek(CarRacing::validateCarName)
                .map(Car::new)
                .toArray(Car[]::new);

        System.out.println("시도할 횟수는 몇 회인가요?");

        String tryCount = Console.readLine();
        validateTryCountInput(tryCount);
        CarRacing.tryCount = Integer.parseInt(tryCount);

        while (CarRacing.tryCount-- > 0) {
            updatePosition();
        }

        displayResult();

        String[] winners = getWinner();
    }

    private static String[] getWinner() {
        int[] maxPositionAndCount = getWinnerPositionAndCount();
        int maxPosition = maxPositionAndCount[0];
        int count = maxPositionAndCount[1];

        String[] winners = new String[count];

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners[--count] = car.getName();
            }
        }

        return winners;
    }

    private static int[] getWinnerPositionAndCount() {
        int maxPosition = 0;
        int count = 0;
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                count++;
            }

            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
                count = 1;
            }
        }

        return new int[]{maxPosition, count};
    }

    private static void displayResult() {
        for (Car car : cars) {
            car.display();
        }
    }

    private static void updatePosition() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private static void validateTryCountInput(String tryCountString) {
        if (!tryCountString.matches("\\d+") || Integer.parseInt(tryCountString) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
