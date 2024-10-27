package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.InputDTO;
import racingcar.InputMessage;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryNumbersValidator;

public class InputView {
    private TryNumbersValidator tryNumbersValidator;
    private CarNameValidator carNameValidator;

    public InputView() {
        this.tryNumbersValidator = new TryNumbersValidator();
        this.carNameValidator = new CarNameValidator();
    }

    public InputDTO getInput() {
        String carNames = promptForCarNames();
        String tryNums = promptForTryNums();

        Long validTryNums = tryNumbersValidator.validate(tryNums);
        List<String> validCarNames = carNameValidator.validate(carNames);

        return new InputDTO(validCarNames, validTryNums);
    }

    private String promptForCarNames() {
        System.out.println(InputMessage.CAR_NAME_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    private String promptForTryNums() {
        System.out.println(InputMessage.TRY_NUM_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }


}
