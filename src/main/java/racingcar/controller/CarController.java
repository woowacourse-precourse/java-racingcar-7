package racingcar.controller;

import racingcar.service.CarService;

import java.util.Map;

public class CarController {

    private final CarService carService;

    public CarController(){
        this.carService = new CarService();
    }

    public void run(){
        Map<String, Integer> cars = carService.inputCar();
        int inputCount = carService.inputCount();
        cars = carService.racing(cars, inputCount);
        carService.result(cars);
    }
}
