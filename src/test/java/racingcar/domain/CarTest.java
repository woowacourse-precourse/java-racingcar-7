package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 이름이_정상일_경우_객체가_생성된다() {
        // given
        String name = "pobis";

        // when
        Car car = new Car(name);

        // then
        assertNotNull(car);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", ""})
    void 이름이_공백일_경우_예외가_발생한다(String carName) {
        assertThrows(IllegalArgumentException.class,
                () -> new Car(carName));
    }

    @Test
    void 이름이_5자_초과하면_예외가_발생한다() {
        // given
        String name = "yeonTaek";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new Car(name));
    }

    @Test
    void 무작위_값이_4이상_이면_전진한다() {
        // given
        Car car = new Car("pobis");
        String beforeDistance = car.generateCarState();

        // when
        car.moveForward(4);

        // then
        assertNotEquals(beforeDistance, car.generateCarState());
    }

    @Test
    void 무작위_값이_4미만_이면_전진하지_않는다() {
        // given
        Car car = new Car("pobis");
        String beforeDistance = car.generateCarState();

        // when
        car.moveForward(3);

        // then
        assertEquals(beforeDistance, car.generateCarState());
    }
}