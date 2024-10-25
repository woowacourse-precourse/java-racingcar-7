package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    @Test
    @DisplayName("올바른 position을 반환하는지 확인")
    void testGetPosition() {
        int expected = 1;
        CarPosition carPosition = CarPosition.of(1);

        int actual = carPosition.getPosition();

        assertThat(actual).isEqualTo(expected);
    }

//    @Test
//    @DisplayName("입력된 연산의 결과 값으로 position이 바뀌는지 확인")
//    void testApply() {
//        int startPositionValue = 1;
//        IntUnaryOperator addOperator = i -> i + 1;
//        CarPosition carPosition = CarPosition.of(startPositionValue);
//        int expected = addOperator.applyAsInt(startPositionValue);
//
//        CarPosition newPosition = carPosition.apply(addOperator);
//        int actual = newPosition.getPosition();
//
//        assertThat(actual).isEqualTo(expected);
//    }

    @Test
    @DisplayName("Equals를 오버라이딩하는지 확인")
    void testEquals() {
        int sameValue = 1;
        CarPosition carPosition = CarPosition.of(sameValue);
        CarPosition another = CarPosition.of(sameValue);

        assertThat(another).isEqualTo(carPosition);
    }

    @Test
    void testHashCode() {
        int sameValue = 1;
        CarPosition carPosition = CarPosition.of(sameValue);
        CarPosition another = CarPosition.of(sameValue);

        assertThat(another).hasSameHashCodeAs(carPosition);
    }
}