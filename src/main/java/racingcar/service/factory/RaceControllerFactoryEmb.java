package racingcar.service.factory;

import racingcar.controller.IO.InputController;
import racingcar.controller.IO.InputControllerEmb;
import racingcar.controller.IO.OutputController;
import racingcar.controller.IO.OutputControllerEmb;
import racingcar.controller.race.RaceController;
import racingcar.controller.race.RaceControllerEmb;
import racingcar.controller.race.RacingCarController;
import racingcar.controller.race.RacingCarControllerEmb;
import racingcar.service.evaluator.WinnerEvaluator;
import racingcar.service.evaluator.WinnerEvaluatorEmb;
import racingcar.view.ResultViewer;
import racingcar.view.ResultViewerEmb;

public class RaceControllerFactoryEmb implements RaceControllerFactory {
    @Override
    public RaceController createRaceController() {
        OutputController outputController = new OutputControllerEmb();
        InputController inputController = new InputControllerEmb();
        CarFactory carFactory = new CarFactoryEmb();
        RacingCarController racingCarController = new RacingCarControllerEmb();
        WinnerEvaluator winnerEvaluator = new WinnerEvaluatorEmb();
        ResultViewer resultViewer = new ResultViewerEmb();

        return new RaceControllerEmb(outputController, inputController, carFactory, racingCarController, winnerEvaluator,resultViewer);
    }
}
