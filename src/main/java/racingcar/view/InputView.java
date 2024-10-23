package racingcar.view;

import static racingcar.util.Message.INPUT_TRIAL_COUNT;
import static racingcar.util.Message.INPUT_NAMES;
import static racingcar.util.Validator.validateInputString;
import static racingcar.util.Validator.validateInteger;
import static racingcar.util.Validator.validateNameCount;

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
        validateNameCount(racingCarNames.size());

        return racingCarNames;
    }

    public int inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);

        return validateInteger(Console.readLine());
    }
}
