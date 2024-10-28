package racingcar.racingcarTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import java.util.List;

public class GameTest {
    @Test
    @DisplayName("한명 우승자일 때")
    void 한명_우승자일_때() {
        RacingCar racingCar = new RacingCar("pobi,woni,jun");
        racingCar.results[0] = 3;
        racingCar.results[1] = 2;
        racingCar.results[2] = 1;

        List<String> winners = racingCar.getWinners();
        Assertions.assertEquals(1, winners.size());
        Assertions.assertEquals("pobi", winners.get(0));
    }

    @Test
    @DisplayName("여러 우승자일 때")
    void 여러_우승자일_때() {
        RacingCar racingCar = new RacingCar("pobi,woni,jun");
        racingCar.results[0] = 3;
        racingCar.results[1] = 3;
        racingCar.results[2] = 1;

        List<String> winners = racingCar.getWinners();
        Assertions.assertEquals(2, winners.size());
        Assertions.assertTrue(winners.contains("pobi"));
        Assertions.assertTrue(winners.contains("woni"));
    }
}
