package racingcar.Service;

import racingcar.Car;

public class CarService {
    public Car[] convertToCar(String[] carNames){
        int carLen = carNames.length;
        Car[] cars = new Car[carLen];
        for(int i = 0; i < carLen; i++){
            Car car = new Car(carNames[i],0);
            cars[i] = car;
        }
        return cars;
    }
}
