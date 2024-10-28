package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplittingRacingCarNameTest {
    private static final String DUMMY_RACING_CAR_NAME = "ini,yoni,nini,bye";
    private static final int DUMMY_RACING_CAR_COUNT = 4;
    private static final String[] DUMMY_RACING_CAR_NAMES = {"ini", "yoni", "nini", "bye"};

    @DisplayName("자동차는 쉼표(,)를 기준으로 구분하여 생성된다.")
    @Test
    void splitRacingCarName() throws Exception{
        // given
        String playerInput = DUMMY_RACING_CAR_NAME;

        // when
        String[] result = SplittingRacingCarName.splitRacingCarName(playerInput);

        // then
        assertThat(result).hasSize(DUMMY_RACING_CAR_COUNT)
                .containsExactly(DUMMY_RACING_CAR_NAMES);
    }

}