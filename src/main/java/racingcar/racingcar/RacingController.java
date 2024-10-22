package racingcar.racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static final RacingController RACING_CONTROLLER = new RacingController();
    private static final String REQUEST_RACING_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_TIMES = "시도할 횟수는 몇 회인가요?";
    private final RacingCarService racingCarService = RacingCarService.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private RacingController() {

    }
    public static RacingController getInstance() {
        return RACING_CONTROLLER;
    }

    public void run(){
        String joinedCarNames = inputView.inputString(REQUEST_RACING_CAR_NAME);
        List<String> carNames = racingCarService.splitCarName(joinedCarNames);
        List<RacingCar> racingCars = racingCarService.makeCar(carNames);
        String tryTimes = inputView.inputString(REQUEST_TRY_TIMES);

    }
}
