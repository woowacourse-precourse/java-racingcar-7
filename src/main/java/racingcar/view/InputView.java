package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;

public class InputView {
    private final CarNameValidator carNameValidator;
    private final TrialCountValidator trialCountValidator;
    public InputView(CarNameValidator carNameValidator, TrialCountValidator trialCountValidator){
        this.carNameValidator = carNameValidator;
        this.trialCountValidator = trialCountValidator;
    }

    public String inputCarName(){
        String input = Console.readLine();
        carNameValidator.validateCarNames(input);
        return input;
    }

    public  String inputTrialCount(){
        String input = Console.readLine();
        trialCountValidator.validateTrialCount(input);
        return input;
    }
}
