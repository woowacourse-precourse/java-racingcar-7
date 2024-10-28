package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.Cars.MAX_CAR_SIZE;
import static racingcar.domain.Cars.MIN_CAR_SIZE;
import static racingcar.message.ExceptionMessage.DUPLICATE_CAR_NAME;
import static racingcar.message.ExceptionMessage.INVALID_SIZE_CAR_NAME;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 자동차가_10개_초과면_예외가_발생한다() {
        List<String> carNames = List.of("crong", "loopy", "eddy", "pobi", "petty", "harry", "rody", "popo", "pipi",
                "woni", "jun");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_SIZE_CAR_NAME.getMessage(),
                        MIN_CAR_SIZE, MAX_CAR_SIZE, carNames.size()));
    }

    @Test
    void 자동차명이_중복되면_예외가_발생한다() {
        List<String> carNames = List.of("crong", "loopy", "eddy", "pobi", "pobi");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME.getMessage());
    }

}