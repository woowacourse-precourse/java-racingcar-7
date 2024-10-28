package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplittingRacingCarNameTest {
    @DisplayName("자동차는 쉼표(,)를 기준으로 구분하여 생성된다.")
    @Test
    void splitRacingCarName() throws Exception{
        //given
        String playerInput = "ini,yoni,nini,bye";
        SplittingRacingCarName splittingRacingCarName = new SplittingRacingCarName();
        String[] strings = splittingRacingCarName.splitRacingCarName(playerInput);
        //when //then
        assertThat(strings).hasSize(4)
                .containsExactly(new String[]{"ini","yoni","nini","bye"});
    }

}