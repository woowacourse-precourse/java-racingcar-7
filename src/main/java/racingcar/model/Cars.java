package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> racingCars;
    private final Set<String> uniqueCarNames;
    private final List<String> winners;

    public Cars(String carNames) {
        racingCars = new ArrayList<>();
        winners = new ArrayList<>();
        uniqueCarNames = new HashSet<>();

        for (String carName : carNames.split(CAR_NAME_DELIMITER)) {
            validateNoDuplicateCarName(carName);
            racingCars.add(new Car(carName));
        }
    }

    public String recordRoundProgress() {
        StringBuilder roundRecord = new StringBuilder();
        for (Car racingCar : racingCars) {
            roundRecord.append(racingCar.moveAndFormatProgress()).append("\n");
        }

        return roundRecord.toString();
    }

    public String getRacingWinners() {
        final int winnerForwardCount = calculateWinnerForwardCount();
        addWinnersWithSameForwardCount(winnerForwardCount);

        return formatWinnerNames();
    }

    private void validateNoDuplicateCarName(String carName) {
        if (uniqueCarNames.contains(carName)) throw new IllegalArgumentException("차 이름이 중복됩니다.");
        uniqueCarNames.add(carName);
    }

    private String formatWinnerNames() {
        return String.join(CAR_NAME_DELIMITER + " ", winners);
    }

    private void addWinnersWithSameForwardCount(int winnerForwardCount) {
        for (Car racingCar : racingCars) {
            if (racingCar.getForwardCount() == winnerForwardCount) {
                winners.add(racingCar.getCarName());
            }
        }
    }

    private int calculateWinnerForwardCount() {
        racingCars.sort((c1, c2) -> c2.getForwardCount() - c1.getForwardCount());
        return racingCars.getFirst().getForwardCount();
    }
}
