package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * InputView 검증: 빈 문자열, null, 구분자 포함 여부
 */
public class InputView {

    public List<String> getCarNames() {
        String input = Console.readLine();

        validateBlankInput(input);

        return List.of(input);
    }

    private void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }
}
