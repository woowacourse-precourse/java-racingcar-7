package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("자동차 이름을 분리하여 자동차 객체 생성")
    @Test
    void 자동차_분리() {
        Cars cars = new Cars("pobi,woni,jun");
        assertThat(cars).isEqualTo(new Cars(new String[]{"pobi", "woni", "jun"}));
    }
}
