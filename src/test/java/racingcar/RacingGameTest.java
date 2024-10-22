package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.OngoingValue.GO;
import static racingcar.OngoingValue.STOP;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("자동차 게임 테스트")
class RacingGameTest {

    private final Cars cars = new Cars(List.of(new Car("1"), new Car("2"), new Car("3")));
    private final OngoingValueGenerator ongoingValueGenerator = new MockOngoingValueGenerator(GO, STOP, GO);

    @Nested
    class 라운드_검증 {

        @ParameterizedTest
        @ValueSource(ints = {0, 10_001})
        void 라운드가_1회_미만_혹은_10000회_초과라면_예외(int invalidRound) {
            // when & then
            assertThatThrownBy(() -> {
                new RacingGame(ongoingValueGenerator, cars, invalidRound);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 10_000})
        void 라운드가_1회_이상_10000회_이하라면_정상_진행(int round) {
            // when & then
            assertDoesNotThrow(() -> {
                new RacingGame(ongoingValueGenerator, cars, round);
            });
        }
    }

    @Nested
    class 경주_진행 {

        @Test
        void 경주가_진행되면_자동차들은_전진하고_라운드가_증가한다() {
            // given
            RacingGame racingGame = new RacingGame(ongoingValueGenerator, cars, 10);

            // when
            racingGame.progress();

            // then
            assertThat(racingGame.getCars())
                    .extracting(Car::getPosition)
                    .contains(1, 0, 1);
            assertThat(racingGame.getCurrentRound()).isEqualTo(1);
        }
    }

    @Nested
    class 게임_종료_상태_판단 {

        @Test
        void 지정된_라운드가_모두_끝났다면_경기_종료() {
            // given
            RacingGame racingGame = new RacingGame(ongoingValueGenerator, cars, 3);
            racingGame.progress();
            racingGame.progress();
            racingGame.progress();

            // when
            boolean finished = racingGame.isFinished();

            // then
            assertThat(finished).isTrue();
        }

        @Test
        void 지정된_라운드가_모두_끝나지_않았다면_경기_진행_중() {
            // given
            RacingGame racingGame = new RacingGame(ongoingValueGenerator, cars, 3);
            racingGame.progress();
            racingGame.progress();

            // when
            boolean finished = racingGame.isFinished();

            // then
            assertThat(finished).isFalse();
        }
    }
}
