package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    private final RacingGameService service = new RacingGameService();
    private final Validator validator = new Validator();
    private final Parser parser = new Parser();

    public void run() {
        getCarNamesByInput();
//        InputView.printRequestLoopCount();
//        String loopCount = Console.readLine();


    }

    public void getCarNamesByInput() {
        InputView.printRequestCarNamesMessage();
        String carNames = Console.readLine();
        validator.checkCarNamesInput(carNames);
//        List<RacingCar> carNamesList = parser.extractCarNames(carNames);
    }
}
