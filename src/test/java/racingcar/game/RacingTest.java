package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("단일 우승자 검증")
    @Test
    void validateSingleWinner() {
        //given
        String names = "pobi,woni";
        String roundNumber = "1";
        Racing racing = new Racing(names, roundNumber);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racing.start();

                    // then
                    List<Car> winners = racing.getWinners();
                    assertThat(winners).hasSize(1);
                    assertThat(winners.get(0).getName()).isEqualTo("pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("다중 우승자 검증")
    @Test
    void validateMultipleWinner() {
        // given
        String names = "pobi,woni,jun";
        String roundNumber = "1";
        Racing racing = new Racing(names, roundNumber);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racing.start();

                    // then
                    List<Car> winners = racing.getWinners();
                    assertThat(winners).hasSize(2);
                    assertThat(winners.get(0).getName()).isEqualTo("pobi");
                    assertThat(winners.get(1).getName()).isEqualTo("woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("이동 상태 검증")
    @Test
    void validateMove() {
        // given
        String names = "pobi";
        String roundNumber = "1";
        Racing racing = new Racing(names, roundNumber);

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    racing.start();

                    // then
                    assertThat(racing.getCars().get(0).getPosition()).isEqualTo(1);
                },
                MOVING_FORWARD, STOP
        );
    }

    @DisplayName("라운드 수 음수 예외")
    @Test
    void validateRoundNumberNegative() {
        // given
        String names = "pobi";
        String roundNumber = "-1";

        // when & then
        assertThatThrownBy(() -> new Racing(names, roundNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("라운드 수 0 예외")
    @Test
    void validateRoundNumberZero() {
        // given
        String names = "pobi";
        String roundNumber = "0";

        // when & then
        assertThatThrownBy(() -> new Racing(names, roundNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
