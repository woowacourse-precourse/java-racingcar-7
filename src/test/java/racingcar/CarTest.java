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
        assertEquals(0, car.getLocation());
    }

    @Test
    void createCarWithWrongName() {
        // 자동차의 이름은 5자 이하
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(new Car("haeseung"));
    }

    @Test
    void createCarWithoutName() {
        // 자동차 이름이 없는 경우 오류 출력
        // 없는 경우
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy((ThrowingCallable) new Car());
        // 공백
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(new Car(""));
        // 스페이스바
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(new Car(" "));
        // 탭
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(new Car("   "));
    }

    @Test
    void moveCar() {
        // 자동차 움직이기
        Car car = new Car("car1");
        int preLocation = car.getLocation();
        car.move();
        int curLocation = car.getLocation();
        assertThat(curLocation).isEqualTo(preLocation + 1);
    }

    @Test
    void stopCar() {
        // 상태 변화가 없기에 method 구현 X
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
