package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void createCarWithName() {
        // 자동차는 초기 위치가 0
        Car car = new Car("car1");
        assertEquals(car.getLocation(), 0);
        assertEquals(car.getName(), "car1");
    }

    @Test
    void createCarWithWrongName() {
        // 자동차의 이름은 5자 이하
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("haeseung"));
    }

    @Test
    void createCarWithoutName() {
        // 자동차 이름이 없는 경우 오류 출력
        // 없는 경우
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car());
        // 공백
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(""));
        // 스페이스바
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(" "));
        // 탭
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("   "));
    }

    @Test
    void randomMoveCar() {
        // 자동차 확률적으로 전진/정지
        Car car = new Car("car1");
        int preLocation = car.getLocation();
        car.randomMove();
        int curLocation = car.getLocation();
        assertThat(curLocation).isBetween(preLocation, curLocation);
    }

}
