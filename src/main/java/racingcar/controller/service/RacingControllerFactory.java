package racingcar.controller.service;

import racingcar.controller.RacingController;
import racingcar.trynumber.service.TryNumberCreateService;
import racingcar.racingcar.service.move.RandomMoveGenerator;
import racingcar.racingcar.service.move.impl.MoveProcess;
import racingcar.racingcar.service.racing.RacingService;
import racingcar.racingcar.service.racing.impl.RacingProcess;
import racingcar.racingcar.service.create.RacingCarCreateService;
import racingcar.racingcar.service.create.impl.RacingCarCreator;
import racingcar.trynumber.service.impl.TryNumberCreator;
import racingcar.racingcar.service.racing.impl.WinningCar;
import racingcar.racingcar.service.racing.impl.RacingResultCalculator;
import racingcar.view.input.handler.impl.InputHandler;
import racingcar.view.input.service.impl.CarInputView;
import racingcar.view.input.service.impl.TryNumberInputView;
import racingcar.view.output.service.CommonOutputService;
import racingcar.view.output.service.impl.CarInfoOutputViewProcess;
import racingcar.view.output.service.impl.CommonOutputViewProcess;
import racingcar.view.output.service.impl.ResultOutputViewProcess;
import racingcar.view.output.service.impl.TryNumberInfoOutputViewProcess;

public class RacingControllerFactory {
    public static RacingController crate() {

        RacingCarCreateService racingCarCreateProcess = new RacingCarCreator(
                new InputHandler(new CarInputView(new CarInfoOutputViewProcess()))
        );
        TryNumberCreateService tryNumberCreateProcess = new TryNumberCreator(
                new InputHandler(new TryNumberInputView(new TryNumberInfoOutputViewProcess()))
        );
        RacingService racingProcess = new RacingProcess(
                new MoveProcess(new RandomMoveGenerator()),
                new WinningCar(new RacingResultCalculator()),
                new ResultOutputViewProcess());
        CommonOutputService commonOutputService = new CommonOutputViewProcess();
        return new RacingController(racingCarCreateProcess, tryNumberCreateProcess, racingProcess, commonOutputService);
    }
}
