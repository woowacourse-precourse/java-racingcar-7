package racingcar.Controller;

import java.util.List;
import racingcar.DTO.RaceInfoDTO;
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
}
