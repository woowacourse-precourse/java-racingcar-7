package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 초기_위치_객체를_생성한다() {
        // when
        Position position = Position.initial();

        // then
        assertThat(position.getValue()).isZero();
    }

    @Test
    void 위치를_전진시킨다() {
        // given
        Position position = Position.initial();

        // when
        Position newPosition = position.forward();

        // then
        assertSoftly(softly -> {
            softly.assertThat(newPosition.getValue())
                    .isEqualTo(1);
            softly.assertThat(position.getValue())
                    .isZero();
        });
    }

    @Test
    void 원본_위치_객체는_불변이다() {
        // given
        Position position = Position.initial();

        // when
        position.forward();

        // then
        assertThat(position.getValue()).isZero();
    }

    @Test
    void 여러번_전진이_가능하다() {
        // given
        Position position = Position.initial();

        // when
        Position result = position.forward().forward().forward();

        // then
        assertSoftly(softly -> {
            softly.assertThat(result.getValue())
                    .isEqualTo(3);
            softly.assertThat(position.getValue())
                    .isZero();
        });
    }

    @Test
    void 동일한_값을_가진_위치_객체는_동등하다() {
        // given
        Position position1 = Position.initial().forward();
        Position position2 = Position.initial().forward();
        Position differentPosition = Position.initial().forward().forward();

        // then
        assertSoftly(softly -> {
            softly.assertThat(position1)
                    .isEqualTo(position2);
            softly.assertThat(position1)
                    .isNotEqualTo(differentPosition);
            softly.assertThat(position1.hashCode())
                    .isEqualTo(position2.hashCode());
        });
    }

    @Test
    void Null_과_다른_타입_객체와_비교시_동등하지_않다() {
        // given
        Position position = Position.initial();
        Object differentType = "0";

        // then
        assertSoftly(softly -> {
            softly.assertThat(position)
                    .isNotEqualTo(null);
            softly.assertThat(position)
                    .isNotEqualTo(differentType);
        });
    }

    @Test
    void 위치_객체들을_비교_정렬할_수_있다() {
        // given
        Position position0 = Position.initial();
        Position position1 = Position.initial().forward();
        Position position2 = Position.initial().forward().forward();
        List<Position> positions = Arrays.asList(position2, position0, position1);

        // when
        List<Position> sortedPositions = positions.stream().sorted().toList();

        // then
        assertSoftly(softly -> {
            softly.assertThat(sortedPositions)
                    .containsExactly(position0, position1, position2);
            softly.assertThat(position0.compareTo(position1))
                    .isNegative();
            softly.assertThat(position2.compareTo(position1))
                    .isPositive();
            softly.assertThat(position1.compareTo(position1))
                    .isZero();
        });
    }
}
