package racingcar;

import racingcar.container.DependencyInjectionContainer;
import racingcar.view.input.InputView;
import racingcar.view.input.dto.RacingRequest;
import racingcar.controller.RacingCarController;
import racingcar.view.output.OutputView;
import racingcar.view.output.dto.RacingResponse;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingRequest racingRequest = InputView.promptRacingRequest();
        DependencyInjectionContainer container = new DependencyInjectionContainer();
        RacingCarController racingCarController = container.get(RacingCarController.class);
        RacingResponse racingResponse = racingCarController.run(racingRequest);
        OutputView.printRacingResult(racingResponse);
    }
}
