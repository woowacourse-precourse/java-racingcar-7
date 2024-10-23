package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.Cars;

/**
 * InputView 검증: 빈 문자열, null, 구분자 포함 여부
 */
public class InputView {

    private static final String SEPARATOR = ",";

    public Cars getCarNames() {
        String input = Console.readLine().trim();

        validateBlankInput(input);
        validateMultipleCars(input);

        return new Cars(List.of(input.split(SEPARATOR, -1)));
    }

    private void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
    }

    private void validateMultipleCars(String input) {
        if (!input.contains(SEPARATOR)) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }
}
