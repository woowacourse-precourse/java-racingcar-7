package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        String carNames = Console.readLine();
        checkCarNameIsNull(carNames);

        return carNames;
    }

    private void checkCarNameIsNull(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력해주세요.");
        }
    }
}
