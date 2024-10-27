package racingcar;

import racingcar.controller.RacingCarController;
//import racingcar.service.RacingCarService;
import racingcar.service.RacingCarService;
import racingcar.service.ValidateService;
import racingcar.view.InstructionView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InstructionView instructionView = new InstructionView();
        ValidateService validateService = new ValidateService();
        RacingCarService racingCarService = new RacingCarService();
        RacingCarController controller = new RacingCarController(instructionView, validateService, racingCarService);
        controller.run();
    }
}
