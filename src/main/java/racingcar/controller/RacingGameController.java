package racingcar.controller;

import static racingcar.service.GameService.registerCarParticipants;
import static racingcar.service.GameService.splitCarName;
import static racingcar.service.GameStart.race;
import static racingcar.validation.Validation.validateGameCount;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.view.*;

public class RacingGameController {
    public void gameStart() {
        int max = 0;
        String carNameBuffer = input.carNameInput();
        ArrayList<String> carNameArray = splitCarName(carNameBuffer);
        Car[] cars = registerCarParticipants(carNameArray);

        String gameCountBuffer = input.GameCountInput();
        int gameCount = validateGameCount(gameCountBuffer);

        for (int i = 0; i < gameCount; i++) {
            max = race(cars);
            Output.gameResult(cars);
        }
        Output.gameWinners(max, cars);

    }
}
