package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingRequestDto;
import racingcar.model.Car;
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
        Racing racing = initRacing(racingRequest);
        outputView.initPrintRoundResult();
        runRacing(racing);
        printWinners(racing);
    }

    private Racing initRacing(RacingRequestDto racingRequest) {
        List<String> carNames = getValidatedCarNames(racingRequest.rawCarNames());
        int raceRound = getValidatedRaceRound(racingRequest.rawRoundsToRace());
        return Racing.from(carNames, raceRound);
    }

    private void runRacing(Racing racing) {
        while (racing.hasNextRound()) {
            racing.executeRound();
            outputView.printRoundResult(racing.getParticipants());
        }
    }

    private void printWinners(Racing racing) {
        List<Car> winners = racing.getWinners();
        outputView.printWinners(winners);
    }

    private List<String> getValidatedCarNames(String rawCarNames) {
        List<String> carNames = CarNameParser.parseCarName(rawCarNames);
        CarNameValidator.validateCarNames(carNames);
        return carNames;
    }

    private int getValidatedRaceRound(String rawRaceRound) {
        RaceRoundValidator.validateRaceRound(rawRaceRound);
        return Integer.parseInt(rawRaceRound);
    }
}
