package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRequestDto;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        RacingRequestDto racingRequest = inputView.getRacingRequest();
        List<String> carNames = CarNameParser.parseCarName(racingRequest.rawCarNames());
        CarNameValidator.validateCarNames(carNames);
    }
}
