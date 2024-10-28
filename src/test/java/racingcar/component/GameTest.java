package racingcar.component;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    @Nested
    class create {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        void 올바른_라운드가_입력되면_생성된다(int round) {
            List<Car> cars = Car.makeListFrom("pobi,woni");

            assertThatNoException().isThrownBy(() -> new Game(cars, round));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, 11})
        void 잘못된_라운드가_입력되면_예외가_발생한다(int round) {
            List<Car> cars = Car.makeListFrom("pobi,woni");

            assertThatThrownBy(() -> new Game(cars, round))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class round extends NsTest {
        private static final int MOVING_FORWARD = 4;
        private static final int STOP = 3;

        @Test
        void 라운드가_진행되면_자동차들이_움직인다() {
            assertRandomNumberInRangeTest(() -> {
                List<Car> cars = Car.makeListFrom("pobi,woni");
                Game game = new Game(cars, 3);

                game.start();

                List<String> result = Arrays.asList(output().split("\n"));

                assertThat(result).contains("pobi : -", "woni : ", "pobi : --", "pobi : ---");
            }, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP);
        }

        @Test
        void 라운드가_종료되면_우승자를_출력한다() {
            assertRandomNumberInRangeTest(() -> {
                List<Car> cars = Car.makeListFrom("pobi,woni");
                Game game = new Game(cars, 1);

                game.start();
                game.finish();

                assertThat(output()).contains("최종 우승자 : pobi");
            }, MOVING_FORWARD, STOP);
        }

        @Override
        protected void runMain() {

        }
    }
}