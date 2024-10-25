package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 이름이 입력되지 않았습니다.");
        }

        return Arrays.asList(input.split(","));
    }
}
