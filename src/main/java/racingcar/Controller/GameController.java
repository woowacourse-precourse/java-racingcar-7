package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class GameController {
    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> carNames = Arrays.stream(carNamesInput.split(",")).toList();
        validateCarNames(carNames);
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 적어도 두 개 입력해야 합니다.");
        }
        if (carNames.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름 입력 길이를 초과하였습니다. (최대 5자)");
        }
    }
}
