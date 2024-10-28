package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingInfo;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    private Racing racing;

    @Test
    @DisplayName("자동차이름과_시도횟수_정상입력")
    void 자동차이름과_시도횟수_정상입력() {
        // given
        RacingInfo validRacingInfo = new RacingInfo(
                "pobi,choon,jason",
                3
        );
        
        // when
        racing = new Racing(validRacingInfo);
        racing.start();
        
        // then
        String actualWinners = racing.getWinners();
        assertThat(actualWinners).isIn("pobi", "choon", "jason");
    }

    @Test
    @DisplayName("자동차이름이_공백인경우_예외발생")
    void 자동차이름이_공백인경우_예외발생() {
        // given
        RacingInfo carNameEmpty = new RacingInfo(
                "",
                3
        );

        // then
        assertThatThrownBy(() -> {
            // when
            racing = new Racing(carNameEmpty);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}