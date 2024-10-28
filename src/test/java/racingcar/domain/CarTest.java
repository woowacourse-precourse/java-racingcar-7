package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class CarTest {
    @Test
    @DisplayName("자동차는 전진 조건이 충족되면 전진한다")
    void moveForward() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();

        car.move(true);

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("전진율을 정확하게 계산한다")
    void calculateForwardRate() {
        Car car = new Car("test");
        car.move(true);  // 전진
        car.move(false); // 정지
        car.move(true);  // 전진

        assertThat(car.getForwardRate(3)).isCloseTo(66.67, within(0.01));  // isEqualTo 대신 isCloseTo 사용
    }

    @ParameterizedTest
    @DisplayName("연속 전진 횟수를 정확하게 기록한다")
    @CsvSource({
            "true,true,false,true,2",
            "true,true,true,false,3",
            "false,true,true,true,3"
    })
    void trackConsecutiveForwards(boolean m1, boolean m2, boolean m3, boolean m4, int expected) {
        Car car = new Car("test");
        car.move(m1);
        car.move(m2);
        car.move(m3);
        car.move(m4);

        assertThat(car.getMaxConsecutiveForwards()).isEqualTo(expected);
    }
}