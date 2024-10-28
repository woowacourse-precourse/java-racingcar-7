package racingcar.dto;

import java.util.List;

public record UserInput(
        List<String> carNames,
        int repeatNum
) {
}
