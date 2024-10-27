package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public List<Car> registerCars(List<String> carsInput){
        List<Car> cars = new ArrayList<>();

        for(String carName : carsInput){
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void progressCar(Car car){
        int currentCount = car.getCurrentCount();
        car.setCurrentCount(++currentCount);
    }
}
