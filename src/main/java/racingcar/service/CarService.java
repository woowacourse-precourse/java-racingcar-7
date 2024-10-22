package racingcar.service;

import racingcar.model.Car;

import java.util.Map;

public class CarService {

    private final Car car;

    public CarService(){
        this.car = new Car();
    }

    public Map<String, Integer> carNames(String inputCarName) {
        return car.carNameSplit(inputCarName);
    }

    public void racing(Map<String, Integer> cars, int count){

        for(int i=0; i<count; i++){
            cars = car.racingTry(cars);
        }

    }
}
