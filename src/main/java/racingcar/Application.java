package racingcar;

import racingcar.controller.CarRacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CarRacingController carRacingController = new CarRacingController(inputView, outputView);

        carRacingController.startRace(); // 경주 시작
    }

}
