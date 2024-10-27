package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.view.InstructionView;
import racingcar.view.ResultView;
import racingcar.view.RoundView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InstructionView instructionView = new InstructionView();
        ValidateService validateService = new ValidateService();
        RacingCarService racingCarService = new RacingCarService();
        RoundView roundView = new RoundView();
        ResultView resultView = new ResultView();
        RacingCarController controller = new RacingCarController(instructionView, validateService, racingCarService, roundView, resultView);
        controller.run();
    }
}
