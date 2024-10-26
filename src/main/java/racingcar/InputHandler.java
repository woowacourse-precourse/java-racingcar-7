package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    List<String> getCarNames() {
        String carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        carNames = Console.readLine();
        return parseCarNames(carNames);
    }

    List<String> parseCarNames(String carNames) {

    }
}
