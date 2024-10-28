package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.CarNameListValidator;
import racingcar.validation.TryCountValidator;

public class InputView {
    private static final String CAR_NAMES_DELIMITER = ",";

    public void displayCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void displayTryCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public int inputTryCount() {
        return TryCountValidator.validate(Console.readLine());
    }

    public List<String> splitCarNamesToList(String carNames) {
        List<String> carNameList = List.of(carNames.split(CAR_NAMES_DELIMITER));
        CarNameListValidator.validate(carNameList);
        return carNameList;
    }
}
