package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.InputValidator;

public class InputView {
    private final String inputCarNameInstruction = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String inputTrialCountInstruction = "시도할 횟수는 몇 회인가요?";
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> inputCarNameList() {
        System.out.println(inputCarNameInstruction);
        String[] splitInput = Console.readLine().split(",");
        List<String> carNameList = Arrays.stream(splitInput).map(String::trim).toList();

        carNameList.forEach(inputValidator::validateCarName);

        return carNameList;
    }

    public int inputTrialCount() {
        System.out.println(inputTrialCountInstruction);
        String trialCount = Console.readLine();

        inputValidator.validateTrialCount(trialCount);

        return Integer.parseInt(trialCount);
    }
}
