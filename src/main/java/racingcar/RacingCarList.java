package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private static final String WINNER_RESULT = "최종 우승자 : ";
    private final String DELIMITER = ",";
    private final List<Car> carList;

    public RacingCarList() {
        this.carList = new ArrayList<>();
    }

    public void add(String carNames) {
        String[] splitNames = carNames.split(DELIMITER);
        for (String splitName : splitNames) {
            Validation.validateLength(splitName);
            carList.add(new Car(splitName));
        }
    }

    public List<Car> moveCar(String attemptCount) {
        int count = Validation.validateIfAttemptCount(attemptCount);
        for (int i = 0; i < count; i++) {
            Car car = carList.get(i % carList.size());
            car.move();
            OutputView.printRacingStatus(carList);
            OutputView.printLineBreak();
        }
        return carList;
    }

    public String findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        List<String> winners = new ArrayList<>();
        System.out.print(WINNER_RESULT);
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        if (winners.size() == 1) {
            return winners.getFirst();
        }
        return String.join(", ", winners);
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}

