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
        validateMultipleCars(input);
        return List.of(input);
    }

    private void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }

    private void validateMultipleCars(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }
}
