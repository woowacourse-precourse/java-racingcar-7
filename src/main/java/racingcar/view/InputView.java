package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;
import racingcar.validation.Validator;

public class InputView {

    public String inputCarName(){
        System.out.println(InputMessage.INPUT_NAME.getMessage());
        return Console.readLine();
    }

    public int getAttemptCount(){
        System.out.println(InputMessage.INPUT_COUNT.getMessage());
        return Validator.checkIfNumber(Console.readLine());
    }
}
