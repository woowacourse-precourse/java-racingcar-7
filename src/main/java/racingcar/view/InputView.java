package racingcar.view;

import static racingcar.util.message.IOMessage.INPUT_TRIAL_COUNT;
import static racingcar.util.message.IOMessage.INPUT_NAMES;
import static racingcar.util.Validator.validateInputString;
import static racingcar.util.Validator.validateIntegerInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.InputDTO;

public class InputView {

    public InputDTO input() {
        List<String> racingCarNames = inputRacerNames();
        int trialCount = inputTrialCount();
        Console.close();

        return new InputDTO(racingCarNames, trialCount);
    }

    public List<String> inputRacerNames() {
        System.out.println(INPUT_NAMES);
        return validateInputString(Console.readLine());
    }

    public Integer inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);
        return validateIntegerInput(Console.readLine());
    }
}
