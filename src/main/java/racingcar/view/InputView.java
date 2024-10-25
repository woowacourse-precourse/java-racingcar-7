package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.CarsRequest;

public class InputView {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public CarsRequest readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = Console.readLine().strip();
        validateInput(carNames);
        return new CarsRequest(carNames);
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하셨습니다.");
        }
    }
}
