package racingcar.dto;

import java.util.List;

public record InputRequest(
    String carNames,
    int movingCount
) {
}
