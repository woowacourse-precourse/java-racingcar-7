package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.Racingcars;
import racingcar.service.RacingService;
import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StringSplitter stringSplitter = new StringSplitter();
        Racingcars racingcars = new Racingcars();
        RacingService racingService = new RacingService(racingcars);

        RacingController racingController = new RacingController(inputView, outputView, stringSplitter, racingService);
        racingController.run();
    }
}
