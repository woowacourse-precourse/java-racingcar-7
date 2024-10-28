package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    public List<String> parseAndValidateCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        for (String name : carNames) {
            validateCarName(name);
        }
        return carNames;
    }

    private void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하로 입력해야 합니다.");
        }
    }
}
