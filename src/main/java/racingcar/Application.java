package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.Parser;
import racingcar.model.RaceService;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        Validator validator = new Validator();
        RaceService raceService = new RaceService();

        RaceController raceController = new RaceController(inputView, outputView, parser, validator, raceService);

        raceController.run();
    }
}
