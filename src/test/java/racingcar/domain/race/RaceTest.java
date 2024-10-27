package racingcar.domain.race;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.mock.FakeNumberGenerator;

public class RaceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Car testCar;

    @BeforeEach
    void init(){
        testCar = Car.of("car");
    }

    @Nested
    class Race_자동차_전진_테스트 {
        @Test
        void 자동차_전진_성공_테스트() {
            // given
            Race race = Race.of("1", FakeNumberGenerator.of(MOVING_FORWARD));

            // when
            race.move(testCar);

            // then
            assertThat(testCar.getPosition()).isEqualTo(1);
        }

        @Test
        void 자동차_전진_실패_테스트() {
            // given
            Race race = Race.of("1", FakeNumberGenerator.of(STOP));

            // when
            race.move(testCar);

            // then
            assertThat(testCar.getPosition()).isEqualTo(0);
        }
    }
}
