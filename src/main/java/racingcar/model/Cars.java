package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> racingCars;

    public Cars(String carNames) {
        racingCars = new ArrayList<>();

        for (String carName : carNames.split(CAR_NAME_DELIMITER)) {
            racingCars.add(new Car(carName));
        }
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
