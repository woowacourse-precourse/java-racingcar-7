package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRequestDto;
import racingcar.model.Racing;
import racingcar.util.CarNameParser;
import racingcar.util.CarNameValidator;
import racingcar.util.RaceRoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingRequestDto racingRequest = inputView.getRacingRequest();
        List<String> carNames = CarNameParser.parseCarName(racingRequest.rawCarNames());
        CarNameValidator.validateCarNames(carNames);
        RaceRoundValidator.validateRaceRound(racingRequest.rawRoundsToRace());

        int raceRound = Integer.parseInt(racingRequest.rawRoundsToRace());
        Racing racing = Racing.from(carNames, raceRound);
        outputView.initPrintRoundResult();
        while (racing.hasNextRound()) {
            racing.executeRound();
            outputView.printRoundResult(racing.getCars());
        }
    }
}
