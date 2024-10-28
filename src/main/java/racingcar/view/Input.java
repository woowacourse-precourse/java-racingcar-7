package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final String SYSTEM_CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SYSTEM_ATTEMPT_NUMBER_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public List<Car> getCarName() {
        System.out.println(SYSTEM_CAR_NAME_INPUT_MESSAGE);
        String carNameInput = Console.readLine();
        validateCarNameInput(carNameInput);

        return makeCarList(carNameInput);
    }

    private void validateCarNameInput(String carNameInput) {
        for (final String carName : carNameInput.split(",")) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름을 채워서 입력해주세요.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
