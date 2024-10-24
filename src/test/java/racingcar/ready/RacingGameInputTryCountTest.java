package racingcar.ready;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame;

class RacingGameInputTryCountTest {
    public RacingGame racingGame;

    @BeforeEach
    public void init() {
        racingGame = new RacingGame();
    }

    @Test
    public void 시도횟수입력테스트() throws Exception {
        //given
        int tryCount = racingGame.changeTryCountToInt("5");
        //when

        //then
        assertThat(tryCount).isEqualTo(5);
    }

    @Test
    public void 시도횟수_0이하입력_예외테스트() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            racingGame.changeTryCountToInt("-1");
                }
        ).withMessage("시도 횟수는 1이상 이어야 합니다");
    }

    @Test
    public void 시도횟수_인트최대값초과_예외테스트() throws Exception {
        String inputOverInteger = String.valueOf(Integer.MAX_VALUE + 1);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
                    racingGame.changeTryCountToInt(inputOverInteger);
                }
        );
    }

}