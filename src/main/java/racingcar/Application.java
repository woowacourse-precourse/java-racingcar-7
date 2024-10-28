package racingcar;

import racingcar.common.config.ApplicationConfig;
import racingcar.common.constant.MessageConstants;
import racingcar.controller.RaceController;
import racingcar.ui.InputUI;
import racingcar.ui.OutputUI;

public class Application {

    public static void main(String[] args) {

        // 1. ApplicationConfig로부터 RaceController를 생성
        ApplicationConfig config = new ApplicationConfig();
        RaceController controller = config.getRaceController();

        // 2. 사용자로 부터 입력(Client)
        String command = InputUI.inputString(MessageConstants.INPUT_TRY_COUNT);
        Integer iterations = InputUI.inputInteger(MessageConstants.INPUT_CAR_NAMES);

        // 3. 경주 시작
        String winners = controller.startRace(command, iterations);

        // 4. 사용자에게 출력 (Client)
        OutputUI.printResult(MessageConstants.OUTPUT_RESULT_TEMPLATE, winners);
    }
}
