package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarController {

    public Cars getWinners(List<Car> cars) {
        sortCarsByDistance(cars);

        Cars winners = Cars.newCars();

        Car winner = cars.getFirst();
        for (Car car : cars) {
            if (winner.getDistance() > car.getDistance()) break;
            winners.addCar(car);
        }

        return winners;
    }


    private void sortCarsByDistance(List<Car> cars) {
        cars.sort(Comparator.comparingLong(Car::getDistance).reversed());
    }

    public void moveOrStopCarsByRandomNumber(Cars cars) {
        cars.getCarList().forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
        });
    }
}
