package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import object.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Application {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int ADVANCE_THRESHOLD = 4;

    public static void main(String[] args) {
        String carName = carNameInput();
        List<String> carNameList = splitCarNamesByComma(carName);
        validateCarNames(carNameList);

        int tryCount = getTryCount();
        List<Car> cars = initializeCars(carNameList);

        startRace(cars, tryCount);
        printWinners(cars);
    }

    private static String carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();

        if (isEmptyCarName(carName)) {
            throw new IllegalArgumentException("경주할 자동차 이름 입력 필요함.");
        }

        return carName;
    }

    private static boolean isEmptyCarName(String carName) {
        return carName == null || carName.isEmpty();
    }

    private static List<String> splitCarNamesByComma(String carName) {
        return Arrays.asList(carName.split(","));
    }

    private static void validateCarNames(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 넘길 수 없습니다.");
            }
        }
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();

        return parseTryCount(tryCountInput);
    }

    private static int parseTryCount(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }

    private static List<Car> initializeCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void startRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceRound(cars);
            System.out.println();
        }
    }
    private static void raceRound(List<Car> cars) {
        for (Car car : cars) {
            if (shouldAdvance()) {
                car.advance();
            }
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private static boolean shouldAdvance() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return randomValue >= ADVANCE_THRESHOLD;
    }

    private static void printWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getWinners(cars, maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    private static List<String> getWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}