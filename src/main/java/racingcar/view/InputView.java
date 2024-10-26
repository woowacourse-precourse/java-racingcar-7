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

    private List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
