package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.utils.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Nested
    @DisplayName("객체 생성 테스트")
    class CreateCarTest {
        @Test
        void 자동차에_이름을_부여_할_수_있다() {
            // given
            Car car = new Car("pobi");

            // when
            String actual = car.getName();
            String expected = "pobi";

            // then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 자동차의_처음_위치는_0이다() {
            // given
            Car car = new Car("woni");

            // when
            int actual = car.getPosition();
            int expected = 0;

            // then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("기능 테스트")
    class CarMethodTest {
        @Test
        void 무작위_값이_4이상일_경우_전진() {
            // given
            Car car = new Car("pobi", new FixedNumberGenerator(4));

            // when
            car.move();
            Car expected = new Car("pobi", 1);

            // then
            assertThat(car)
                    .usingRecursiveComparison()
                    .ignoringFields("numberGenerator")
                    .isEqualTo(expected);
        }

        @Test
        void 무작위_값이_4미만일_경우_정지() {
            // given
            Car car = new Car("pobi", new FixedNumberGenerator(1));

            // when
            car.move();
            Car expected = new Car("pobi", 0);

            // then
            assertThat(car)
                    .usingRecursiveComparison()
                    .ignoringFields("numberGenerator")
                    .isEqualTo(expected);
        }
    }
}
