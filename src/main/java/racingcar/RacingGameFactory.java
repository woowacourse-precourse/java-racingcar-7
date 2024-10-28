package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.validator.CarNameValidator;
import racingcar.validator.NumberOfTurnValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameFactory {
    private RacingGameFactory() {}

    public static RacingGameController createRacingGame(){
        CarNameValidator carNameValidator = new CarNameValidator();
        NumberOfTurnValidator numberOfTurnValidator = new NumberOfTurnValidator();
        InputView inputView = new InputView(carNameValidator,numberOfTurnValidator);
        OutputView outputView = new OutputView();

        return new RacingGameController(inputView,outputView);
    }
}
