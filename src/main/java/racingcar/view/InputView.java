package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> getCarNames() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public static int getAttemptCount() {
        System.out.println("시도할 횟수를 입력하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
