package racingcar;

import racingcar.controller.GameController;
import racingcar.service.ClientService;
import racingcar.service.ClientServiceImpl;
import racingcar.validate.Validation;

public class Application {
    public static void main(String[] args) {
        final ClientService clientService = new ClientServiceImpl();
        final Validation validation = new Validation();

        final GameController gameController = new GameController(clientService, validation);
        gameController.start();
    }
}
