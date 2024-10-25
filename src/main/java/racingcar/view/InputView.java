package racingcar.view;

import static racingcar.view.Instruction.INPUT_CAR_NAME_COMMENT;
import static racingcar.view.Instruction.INPUT_TRIAL_COUNT_COMMENT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> inputCarNameList() {
        System.out.println(INPUT_CAR_NAME_COMMENT);

        String[] splitInput = Console.readLine().split(",", -1);
        List<String> carNameList = Arrays.stream(splitInput).map(String::trim).toList();

        carNameList.forEach(inputValidator::validateCarName);
        inputValidator.validateDuplication(carNameList);

        return carNameList;
    }

    public int inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT_COMMENT);

        String trialCount = Console.readLine();

        inputValidator.validateTrialCount(trialCount);

        return Integer.parseInt(trialCount);
    }
}
