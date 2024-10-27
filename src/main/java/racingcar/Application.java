package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.racing.Racing;
import racingcar.util.RacingUtils;

import java.util.List;

public class Application {

    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void main(String[] args) {
        output.printInputName();
        List<String> names = RacingUtils.divideComma(input.getUserAnswer());

        output.printExecuteCount();
        int execute = RacingUtils.parseInt(input.getUserAnswer());

        Racing racing = new Racing(names);

        output.printRacingResult();
        while (execute-- > 0) {
            List<String> race = racing.race();
            output.printRaceProcess(race);
        }
    }
}
