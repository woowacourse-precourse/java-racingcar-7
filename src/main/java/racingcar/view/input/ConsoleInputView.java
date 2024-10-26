package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Override
    public List<String> inputCarNames() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        return Arrays.asList(carNames.split(",",-1));
    }
}
