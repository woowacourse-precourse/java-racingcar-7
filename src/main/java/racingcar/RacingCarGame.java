package racingcar;

import java.util.ArrayList;
import java.util.Map;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;
import racingcar.domain.InputContainer;
import racingcar.service.RacingCarService;
import racingcar.validator.Validator;

public class RacingCarGame {
    Validator validator = new Validator();
    InputController inputController = new InputController();
    OutputController outputController = new OutputController();
    RacingCarService racingCarService = new RacingCarService();

    public void start() {
        InputContainer inputContainer = inputController.readConsole();
        int attempts = inputContainer.getAttempts();
        validator.attemptValidate(attempts);

        String[] cars = inputContainer.getCars().split(",");
        Map<String, String> carMoveMap = setupCars(cars);

        //레이싱 시작
        outputController.printResultSentence();
        racingCarService.executeRaceRounds(cars, carMoveMap, attempts);

        //우승자 출력
        ArrayList<String> winners = racingCarService.findWinners(carMoveMap);
        outputController.printWinner(winners);
    }

    private Map<String, String> setupCars(String[] cars) {
        Map<String, String> carMoveMap = racingCarService.getCarMoveMap();
        racingCarService.makeCarMap(cars, carMoveMap);
        return carMoveMap;
    }
}
