package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.race.Race;
import racingcar.mock.FakeNumberGenerator;

public class CarsTest {
    private static final int MOVING_FORWARD = 4;

    @Nested
    class Cars_검증_테스트 {
        @Test
        void 중복된_자동차_이름이_있을_경우_예외_발생() {
            assertThatThrownBy(() -> Cars.from("car1,car1,car2"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class Cars_우승자_테스트 {
        @Test
        void 우승자_테스트() {
            // given
            Cars cars = Cars.from("car1,car2,car3");
            Race race = Race.of("1", FakeNumberGenerator.of(MOVING_FORWARD));

            // when
            race.progress(cars);

            // then
            assertThat(cars.getWinners()).contains("car1", "car2", "car3");
        }
    }
}
