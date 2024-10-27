package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record InputDTO(
        List<String> carNames,
        int tryCnt
) {}
