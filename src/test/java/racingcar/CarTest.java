package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void 테스트를_위한_자동차_객체_초기화() {
        car = new Car("kymin");
    }

    @Test
    @DisplayName("randomInt가 4~9이라면 자동차는 1만큼 전진한다.")
    void 자동차_전진() {
        assertRandomNumberInRangeTest(() -> {
            car.drive();
            assertThat(car.getDistance()).isEqualTo(1);
        }, 4, 9);
    }

    @Test
    @DisplayName("randomInt가 0~3이라면 자동차는 정지한다.")
    void 자동차_정지() {
        assertRandomNumberInRangeTest(() -> {
            car.drive();
            assertThat(car.getDistance()).isEqualTo(0);
        }, 0, 3);
    }
}
