package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return parseCarNames(input);
    }

    public List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER));
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        for(String name: carNames) {
            validateCarName(name);
        }
    }

    private void validateCarName(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5를 넘을 수 없습니다.");
        }
    }
}
