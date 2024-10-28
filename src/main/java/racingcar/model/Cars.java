package racingcar.model;

import racingcar.exception.ExceptionMessage;

import java.util.*;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> racingCars;
    private final Set<String> uniqueCarNames;
    private final List<String> winners;

    public Cars(String carNames) {
        racingCars = new ArrayList<>();
        winners = new ArrayList<>();
        uniqueCarNames = new HashSet<>();

        Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .forEach(carName -> {
                    validateNoDuplicateCarName(carName);
                    racingCars.add(new Car(carName));
                });
    }

    public String recordRoundProgress() {
        StringBuilder roundRecord = new StringBuilder();
        racingCars.forEach(
                car -> roundRecord.append(car.moveAndFormatProgress()).append("\n")
        );

        return roundRecord.toString();
    }

    public String getRacingWinners() {
        addWinnersWithSameForwardCount(calculateWinnerForwardCount());

        return formatWinnerNames();
    }

    private void validateNoDuplicateCarName(String carName) {
        if (uniqueCarNames.contains(carName)) throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_DUPLE.getErrorMessage());
        uniqueCarNames.add(carName);
    }

    private String formatWinnerNames() {
        return String.join(CAR_NAME_DELIMITER + " ", winners);
    }

    private void addWinnersWithSameForwardCount(int winnerForwardCount) {
        racingCars.stream()
                .filter(racingCar -> racingCar.getForwardCount() == winnerForwardCount)
                .map(Car::getCarName)
                .forEach(winners::add);
    }

    private int calculateWinnerForwardCount() {
        racingCars.sort((c1, c2) -> c2.getForwardCount() - c1.getForwardCount());
        return racingCars.getFirst().getForwardCount();
    }
}
