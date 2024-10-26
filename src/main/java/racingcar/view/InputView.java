package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public int inputRaceRound() {
        System.out.println(INPUT_RACE_ROUND_MESSAGE);
        try {
            String round = Console.readLine();
            return Integer.parseInt(round);
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException("숫자를 입력하세요", e);
        }
    }
}
