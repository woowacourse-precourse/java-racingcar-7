package racingcar;

import java.util.List;
import racingcar.controller.RacingController;
import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.model.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        InputDTO inputDTO = inputView.input();
        List<String> racerNames = inputDTO.getRacerNames();
        Integer totalTrialCount = inputDTO.getTotalTrialCount();

        RacingResult racingResult = RacingController.startRace(racerNames, totalTrialCount);
        OutputDTO outputDTO = RacingController.announceResult(racingResult, inputDTO.getTotalTrialCount());

        outputView.display(outputDTO);
    }
}
