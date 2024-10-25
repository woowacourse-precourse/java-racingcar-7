package racingcar;

import static racingcar.service.racingCarService.findWinners;
import static racingcar.service.racingCarService.makeCarMap;
import static racingcar.service.racingCarService.moveController;

import java.util.ArrayList;
import java.util.Map;
import racingcar.domain.InputContainer;
import racingcar.repository.RacingCarRepository;
import racingcar.validator.Validator;
import racingcar.controller.inputController;
import racingcar.controller.outputController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Validator validator = new Validator();
        inputController inputController = new inputController();
        outputController outputController = new outputController();
        RacingCarRepository racingCarRepository = RacingCarRepository.getInstance();


        InputContainer inputContainer = inputController.readConsole();
        String inputCars = inputContainer.getCars();
        int attempts = inputContainer.getAttempts();

        String[] cars = inputCars.split(",");

        Map<String, String> carMoveMap = racingCarRepository.getCarMoveMap();
        makeCarMap(cars, validator, carMoveMap);

        int trial = 0;
        int randomNum = 0;
        while (trial < attempts) {
            trial++;
            moveController(cars, carMoveMap);
            outputController.printPerAttempt(carMoveMap);
        }

        ArrayList<String> winners = findWinners(carMoveMap);

        outputController.printWinner(winners);
    }


}
