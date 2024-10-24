package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        return parseCarNames(rawCarNames);
    }

    private List<String> parseCarNames(String rawCarNames) {
        return Arrays.asList(rawCarNames.split(","));
    }
}
