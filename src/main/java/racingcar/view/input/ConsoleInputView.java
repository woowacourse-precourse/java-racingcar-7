package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String INVALID_TRY_NUMBER_MESSAGE = "잘못된 시도 횟수 입력입니다.";

    @Override
    public List<String> inputCarNames() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        return Arrays.asList(carNames.split(",",-1));
    }

    @Override
    public Integer inputMoveCount() {
        System.out.println(REQUEST_TRY_NUMBER_MESSAGE);
        String tryNumber = Console.readLine();
        try {
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_NUMBER_MESSAGE);
        }
    }
}
