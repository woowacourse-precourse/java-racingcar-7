package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomCarTest {
    @Nested
    class TestMove {
        @ParameterizedTest
        @ValueSource(ints = {0, 10, 20, 30, 100, 1_000})
        void should_position_in_range_0_to_move_count(int moveCount) {
            // given
            RandomCar randomCar = new RandomCar("car1");

            // when
            for (int i = 0; i < moveCount; i++) {
                randomCar.move();
            }

            // then
            assertThat(randomCar.position).isBetween(0, moveCount);
        }

        // Yeah, this test is not deterministic. But without test doubles, it's my best shot.
        @Test
        void maybe_increase_position_in_many_trials() {
            // given
            RandomCar randomCar = new RandomCar("car1");
            final int TRIAL_COUNT = 1_000;

            // when
            for (int i = 0; i < TRIAL_COUNT; i++) {
                randomCar.move();
            }

            // then
            assertThat(randomCar.position).isGreaterThan(0);
        }
    }

    @Nested
    class TestCheckName {
        @Test
        void should_ok_when_name_shorter_than_equal_5() {
            // given
            String shorterThanEqual5Name = "short";

            // when
            RandomCar randomCar = new RandomCar(shorterThanEqual5Name);

            // then
            assertThat(randomCar).isNotNull();
        }

        @Test
        void should_throw_when_name_longer_than_5() {
            // given
            String longerThan5Name = "longerThan5Name";

            // when, then
            assertThatThrownBy(() -> new RandomCar(longerThan5Name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void should_throw_when_name_is_null() {
            // given
            String nullName = null;

            // when, then
            assertThatThrownBy(() -> new RandomCar(nullName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void should_throw_when_name_is_blank() {
            // given
            String blankName = "";

            // when, then
            assertThatThrownBy(() -> new RandomCar(blankName))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class TestIsSamePosition {
        @Test
        void should_return_true_when_same_position() {
            // given
            RandomCar randomCar1 = new RandomCar("car1");
            RandomCar randomCar2 = new RandomCar("car2");

            // when
            randomCar1.position = 1;
            randomCar2.position = 1;

            // then
            assertThat(randomCar1.isSamePosition(randomCar2)).isTrue();
        }

        @Test
        void should_return_false_when_different_position() {
            // given
            RandomCar randomCar1 = new RandomCar("car1");
            RandomCar randomCar2 = new RandomCar("car2");

            // when
            randomCar1.position = 1;
            randomCar2.position = 2;

            // then
            assertThat(randomCar1.isSamePosition(randomCar2)).isFalse();
        }
    }

    @Nested
    class TestCompareTo {
        @Test
        void should_return_negative_when_further_lhs() {
            // given
            RandomCar randomCar1 = new RandomCar("car1");
            RandomCar randomCar2 = new RandomCar("car2");

            // when
            randomCar1.position = 1;
            randomCar2.position = 2;

            // then
            assertThat(randomCar1.compareTo(randomCar2)).isEqualTo(-1);
        }

        @Test
        void should_return_positive_when_further_rhs() {
            // given
            RandomCar randomCar1 = new RandomCar("car1");
            RandomCar randomCar2 = new RandomCar("car2");

            // when
            randomCar1.position = 2;
            randomCar2.position = 1;

            // then
            assertThat(randomCar1.compareTo(randomCar2)).isEqualTo(1);
        }

        @Test
        void should_return_zero_when_same_position() {
            // given
            RandomCar randomCar1 = new RandomCar("car1");
            RandomCar randomCar2 = new RandomCar("car2");

            // when
            randomCar1.position = 1;
            randomCar2.position = 1;

            // then
            assertThat(randomCar1.compareTo(randomCar2)).isEqualTo(0);
        }
    }

    @Nested
    class TestToString {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3, 4, 5})
        void should_start_with_name_than_repeat_dash_position_times(int position) {
            // given
            RandomCar randomCar = new RandomCar("car1");
            randomCar.position = position;

            // when
            String actual = randomCar.toString();

            // then
            assertThat(actual).isEqualTo("car1 : " + "-".repeat(position));
        }
    }
}
