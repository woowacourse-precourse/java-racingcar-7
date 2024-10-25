package racingcar.view;

import static racingcar.util.message.IOMessage.INPUT_TRIAL_COUNT;
import static racingcar.util.message.IOMessage.INPUT_NAMES;
import static racingcar.util.InputValidator.validateInputString;
import static racingcar.util.InputValidator.validateInteger;
import static racingcar.util.InputValidator.validateRacingCarCount;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.InputDTO;

public class InputView {

    public InputDTO display() {
        List<String> racingCarNames = inputRacerNames();
        int trialCount = inputTrialCount();
        Console.close();

        return new InputDTO(racingCarNames, trialCount);
    }

    public List<String> inputRacerNames() {
        System.out.println(INPUT_NAMES);
        String input = Console.readLine();

        List<String> racingCarNames = validateInputString(input);
        validateRacingCarCount(racingCarNames.size());

        return racingCarNames;
    }

    public Integer inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);
        return validateInteger(Console.readLine());
    }
}
