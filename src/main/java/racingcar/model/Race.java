package racingcar.model;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<String> carNames, int rounds) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.rounds = rounds;
    }
    public void start() {
        for (Car car : cars) {
            int randomValue = pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }
    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
    public List<String> getWinners() {
        int maxLocation = 0;
        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }

        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
