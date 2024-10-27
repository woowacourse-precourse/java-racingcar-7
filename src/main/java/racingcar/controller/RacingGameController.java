package racingcar.controller;

import racingcar.domain.RacingCarManager;
import racingcar.util.CarNameParser;
import racingcar.util.RandomUtil;
import racingcar.util.ValidationUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    public void run(){
        OutputView.printCarNameInputPrompt();
        String carNameStr = InputView.readConsoleInput();
        List<String> racingCarNames = CarNameParser.parse(carNameStr);

        OutputView.printTrialInputPrompt();
        String trialStr = InputView.readConsoleInput();
        ValidationUtil.validateTrial(trialStr);
        int trial = Integer.parseInt(trialStr);

        RacingCarManager racingCarManager = new RacingCarManager(racingCarNames);

        OutputView.printResultHeader();
        for(int i=0; i<trial; i++){
            List<Integer> randomNumbers = RandomUtil.generateRandomNumberForCars(racingCarManager.getCars().size());
            racingCarManager.moveCars(randomNumbers);
            OutputView.printRoundResult(racingCarManager.getCars());
        }

        OutputView.printWinners(racingCarManager.findWinners());
    }
}
