package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

public class InputHandler {
    public Set<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        CarNameInput carNameInput = new CarNameInput();
        return carNameInput.process(carNamesInput);
    }

    public int inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountInput = Console.readLine();
        RaceAttemptNumberInput raceAttemptNumberInput = new RaceAttemptNumberInput();
        return raceAttemptNumberInput.process(attemptCountInput);
    }
}
