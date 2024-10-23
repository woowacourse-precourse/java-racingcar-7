package racingcar;

import racingcar.config.ApplicationConfig;
import racingcar.constant.MessageConstants;
import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        // 1. ApplicationConfig로부터 RaceController를 생성
        ApplicationConfig config = new ApplicationConfig();
        RaceController raceController = config.getRaceController();

        // 2. 사용자로 부터 입력(Client)
        String command = InputView.inputString(MessageConstants.INPUT_TRY_COUNT);
        Integer iterations = InputView.inputInteger(MessageConstants.INPUT_CAR_NAMES);

        // 3. 경주 시작
        String winners = raceController.startRace(command, iterations);

        // 4. 사용자에게 출력 (Client)
        OutputView.printResult(MessageConstants.OUTPUT_RESULT_TEMPLATE, winners);

    }
}
