package domain;

import java.util.ArrayList;
import java.util.List;

public class FindWinningCar {
    private List<Car> cars;
    private int winnersDistance = 0;

    public FindWinningCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinningCars() {
        List<String> winningCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCarLocation() > winnersDistance) {
                winnersDistance = car.getCarLocation();
                winningCars.clear();
                winningCars.add(car.getCarName());
            } else if (car.getCarLocation() == winnersDistance) {
                winningCars.add(car.getCarName());
            }
        }
        return winningCars;
    }
}
