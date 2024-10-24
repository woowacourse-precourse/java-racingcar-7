package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.game.GameUtil;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

 class GameTest {


    @ParameterizedTest
    @ValueSource(ints = {9, 8, 7, 6, 5, 4, 3, 2, 1})
    @DisplayName("차량의 전진 OR 정지 판단")
    void 전진_아니면_정지(int number) {
        var result = GameUtil.goOrStop(number);

        if (number >= 4)
            assertThat(result).isEqualTo("-");
        else
            assertThat(result).isEmpty();
    }
}
