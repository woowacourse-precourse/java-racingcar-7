package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleInputView extends InputView {

    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTS_PROMPT = "시도할 회수는 몇 회인가요?";

    @Override
    protected String inputCarNamesString() {
        System.out.println(CAR_NAMES_PROMPT);
        return inputString();
    }

    @Override
    protected String inputNumberOfAttemptsString() {
        System.out.println(ATTEMPTS_PROMPT);
        return inputString();
    }

    private String inputString() {
        final String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력이 null일 수 없습니다.");
        }
        return input;
    }
}
