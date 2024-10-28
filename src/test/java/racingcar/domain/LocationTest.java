package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {
    @DisplayName("자동차가 전진했다면, 위치를 변경(1증가)합니다.")
    @Test
    void carMoveSuccess() throws Exception{
        //given
        int startLocation = 0;
        Location init = new Location(startLocation);
        //when
        Location move = init.increase();
        //then
        assertThat(move.location()).isEqualTo(1);
    }

}