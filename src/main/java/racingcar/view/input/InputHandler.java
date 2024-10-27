package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

public class InputHandler {
    public Set<String> inputCarNames() {
        System.out.println(InputMessages.INPUT_CAR_NAMES);
        return new CarNameInput().process(Console.readLine());
    }

    public int inputAttemptCount() {
        System.out.println(InputMessages.INPUT_ATTEMPT_COUNT);
        return new RaceAttemptNumberInput().process(Console.readLine());
    }
}
