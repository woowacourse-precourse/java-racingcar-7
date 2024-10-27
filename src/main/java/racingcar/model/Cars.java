package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> racingCars;
    private final Set<String> uniqueCarNames;

    public Cars(String carNames) {
        racingCars = new ArrayList<>();
        uniqueCarNames = new HashSet<>();

        for (String carName : carNames.split(CAR_NAME_DELIMITER)) {
            validateNoDuplicateCarName(carName);
            racingCars.add(new Car(carName));
        }
    }

    private void validateNoDuplicateCarName(String carName) {
        if (uniqueCarNames.contains(carName)) throw new IllegalArgumentException("차 이름이 중복됩니다.");
        uniqueCarNames.add(carName);
    }

    public String racing() {
        StringBuilder roundRecord = new StringBuilder();
        for (Car racingCar : racingCars) {
            roundRecord.append(racingCar.forwardProcess()).append("\n");
        }

        return roundRecord.toString();
    }

    public String getRacingWinners() {
        racingCars.sort((c1, c2) -> c2.getForwardCount() - c1.getForwardCount());
        List<String> winners = new ArrayList<>();

        int winnerForwardCount = racingCars.getFirst().getForwardCount();
        for (Car racingCar : racingCars) {
            if (racingCar.getForwardCount() == winnerForwardCount) {
                winners.add(racingCar.getCarName());
            }
        }

        return String.join(CAR_NAME_DELIMITER + " ", winners); // 여러 명이면 쉼표로 연결되고, 1명이면 쉼표 없이 이름만 출력됨
    }
}
