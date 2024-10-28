package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static racingcar.ConsoleMessage.*;
import static racingcar.ErrorMessage.*;

public class Application {

    private static final int POSITION_UPDATE_THRESHOLD = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MINIMUM_TRY_COUNT = 1;

    public static void main(String[] args) {

        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        Map<String, Integer> cars = initCarPosition(carNames);
        int maxPosition = executeRacingGame(tryCount, cars);

        List<String> winnerName = getWinnersName(cars, maxPosition);
        printWinner(winnerName);
    }

    public static void printWinner(List<String> winnerName) {
        String winner = String.join(WINNER_NAME_DELIMITER, winnerName);
        System.out.println(WINNER_INFORM_MESSAGE + winner);
    }

    public static List<String> getWinnersName(Map<String, Integer> cars, int maxPosition) {

        List<String> winnerNames = new ArrayList<>();
        cars.forEach((carname, position) -> {
            addIfWinner(maxPosition, carname, position, winnerNames);
        });

        return winnerNames;
    }

    private static void addIfWinner(int maxPosition, String carname, Integer position, List<String> winnerName) {
        if(position == maxPosition) {
            winnerName.add(carname);
        }
    }

    public static int executeRacingGame(int tryCount, Map<String, Integer> cars) {

        int maxPosition = 0;
        for(int i = 0; i < tryCount; i++) {
            maxPosition = updateCarPositions(cars, maxPosition);

            printCurrentCarPositions(cars);
        }

        return maxPosition;
    }

    private static int updateCarPositions(Map<String, Integer> cars, int maxPosition) {

        for(String car : cars.keySet()) {
            int randomValue = Randoms.pickNumberInRange(0, 9);

            if(randomValue >= POSITION_UPDATE_THRESHOLD) {
                maxPosition = updatePosition(cars, maxPosition, car);
            }
        }

        return maxPosition;
    }

    private static int updatePosition(Map<String, Integer> cars, int maxPosition, String car) {

        int prevPosition = cars.get(car);

        cars.put(car, prevPosition + 1);
        maxPosition = Math.max(maxPosition, prevPosition + 1);

        return maxPosition;
    }

    private static void printCurrentCarPositions(Map<String, Integer> cars) {

        StringBuilder carStatus = new StringBuilder();

        cars.keySet().forEach(carName -> {
            carStatus.append(carName).append(CAR_DESCRIBE_COLON);

            for(int k = 0; k < cars.get(carName); k++) {
                carStatus.append(CAR_PROGRESS_BAR);
            }

            carStatus.append("\n");
        });

        System.out.println(carStatus);
    }

    public static Map<String, Integer> initCarPosition(List<String> carNames) {

        Map<String, Integer> cars = new HashMap<>();

        carNames.forEach(carName -> {
            cars.putIfAbsent(carName, 0);
        });

        return cars;
    }

    public static int getTryCount() {

        System.out.println(TRY_COUNT_INPUT_HINT);

        int tryCount = Integer.parseInt(Console.readLine());
        validateTryCount(tryCount);

        return tryCount;
    }

    private static void validateTryCount(int tryCount) {

        if(tryCount < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR);
        }
    }

    public static List<String> getCarNames() {

        System.out.println(CAR_NAME_INPUT_HINT);

        String carNameInput = Console.readLine();
        List<String> carNames = Arrays.stream(carNameInput.split(",")).map(String::trim).toList();

        validateCarNames(carNames);

        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {

        carNames.forEach(car -> {
            validateNameLength(car);
            validateNameNotBlank(car);
        });
    }

    private static void validateNameLength(String car) {

        if(car.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateNameNotBlank(String car) {

        if(car.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_SHOULD_NOT_BLANK);
        }
    }
}
