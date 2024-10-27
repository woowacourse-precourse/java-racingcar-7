package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUNDS_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final int MINIMUM_ROUNDS = 1;
    public static final int MAXIMUM_ROUNDS = 100;

    private final Parser parser = new Parser();

    public List<String> readCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return parser.parseCarName(Console.readLine());
    }

    public int readGameRounds() {
        System.out.println(ROUNDS_INPUT_MESSAGE);
        int rounds = parser.parseGameRounds(Console.readLine());
        validateGameRounds(rounds);
        return rounds;
    }

    private void validateGameRounds(int rounds) {
        if (rounds < MINIMUM_ROUNDS) {
            throw new IllegalArgumentException(String.format("횟수는 %d이상 입력해주세요", MINIMUM_ROUNDS));
        }
        if (rounds > MAXIMUM_ROUNDS) {
            throw new IllegalArgumentException(String.format("횟수는 %d이하 입력해주세요.", MAXIMUM_ROUNDS));
        }
    }
}
