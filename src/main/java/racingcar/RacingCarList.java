package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final String DELIMITER = ",";
    private final List<Car> carList;

    public RacingCarList() {
        this.carList = new ArrayList<>();
    }

    public void add(String carNames) {
        String[] splitNames = carNames.split(DELIMITER);
        for (String splitName : splitNames) {
            Validation.validateCarName(splitName);
            carList.add(new Car(splitName));
        }
    }

    public List<Car> moveCar(String attemptCount) {
        int count = Validation.validateAttemptCount(attemptCount);
        for (int i = 0; i < count; i++) {
            for (Car car : carList) {
                if (MoveCondition.getCondition() >= 4) {
                    car.move();
                }
            }
            OutputView.printRacingStatus(carList);
            OutputView.printLineBreak();
        }
        return carList;
    }

    public String findWinner(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
            }

            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}