package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void 초기화() {
        racingCar = new RacingCar("pobi", new ArrayList<>());
    }

    @Test
    void 전진_처리() {
        racingCar.addAdvanceResult();

        int advanceCount = racingCar.getAdvanceResults().size();

        Assertions.assertThat(advanceCount).isEqualTo(1);
    }
}
