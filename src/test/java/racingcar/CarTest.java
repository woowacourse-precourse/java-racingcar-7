package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차의_이름을_반환한다() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차의_초기_위치는_0이다() {
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void 자동차는_랜덤숫자가_4이상일_경우_이동한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.moveOnceRandom();
                    assertThat(car.getLocation()).isEqualTo(1);

                    car.moveOnceRandom();
                    assertThat(car.getLocation()).isEqualTo(1);
                },
                4, 3
        );
    }
}