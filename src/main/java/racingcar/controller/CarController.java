package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;

import java.util.List;

public class CarController {

    private final CarService carService;

    public CarController(){
        this.carService = new CarService();
    }

    public void run(){
        List<Car> cars = carService.initializeCars();
        int inputCount = carService.inputCount();
        carService.startRace(cars, inputCount);
        carService.showResults(cars);
    }
}
