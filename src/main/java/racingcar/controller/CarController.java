package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class CarController {

    private final CarService carService;
    private final Input input;
    private final Output output;

    public CarController(CarService carService, Input input, Output output) {
        this.carService = carService;
        this.input = input;
        this.output = output;
    }

    public void startRace() {
        createRace();
        raceRound(getCount());
        raceOver();
    }

    private void createRace() {
        List<String> carsName = input.cars();

        carsName.forEach(name -> {
            Car car = new Car(name);
            carService.joinCar(car);
        });
    }

    private int getCount() {
        return input.counts();
    }

    private void raceRound(int count) {
        output.race();

        for (int i = 0; i < count; i++) {
            carService.moveCar();
            output.roundResult(carService.getAllCars());
        }
    }

    private void raceOver() {
        List<String> winners = carService.findWinners();
        output.raceWinner(winners);
    }

}
