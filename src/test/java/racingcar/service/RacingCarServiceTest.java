package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarServiceTest {
    @Test
    @DisplayName("우승자 목록 문자열 테스트")
    public void getWinnersTest() {
        //given
        String testCarNames = "a,b,c,d";
        String testNumberOfAttempts = "3";
        RacingCarService service = new RacingCarService(testCarNames,testNumberOfAttempts);
        //when
        String winners = service.getWinners();
        //then
        assertEquals("a, b, c, d", winners);
    }
}