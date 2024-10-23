package racingcar.view;

import static racingcar.util.ConstantData.INPUT_DELIMITER;
import static racingcar.util.Message.INPUT_TRIAL_COUNT;
import static racingcar.util.Message.INPUT_NAMES;
import static racingcar.util.Validator.validateInputString;
import static racingcar.util.Validator.validateInteger;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.InputDTO;

public class InputView {

    public InputDTO display() {
        List<String> racerNames = inputRacerNames();
        int trialCount = inputTrialCount();
        Console.close();

        return new InputDTO(racerNames, trialCount);
    }

    public List<String> inputRacerNames() {
        System.out.println(INPUT_NAMES);
        String input = Console.readLine();
        validateInputString(input);

        return Arrays.stream(input.split(INPUT_DELIMITER)).map(String::strip).toList();
    }

    public int inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);

        return validateInteger(Console.readLine());
    }
}
