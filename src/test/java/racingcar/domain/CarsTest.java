package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void 자동차_생성_테스트() {
        Cars cars = new Cars(new String[] {"pobi","woni"});

        Assertions.assertThat(cars.getSize()).isEqualTo(2);
    }
}
