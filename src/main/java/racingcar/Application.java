package racingcar;

import racingcar.controller.RacingController;
import racingcar.dto.InputDTO;
import racingcar.dto.OutputDTO;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        InputDTO inputDTO = inputView.display();
        OutputDTO outputDTO = RacingController.execute(inputDTO);
        outputView.display(inputDTO.getTotalTrialCount(), outputDTO);
    }
}
