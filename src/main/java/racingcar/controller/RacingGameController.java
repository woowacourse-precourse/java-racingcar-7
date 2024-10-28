package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.util.CarNameParser;
import racingcar.util.RandomUtil;

import java.util.List;

import static racingcar.util.ValidationUtil.validateTrialCount;
import static racingcar.view.InputView.readConsoleInput;
import static racingcar.view.OutputView.*;

public class RacingGameController {
    public void run() {
        RacingCars racingCars = initializeCarsFromUserInput();
        int trialCount = getTrialCountFromUser();
        executeRace(trialCount, racingCars);
        displayWinners(racingCars.findWinners());
    }

    private static RacingCars initializeCarsFromUserInput() {
        promptCarNameInput();
        String carNameStr = readConsoleInput();
        List<String> racingCarNames = CarNameParser.parse(carNameStr);
        return new RacingCars(racingCarNames);
    }

    private static int getTrialCountFromUser() {
        promptTrialCountInput();
        String trialCountStr = readConsoleInput();
        validateTrialCount(trialCountStr);
        return Integer.parseInt(trialCountStr);
    }

    private static void executeRace(int trialCount, RacingCars racingCars) {
        displayResultHeader();
        for (int i = 0; i < trialCount; i++) {
            List<Integer> randomNumbers = RandomUtil.generateRandomNumberForCars(racingCars.getCarsSize());
            racingCars.moveCars(randomNumbers);
            displayRoundResult(racingCars.getCarNames(), racingCars.getCarPositions());
        }
    }
}
