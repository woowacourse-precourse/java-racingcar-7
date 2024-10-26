package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    private final Validator validator = new Validator();

    public void run() {
        List<RacingCar> carList = getCarNamesByInput();
        String loopCount = getLoopCountByInput();
        startGame(carList, loopCount);
    }

    private String getLoopCountByInput() {
        InputView.printRequestLoopCountMessage();
        String loopCount = Console.readLine();
        validator.checkLoopCount(loopCount);
        return loopCount;
    }

    private void startGame(List<RacingCar> carList, String loopCount) {
        RacingGame game = new RacingGame(carList, Parser.parseNumber(loopCount));
        game.start();
    }

    public List<RacingCar> getCarNamesByInput() {
        InputView.printRequestCarNamesMessage();
        String carNames = Console.readLine();
        validator.checkCarNamesInput(carNames);
        return Parser.extractCarNames(carNames);
    }
}
