package racingcar.service.factory;

import racingcar.controller.*;
import racingcar.controller.IO.InputController;
import racingcar.controller.IO.InputControllerEmb;
import racingcar.controller.IO.OutputController;
import racingcar.controller.IO.OutputControllerEmb;
import racingcar.service.evaluator.WinnerEvaluator;
import racingcar.service.evaluator.WinnerEvaluatorEmb;

public class RaceControllerFactoryEmb implements RaceControllerFactory {
    @Override
    public RaceController createRaceController() {
        OutputController outputController = new OutputControllerEmb();
        InputController inputController = new InputControllerEmb();
        CarFactory carFactory = new CarFactoryEmb();
        RacingCarController racingCarController = new RacingCarControllerEmb();
        WinnerEvaluator winnerEvaluator = new WinnerEvaluatorEmb();

        return new RaceControllerEmb(outputController, inputController, carFactory, racingCarController, winnerEvaluator);
    }
}
