package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.GameResult;

public class GameRunner {

    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int MOVEMENT_LIMIT = 4;
    private static final String CAR_POSITION_INDICATOR = " : ";
    private static final String POSITION_SYMBOL = "-";
    private static final String LINE_BREAK = "\n";
    private static final String WINNER_DELIMITER = ",";

    public GameResult runGame(Set<String> carNames, int finalAttemptCount) {
        List<Car> cars = initializeCarState(carNames);
        StringBuilder allRoundResults = new StringBuilder();

        for (int attemptCount = 0; attemptCount < finalAttemptCount; attemptCount++) {
            updateCarState(cars);
            allRoundResults.append(formatRoundResult(cars));
        }

        return new GameResult(cars, allRoundResults.toString());
    }

    private List<Car> initializeCarState(Set<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void updateCarState(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
            if (isMoved(randomNumber)) {
                car.move();
            }
        });
    }

    public boolean isMoved(int randomNumber) {
        return randomNumber >= MOVEMENT_LIMIT;
    }

    public String getWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        return String.join(WINNER_DELIMITER, winners);
    }

    public String formatRoundResult(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> {
            result.append(car.getName())
                    .append(CAR_POSITION_INDICATOR)
                    .append(POSITION_SYMBOL.repeat(Math.max(0, car.getPosition())))
                    .append(LINE_BREAK);
        });
        return result.toString();
    }
}