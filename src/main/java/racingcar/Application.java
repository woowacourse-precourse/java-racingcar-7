package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.Racingcars;
import racingcar.service.RacingService;
import racingcar.utils.StringReplacer;
import racingcar.utils.StringSplitter;
import racingcar.validate.RacingcarAttemptValidate;
import racingcar.validate.RacingcarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        StringReplacer stringReplacer = new StringReplacer();
        StringSplitter stringSplitter = new StringSplitter();

        Racingcars racingcars = new Racingcars();
        RacingService racingService = new RacingService(racingcars);

        RacingcarAttemptValidate racingcarAttemptValidate = new RacingcarAttemptValidate();
        RacingcarNameValidate racingcarNameValidate = new RacingcarNameValidate();

        StringBuilder middleResult = new StringBuilder();

        RacingController racingController = new RacingController(inputView, outputView,
                stringSplitter, stringReplacer,
                racingService,
                racingcarNameValidate, racingcarAttemptValidate,
                middleResult
        );
        racingController.run();
    }
}
