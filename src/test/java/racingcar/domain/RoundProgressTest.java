package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racingcar.constant.ExceptionMessage.NO_MORE_ROUNDS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.vo.Round;

class RoundProgressTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void 총_라운드_수로_진행상황을_생성한다(int totalRounds) {
        // when
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(totalRounds));

        // then
        assertSoftly(softly -> {
            softly.assertThat(roundProgress.hasNext())
                    .isTrue();
        });
    }

    @Test
    void 다음_라운드로_진행한다() {
        // given
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(3));

        // when & then
        assertSoftly(softly -> {
            softly.assertThat(roundProgress.hasNext()).isTrue();

            roundProgress.progress();  // 1 -> 2
            softly.assertThat(roundProgress.hasNext()).isTrue();

            roundProgress.progress();  // 2 -> 3
            softly.assertThat(roundProgress.hasNext()).isTrue();

            roundProgress.progress();  // 3 -> 4
            softly.assertThat(roundProgress.hasNext()).isFalse();
        });
    }

    @Test
    void 마지막_라운드_이후_진행시_예외를_던진다() {
        // given
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(1));
        roundProgress.progress();  // 1 -> 2

        // when & then
        assertThatThrownBy(roundProgress::progress)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(NO_MORE_ROUNDS.message());
    }

    @Test
    void 총_라운드가_1인_경우_정상_동작한다() {
        // given
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(1));

        // then
        assertSoftly(softly -> {
            softly.assertThat(roundProgress.hasNext()).isTrue();

            roundProgress.progress();
            softly.assertThat(roundProgress.hasNext()).isFalse();
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void 정확한_라운드_수만큼_진행할_수_있다(int totalRounds) {
        // given
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(totalRounds));
        int progressCount = 0;

        // when
        while (roundProgress.hasNext()) {
            roundProgress.progress();
            progressCount++;
        }

        // then
        int finalProgressCount = progressCount;
        assertSoftly(softly -> {
            softly.assertThat(finalProgressCount).isEqualTo(totalRounds);
            softly.assertThat(roundProgress.hasNext()).isFalse();
        });
    }
}
