package racingcar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarNamesTest {
    @Test
    void 자동차_이름_분리_테스트() {
        String carName = "pobi,woni";
        CarNames carNames = new CarNames(carName);
        List<Car> cars = carNames.createCars();

        SoftAssertions.assertSoftly((softly) -> {
            softly.assertThat(cars.get(0).isName("pobi")).isTrue();
            softly.assertThat(cars.get(1).isName("woni")).isTrue();
        });
    }
}