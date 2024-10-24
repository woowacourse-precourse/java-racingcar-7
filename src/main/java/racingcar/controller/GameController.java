package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.ClientService;
import racingcar.validate.Validation;

public class GameController {

    private final ClientService clientService;
    private final Validation validation;

    public GameController(final ClientService clientService, final Validation validation) {
        this.clientService = clientService;
        this.validation = validation;
    }

    public void start() {
        extractCarNames();
    }

    public void extractCarNames() {
        final String input = Console.readLine();
        validation.isInvalidInput(input);
        clientService.createCar(input);
    }

}
