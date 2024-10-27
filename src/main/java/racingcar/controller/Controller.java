package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final Validator validator = new Validator();
    private final RacingGameService service = new RacingGameService();

    public void run() {
        List<RacingCar> carList = getCarNamesByInput();
        String loopCount = getLoopCountByInput();
        startGame(carList, loopCount);
        findAndPrintWinners();
    }

    public List<RacingCar> getCarNamesByInput() {
        InputView.printRequestCarNamesMessage();
        String carNames = Console.readLine();
        validator.checkCarNamesInput(carNames);
        return Parser.extractCarNames(carNames);
    }

    private String getLoopCountByInput() {
        InputView.printRequestLoopCountMessage();
        String loopCount = Console.readLine();
        validator.checkLoopCount(loopCount);
        return loopCount;
    }

    private void startGame(List<RacingCar> carList, String loopCount) {
        service.initGame(carList, Parser.parseNumber(loopCount));
        OutputView.printResult();
        service.playRounds();
    }

    private void findAndPrintWinners() {
        List<RacingCar> winners = service.findWinners();
        OutputView.printWinners(winners);
    }

}
