package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.view.InstructionView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InstructionView instructionView = new InstructionView();
        RacingCarService racingCarService = new RacingCarService();
        RacingCarController controller = new RacingCarController(instructionView, racingCarService);
        controller.run();
    }
}
