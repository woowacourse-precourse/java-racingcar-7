package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;

public class InputView {

    private InputView(){
    }

    public static String inputCarName(){
        String input = Console.readLine();
        CarNameValidator.validateCarNames(input);
        return input;
    }

    public static String inputTrialCount(){
        String input = Console.readLine();
        TrialCountValidator.validateTrialCount(input);
        return input;
    }

}
