package racingcar;

import racingcar.presentation.RacingCarClient;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;
import racingcar.service.RacingCarService;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarService racingCarService = new RacingCarService();

        RacingCarClient racingCarClient = new RacingCarClient(
                inputView,
                outputView,
                racingCarService
        );

        racingCarClient.run();
    }

}
