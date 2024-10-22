package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String inputCarNameInstruction = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String inputTrialCountInstruction = "시도할 횟수는 몇 회인가요?";

    public List<String> inputCarNames() {
        System.out.println(inputCarNameInstruction);
        String[] splitInput = Console.readLine().split(",");

        return Arrays.stream(splitInput).map(String::trim).toList();
    }

    public int inputTrialCount() {
        System.out.println(inputTrialCountInstruction);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
