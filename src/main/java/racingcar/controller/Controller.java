package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    private final Validator validator = new Validator();

    public void run() {
        List<RacingCar> carList = getCarNamesByInput();
        InputView.printRequestLoopCount();
        String loopCount = Console.readLine();
        validator.checkLoopCount(loopCount);
//        startGame(carList, loopCount);
    }

    public List<RacingCar> getCarNamesByInput() {
        InputView.printRequestCarNamesMessage();
        String carNames = Console.readLine();
        validator.checkCarNamesInput(carNames);
        return Parser.extractCarNames(carNames);
    }
}
