package racingcar;

import racingcar.controller.RacingController;
import racingcar.repository.CarRepository;
import racingcar.repository.impl.CarRepositoryImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRepository carRepository = new CarRepositoryImpl();
        RacingController racingController = new RacingController(carRepository);
        racingController.run();
    }
}
