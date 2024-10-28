package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"sieun,sieun", "pobi,pobi", "jun,jun"})
    void Car_생성_테스트(String carName, String expectedCarName) {
        // given & when
        Car testCar = Car.create(carName);
        Car expectedCar = Car.create(expectedCarName);

        // then
        assertEquals(testCar, expectedCar);
    }

    @Test
    void Car_예외_테스트_자동차_이름을_입력하지_않았을_경우() {
        // given
        String emptyName = "";

        // when & then
        assertThatThrownBy(() -> Car.create(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"lengthoverfive", "nameisfine", "nameisdestiny"})
    void Car_예외_테스트_자동차_이름이_5자를_넘는_경우(String carName) {
        assertThatThrownBy(() -> Car.create(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
