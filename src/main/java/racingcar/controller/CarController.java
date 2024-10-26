package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarController {

    public List<Car> getWinners(List<Car> cars) {
        sortCarsByDistance(cars);

        List<Car> winners = new ArrayList<>();
        Car winner = cars.getFirst();

        for (Car car : cars) {
            if (winner.getDistance() > car.getDistance()) break;
            winners.add(car);
        }

        return winners;
    }


    private void sortCarsByDistance(List<Car> cars) {
        cars.sort(Comparator.comparingLong(Car::getDistance).reversed());
    }

    public List<Car> moveOrStopCarsByRandomNumber(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
        });
        return cars;
    }
}
