package racingcar;

import racingcar.controller.CarController;
import racingcar.repository.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController race = new CarController(new CarService(new CarRepositoryImpl()), new Input(), new Output());
        race.startRace();
    }
}