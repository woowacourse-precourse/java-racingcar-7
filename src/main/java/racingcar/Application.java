package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.model.RacingCarModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarModel model = new RacingCarModel();
        RacingCarService service = new RacingCarService(model);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarController controller = new RacingCarController(service, inputView, outputView);

        controller.run();
    }
}
