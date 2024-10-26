package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int INITIAL_MAX_POSITION = 0;
    private static final String WINNER_DELIMITER = ", ";

    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        this.cars = makeCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            findWinner(winners, car.getCarName().getCarName(), car.getPosition(), maxPosition);
        }

        return String.join(WINNER_DELIMITER, winners);
    }

    private void findWinner(List<String> winners, String carName, int carPosition, int maxPosition) {
        if (carPosition == maxPosition) {
            winners.add(carName);
        }
    }

    private int getMaxPosition() {
        int maxPosition = INITIAL_MAX_POSITION;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    private List<Car> makeCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();

        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
