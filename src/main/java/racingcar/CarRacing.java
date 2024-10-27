package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRacing {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int MOVABLE_NUMBER = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INPUT_NAME_SEPARATOR = ",";
    private static final String WINNER_SEPARATOR = ",";

    private static Car[] cars;
    private static int tryCount;

    public static void start() {
        String[] input = input();

        initCarArray(input[0]);
        initTryCount(input[1]);

        while (CarRacing.tryCount-- > 0) {
            updatePosition();
        }

        displayResult();

        String[] winners = getWinner();
        System.out.print("최종 우승자 : " + String.join(WINNER_SEPARATOR, winners));
    }

    private static String[] input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountString = Console.readLine();

        return new String[]{carNames, tryCountString};
    }

    private static void initTryCount(String tryCountString) {
        validateTryCountInput(tryCountString);
        CarRacing.tryCount = Integer.parseInt(tryCountString);
    }

    private static void initCarArray(String carNames) {
        String[] carNameArray = carNames.split(INPUT_NAME_SEPARATOR);
        for (String carName : carNameArray) {
            validateCarName(carName);
        }

        cars = new Car[carNameArray.length];
        for (int carNameIndex = 0; carNameIndex < carNameArray.length; carNameIndex++) {
            cars[carNameIndex] = new Car(carNameArray[carNameIndex]);
        }
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
            if (Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END) >= MOVABLE_NUMBER) {
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
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, " + MAX_CAR_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }
}
