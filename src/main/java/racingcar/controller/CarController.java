package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarController {

    private final List<Car> cars;

    public CarController(Cars cars) {
        this.cars = cars.getCarList();
    }

    public List<Car> getWinners() {
        sortCarsByDistance();

        List<Car> winners = new ArrayList<>();
        Car winner = cars.getFirst();

        for (Car car : cars) {
            if (winner.getDistance() > car.getDistance()) break;
            winners.add(car);
        }

        return winners;
    }


    private void sortCarsByDistance() {
        cars.sort(Comparator.comparingLong(Car::getDistance).reversed());
    }

    public List<Car> moveOrStopCarsByRandomNumber() {
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
        });
        return cars;
    }
}
