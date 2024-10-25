package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println(ViewMessage.INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public String inputTryCount() {
        System.out.println(ViewMessage.INPUT_TRY_COUNT.getMessage());
        return Console.readLine();
    }
    
    public void close() {
        Console.close();
    }

}
