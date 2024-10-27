package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void 초기화() {
        racingCar = new RacingCar("pobi,woni, jun", new ArrayList<>());
    }

    @Test
    void 회차별_전진_처리() {
        int randomInteger = 5;

        racingCar.addRandomAdvanceResult(randomInteger);

        Assertions.assertThat(racingCar.getAdvanceResults()).hasSize(5);
        Assertions.assertThat(racingCar.getAdvanceResults()).allMatch(c -> c.equals('-'));
    }
}
