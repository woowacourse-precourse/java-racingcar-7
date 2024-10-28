package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.repository.RacingcarRepositoryImpl;
import racingcar.service.RacingcarServiceImpl;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var view = new View();
        var racingcarRepository = new RacingcarRepositoryImpl();
        var carService = new RacingcarServiceImpl(racingcarRepository);
        var racingcarController = new RacingcarController(view, carService);

        racingcarController.run();
    }
}
