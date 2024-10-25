package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingGameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;

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
        validator.checkCarNamesInput(carNames); // 중복 아닐까,
//        List<RacingCar> carNamesList = parser.extractCarNames(carNames);
    }
}
