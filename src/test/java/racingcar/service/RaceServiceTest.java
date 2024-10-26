package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.constant.Message;

import static org.junit.jupiter.api.Assertions.*;

class RaceServiceTest {
    @Test
    public void 시도할_횟수로_숫자가_정상적으로_들어온_경우() throws Exception {
        //given
        String inputRound = "5";

        //when
        RaceService raceService = new RaceService();

        //then
        assertEquals(raceService.roundService(inputRound),5);
    }

    @Test
    public void 시도할_횟수로_아무것도_안들어온_경우() throws Exception {
        //given
        String inputRound = "";

        //when
        RaceService raceService = new RaceService();

        //then
        assertThrows(IllegalArgumentException.class, () -> raceService.roundService(inputRound), Message.ROUND_EMPTY_VALIDATION_MESSAGE.getMessage());
    }
}