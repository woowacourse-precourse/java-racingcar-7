package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public List<String> readCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String rawCarNames = Console.readLine();
        return Arrays.stream(rawCarNames.split(","))
                .toList();
    }

    public String readCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
