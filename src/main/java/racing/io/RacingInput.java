package racing.io;

import camp.nextstep.edu.missionutils.Console;
import racing.validation.InputValidator;

import java.util.List;

public class RacingInput {

    private final InputValidator inputValidator = new InputValidator();

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameStr = Console.readLine();

        String[] carNames = carNameStr.split(",");
        inputValidator.validateCarNames(carNames);

        return List.of(carNames);
    }

    public int getGameRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int gameRound = Integer.parseInt(Console.readLine());
        inputValidator.validateGameRound(gameRound);

        return gameRound;
    }
}
