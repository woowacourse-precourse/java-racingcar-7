package racingcar.Controller;

import java.util.List;
import racingcar.DTO.RaceFinalWinnerDTO;
import racingcar.DTO.RaceInfoDTO;
import racingcar.DTO.RaceResultDTO;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RaceViewController {
    private InputView inputView;
    private OutputView outputView;

    public RaceViewController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public RaceInfoDTO gatherRaceInfo() {
        try {
            List<String> carNames = inputView.inputCarName();
            int trialCount = inputView.inputTrialCount();

            return new RaceInfoDTO(carNames, trialCount);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void gatherRaceResult(RaceResultDTO raceResultDTO) {
        outputView.displayRaceProgress(raceResultDTO);
    }

    public void printRaceResult() {
        outputView.printRaceResult();
    }

    public void printFinalWinners(RaceFinalWinnerDTO raceFinalWinnerDTO) {
        outputView.printFinalWinners(raceFinalWinnerDTO);
    }
}
