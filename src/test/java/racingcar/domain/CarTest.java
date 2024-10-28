package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private static final String NORMAL_NAME = "pobi";
    private static final String ABNORMAL_NAME = "yeonTaek";

    @Test
    void 이름이_정상일_경우_객체가_생성된다() {
        // given & when
        Car car = new Car(NORMAL_NAME);

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
        assertThrows(IllegalArgumentException.class,
                () -> new Car(ABNORMAL_NAME));
    }

    @Test
    void 자동차_이름을_가져온다() {
        // given
        Car car = new Car(NORMAL_NAME);

        // when
        String name = car.getName();

        // then
        assertEquals(NORMAL_NAME, name);
    }

    @Test
    void 차의_거리가_크면_1을_반환한다() {
        // given
        Car car = new Car(NORMAL_NAME);
        Car otherCar = new Car(NORMAL_NAME);

        car.moveForward(4);

        // when
        int result = car.compareDistance(otherCar);

        // then
        assertEquals(result, 1);
    }

    @Test
    void 차의_거리가_같으면_0을_반환한다() {
        // given
        Car car = new Car(NORMAL_NAME);
        Car otherCar = new Car(NORMAL_NAME);

        // when
        int result = car.compareDistance(otherCar);

        // then
        assertEquals(result, 0);
    }

    @Test
    void 차의_거리가_적으면_마이너스_1을_반환한다() {
        // given
        Car car = new Car(NORMAL_NAME);
        Car otherCar = new Car(NORMAL_NAME);

        otherCar.moveForward(4);
        // when
        int result = car.compareDistance(otherCar);

        // then
        assertEquals(result, -1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 무작위_값이_4이상_이면_전진한다(int randomNumber) {
        // given
        Car car = new Car(NORMAL_NAME);
        String beforeDistance = car.toString();

        // when
        car.moveForward(randomNumber);

        // then
        assertNotEquals(beforeDistance, car.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 무작위_값이_4미만_이면_전진하지_않는다(int randomNumber) {
        // given
        Car car = new Car(NORMAL_NAME);
        String beforeDistance = car.toString();

        // when
        car.moveForward(randomNumber);

        // then
        assertEquals(beforeDistance, car.toString());
    }
}