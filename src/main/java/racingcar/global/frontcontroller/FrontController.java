package racingcar.global.frontcontroller;

import racingcar.back.controller.CarRaceController;
import racingcar.front.view.InputView;
import racingcar.front.view.OutputView;
import racingcar.global.dto.CarRaceRequestDTO;
import racingcar.global.dto.CarRaceResponseDTO;

public class FrontController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarRaceController carRaceController;

    public FrontController(InputView inputView, OutputView outputView, CarRaceController carRaceController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carRaceController = carRaceController;
    }


    public void run() {
        CarRaceRequestDTO carRaceRequestDTO = inputView.readUserInput();
        CarRaceResponseDTO carRaceResponseDTO = carRaceController.playRaceGame(carRaceRequestDTO);
        outputView.writeGameResult(carRaceResponseDTO);
    }
}
