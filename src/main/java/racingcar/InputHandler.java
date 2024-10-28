package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {


    public List<String> getCarNames() {
        List<String> carNames = splitCarNames(readCarNames());
        InputValidator.validateCarName(carNames);
        return carNames;
    }
    public Integer getTryCount() {
        String tryCount = readTryCount();
        InputValidator.validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private List<String> splitCarNames(String carName) {
        return List.of(carName.split(","));
    }
    private String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    private String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}


