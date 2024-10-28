package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class GameController {
    public void startGame() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = Console.readLine();
            List<String> carNames = Arrays.asList(inputNames.split(","));
            Validation.validateCarNamesList(carNames);

            System.out.println("시도할 횟수는 몇 회인가요?");
            String inputRounds = Console.readLine();
            Validation.validateRoundsIsInteger(inputRounds);

            int rounds = Integer.parseInt(inputRounds);
            Race race = new Race(carNames);
            race.start(rounds);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
