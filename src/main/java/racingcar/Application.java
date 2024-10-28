package racingcar;

import java.util.ArrayList;
import java.util.Map;
import racingcar.domain.InputContainer;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;
import racingcar.validator.Validator;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        RacingCarService racingCarService = new RacingCarService();

        InputContainer inputContainer = inputController.readConsole();
        String inputCars = inputContainer.getCars();
        int attempts = inputContainer.getAttempts();

        if(!validator.attemptValidate(attempts)) {
            throw new IllegalArgumentException();
        }

        String[] cars = inputCars.split(",");

        Map<String, String> carMoveMap = racingCarService.getCarMoveMap();
        racingCarService.makeCarMap(cars, validator, carMoveMap);


        outputController.printResultSentence();
        racingCarService.executeRaceRounds(cars, carMoveMap, attempts);

        ArrayList<String> winners = racingCarService.findWinners(carMoveMap);

        outputController.printWinner(winners);
    }
}
