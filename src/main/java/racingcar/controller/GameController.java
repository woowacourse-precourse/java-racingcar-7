package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.ClientService;
import racingcar.validate.Validation;
import racingcar.view.InputMessage;

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

    private void extractCarNames() {
        InputMessage.inputCarNames();
        final String input = Console.readLine();
        validation.isInvalidInput(input);
        clientService.createCar(input);
    }

    private void attemptGame() {
        InputMessage.inputGamesAttempts();
        final int count = Integer.parseInt(Console.readLine());
    }


}
