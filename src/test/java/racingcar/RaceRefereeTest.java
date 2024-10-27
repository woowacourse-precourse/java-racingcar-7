package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceRefereeTest {
    
    @Test
    @DisplayName("라운드는 음수일 수 없다")
    public void givenNegativeRound_thenThrowException() {
        //given
        int negativeRound = -1;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> RaceReferee.from(negativeRound));
    }

}