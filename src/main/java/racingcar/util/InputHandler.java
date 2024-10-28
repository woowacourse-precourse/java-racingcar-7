package racingcar.util;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getCarsName() {
        String input = Console.readLine();
        InputValidator.validateCarNames(input);
        return input;
    }
    public String getTryCount(){
        String input = Console.readLine();
        InputValidator.validateTryCount(input);
        return input;
    }
}
