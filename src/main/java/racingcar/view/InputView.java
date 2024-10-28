package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.InputExtractor;
import racingcar.model.InputValidator;

import java.util.List;

public class InputView {
    private final static String REQUEST_MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_MESSAGE_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public void printCarNameRequestMessage() {
        System.out.println(REQUEST_MESSAGE_CAR_NAME);
    }

    public void printTryCntRequestMessage() {
        System.out.println(REQUEST_MESSAGE_TRY_COUNT);
    }

    public String getCarNames() {
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    public String getTryCnt() {
        String tryCount = Console.readLine();
        inputValidator.validateTryCounts(tryCount);
        return tryCount;
    }
}
