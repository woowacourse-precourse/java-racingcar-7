package racingcar.controller;

import racingcar.domain.RacingCarManager;
import racingcar.util.CarNameParser;
import racingcar.util.RandomUtil;

import java.util.List;

import static racingcar.util.ValidationUtil.validateTrial;
import static racingcar.view.InputView.readConsoleInput;
import static racingcar.view.OutputView.*;

public class RacingGameController {
    public void run(){
        RacingCarManager racingCarManager = initializeCarsFromUserInput();
        int trialCount = getTrialCountFromUser();
        executeRace(trialCount, racingCarManager);
        displayWinners(racingCarManager.findWinners());
    }

    private static RacingCarManager initializeCarsFromUserInput() {
        promptCarNameInput();
        String carNameStr = readConsoleInput();
        List<String> racingCarNames = CarNameParser.parse(carNameStr);
        return new RacingCarManager(racingCarNames);
    }

    private static int getTrialCountFromUser() {
        promptTrialCountInput();
        String trialStr = readConsoleInput();
        validateTrial(trialStr);
        return Integer.parseInt(trialStr);
    }

    private static void executeRace(int trial, RacingCarManager racingCarManager) {
        displayResultHeader();
        for(int i = 0; i< trial; i++){
            List<Integer> randomNumbers = RandomUtil.generateRandomNumberForCars(racingCarManager.getCars().size());
            racingCarManager.moveCars(randomNumbers);
            displayRoundResult(racingCarManager.getCars());
        }
    }
}
