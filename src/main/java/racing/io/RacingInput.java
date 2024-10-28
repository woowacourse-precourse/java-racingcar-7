package racing.io;

import camp.nextstep.edu.missionutils.Console;
import racing.validation.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingInput {

    private final InputValidator inputValidator = new InputValidator();

    private List<String> parseCarName(String carNameStr) {
        List<String> carNames = Arrays.stream(carNameStr.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return carNames;
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameStr = Console.readLine();
        List<String> carNames = parseCarName(carNameStr);
        inputValidator.validateCarNames(carNames);

        return carNames;
    }


    public int getGameRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameRoundStr = Console.readLine();

        int gameRound = parseGameRound(gameRoundStr);

        inputValidator.validateGameRound(gameRound);

        return gameRound;
    }

    public int parseGameRound(String gameRoundStr) {
        int gameRound;
        try {
            gameRound = Integer.parseInt(gameRoundStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 입력입니다.");
        }
        return gameRound;
    }
}
