package racingcar.racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final RacingController RACING_CONTROLLER = new RacingController();
    private static final String PUT_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private RacingController() {

    }

    public static RacingController getInstance() {
        return RACING_CONTROLLER;
    }

    public void inputRacingCarName(){
        inputView.inputString(PUT_RACING_CAR_NAME);
    }
}
