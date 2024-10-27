package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private static CarManager instance;
    private List<Car> cars;
    private int remainingAttempts;

    private CarManager() {
        cars = new ArrayList<>();
    }

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void setRemainingAttempts(int attempts) {
        remainingAttempts = attempts;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public void decrementRemainingAttempts() {
        remainingAttempts--;
    }

    public List<Car> getCars() {
        return cars;
    }
}
