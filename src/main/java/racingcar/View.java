package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class View {
    private List<String> inputCarNames() {
        String input = Console.readLine().trim();
        String[] names = input.split(",");
        for (String name : names) {
            // TODO: 자동차 이름 예외처리 5자리 이하
        }
        return Arrays.asList(names);
    }
}
