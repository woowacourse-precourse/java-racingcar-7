package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.util.RacingUtils;

import java.util.List;

public class Application {

    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void main(String[] args) {
        output.printInputName();
        String carNames = input.getUserAnswer();
        output.printExecuteCount();
        String executeCount = input.getUserAnswer();

        List<String> names = RacingUtils.divideComma(carNames);
    }
}
