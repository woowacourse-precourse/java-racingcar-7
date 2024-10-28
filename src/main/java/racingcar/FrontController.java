package racingcar;

import java.util.List;
import racingcar.controller.RacingController;
import racingcar.dto.request.RacingRequestDTO;
import racingcar.dto.response.RacingResponseDTO;
import racingcar.validator.RacingRequestValidator;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class FrontController {
    private final RacingController racingController;
    private final InputView inputView;
    private final OutputView outputView;

    public FrontController(
            RacingController racingController,
            InputView inputView,
            OutputView outputView
    ) {
        this.racingController = racingController;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    void run() {
        List<String> carNames = inputView.inputCarNames();
        Integer moveCount = inputView.inputMoveCount();

        RacingRequestDTO racingRequestDTO = RacingRequestDTO.of(carNames, moveCount);
        RacingRequestValidator.validate(racingRequestDTO);

        RacingResponseDTO racingResponseDTO = racingController.startRace(racingRequestDTO);

        outputView.printRaceResult(racingResponseDTO);
    }
}
