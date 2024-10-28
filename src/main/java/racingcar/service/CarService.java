package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.Utils;

public class CarService {
    private static CarService carService;

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    public List<Car> makeCarInstance(String[] carNames){
        List<Car> cars = new ArrayList<Car>();
        for(String carName : carNames){
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public void advanceCar(List<Car> cars){
        for (Car car : cars) {
            int num = Utils.getRandom();
            if(num >= Utils.ADVANCE_STANDARD){
                car.advanceCar();
            }
        }
    }

    public List<String> findWinner(List<Car> cars){
        int maxAdvanceCount = cars.stream()
                .mapToInt(Car::getAdvanceCount)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getAdvanceCount() == maxAdvanceCount)
                .map(Car::getCarName)
                .collect(Collectors.toList());


    }
}
