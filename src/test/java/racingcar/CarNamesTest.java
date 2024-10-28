package racingcar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class CarNamesTest {
    @Test
    void 자동차_이름_분리_테스트() {
        String carName = "pobi,woni";
        Cars cars = new Cars(carName);

        SoftAssertions.assertSoftly((softly) -> {
            softly.assertThat(cars.getCars().get(0).isName("pobi")).isTrue();
            softly.assertThat(cars.getCars().get(1).isName("woni")).isTrue();
        });
    }
}