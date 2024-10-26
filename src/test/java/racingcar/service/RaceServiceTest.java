package racingcar.service;

import org.junit.jupiter.api.Test;
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
}