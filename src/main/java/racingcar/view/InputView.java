package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String InputInstruction = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public List<String> inputCarNames() {
        System.out.println(InputInstruction);
        String[] splitInput = Console.readLine().split(",");

        return Arrays.stream(splitInput).map(String::trim).toList();
    }
}
