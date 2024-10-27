package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ExceptionMessage.INVALID_ROUND_MIN;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @Test
    void 유효한_라운드_값으로_객체를_생성한다() {
        // when
        Round round = Round.from(0);

        // then
        assertThat(round.getCount()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100, Integer.MIN_VALUE})
    void 최소값보다_작은_라운드로_생성시_예외를_던진다(int invalidValue) {
        // when & then
        assertThatThrownBy(() -> Round.from(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ROUND_MIN.format(0));
    }

    @Test
    void 다음_라운드_객체를_생성한다() {
        // given
        Round round = Round.from(0);

        // when
        Round nextRound = round.next();

        // then
        assertThat(nextRound.getCount()).isEqualTo(1);
    }

    @Test
    void 원본_라운드_객체는_불변이다() {
        // given
        Round round = Round.from(5);

        // when
        round.next();

        // then
        assertThat(round.getCount()).isEqualTo(5);
    }

    @Test
    void 여러번_다음_라운드_생성이_가능하다() {
        // given
        Round round = Round.from(0);

        // when
        Round result = round.next().next().next();

        // then
        assertThat(result.getCount()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, Integer.MAX_VALUE - 1})
    void 다양한_유효한_라운드_값으로_객체를_생성한다(int validValue) {
        // when
        Round round = Round.from(validValue);

        // then
        assertThat(round.getCount()).isEqualTo(validValue);
    }

    @Test
    void 최대_정수값_이전까지_다음_라운드_생성이_가능하다() {
        // given
        Round round = Round.from(Integer.MAX_VALUE - 1);

        // when
        Round nextRound = round.next();

        // then
        assertThat(nextRound.getCount()).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void 동일한_값을_가진_라운드_객체는_동등하다() {
        // given
        Round round1 = Round.from(5);
        Round round2 = Round.from(5);
        Round differentRound = Round.from(6);

        // then
        assertThat(round1)
                .isEqualTo(round2)
                .isNotEqualTo(differentRound);
    }

    @Test
    void 동일한_값을_가진_라운드_객체는_동일한_해시코드를_가진다() {
        // given
        Round round1 = Round.from(5);
        Round round2 = Round.from(5);

        // then
        assertThat(round1.hashCode()).isEqualTo(round2.hashCode());
    }

    @Test
    void Null과_비교시_동등하지_않다() {
        // given
        Round round = Round.from(5);

        // then
        assertThat(round).isNotEqualTo(null);
    }

    @Test
    void 다른_타입의_객체와_비교시_동등하지_않다() {
        // given
        Round round = Round.from(5);
        Object differentType = "5";

        // then
        assertThat(round).isNotEqualTo(differentType);
    }
}