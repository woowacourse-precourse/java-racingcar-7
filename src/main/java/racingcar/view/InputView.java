package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.Cars;
import racingcar.car.Count;

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

    public Count getTryCount() {
        String input = Console.readLine();

        validateBlankInput(input);

        return parseCount(input);
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

    private Count parseCount(String number) {
        try {
            return new Count(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
