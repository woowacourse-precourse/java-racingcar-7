package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.UserInputDto;
import racingcar.service.RacingCarService;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final RacingCarService racingCarService;

    public RacingCarController() {
        this.inputView = new InputView();
        this.inputValidator = new InputValidator();
        this.racingCarService = new RacingCarService();
        this.outputView = new OutputView();
    }

    public void start() {
        List<String> userInput = getUserInputAndValidate();
        int epoch = getUserEpoch();
        UserInputDto dto = UserInputDto.of(userInput, epoch);
        racingCarService.racingStart(dto);
        displayResult();
    }

    private List<String> getUserInputAndValidate() {
        String carNames = inputView.getCarNames();
        inputValidator.validateCarNames(carNames);
        return Arrays.asList(carNames.split(","));
    }

    private int getUserEpoch() {
        int epoch = inputView.getEpoch();
        inputValidator.validateEpoch(epoch);
        return epoch;
    }

    private void displayResult() {
        outputView.displayResult(racingCarService.findWinner());
    }
}
