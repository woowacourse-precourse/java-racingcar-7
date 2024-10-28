package racingcar.controller;

import racingcar.model.CarFactory;
import racingcar.model.NameParser;
import racingcar.model.RacingGame;
import racingcar.model.Trial;
import racingcar.model.Winner;
import racingcar.model.generator.NumberGenerator;
import racingcar.model.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public void race() {
        String names = InputView.inputCarNames();
        NameParser nameParser = new NameParser(names);
        CarFactory carFactory = new CarFactory(nameParser.getNames(), numberGenerator);
        int trial = new Trial(InputView.inputTrial()).getTrial();

        RacingGame racingGame = new RacingGame(carFactory.getCars(), trial);
        OutputView.printResult();
        OutputView.printRacing(racingGame.getAllResult());
        OutputView.printWinner(new Winner(racingGame.getCars()).getWinners());
    }
}
