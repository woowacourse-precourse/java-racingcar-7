package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.CarNameParser;
import racingcar.util.RandomUtil;

import java.util.List;

import static racingcar.util.ValidationUtil.validateTrialCount;
import static racingcar.view.InputView.readConsoleInput;
import static racingcar.view.OutputView.*;

public class RacingGameController {
    public void run(){
        Cars cars = initializeCarsFromUserInput();
        int trialCount = getTrialCountFromUser();
        executeRace(trialCount, cars);
        displayWinners(cars.findWinners());
    }

    private static Cars initializeCarsFromUserInput() {
        promptCarNameInput();
        String carNameStr = readConsoleInput();
        List<String> racingCarNames = CarNameParser.parse(carNameStr);
        return new Cars(racingCarNames);
    }

    private static int getTrialCountFromUser() {
        promptTrialCountInput();
        String trialStr = readConsoleInput();
        validateTrialCount(trialStr);
        return Integer.parseInt(trialStr);
    }

    private static void executeRace(int trial, Cars cars) {
        displayResultHeader();
        for(int i = 0; i< trial; i++){
            List<Integer> randomNumbers = RandomUtil.generateRandomNumberForCars(cars.getCars().size());
            cars.moveCars(randomNumbers);
            displayRoundResult(cars.getCars());
        }
    }
}
