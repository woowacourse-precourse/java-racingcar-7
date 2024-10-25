package racingcar;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    void testSplitCarNames() {
        //이름이 잘못 들어온 경우

        List<String> carNames = racingCarService.splitCarNames("car1,car2,car3");
        List<String> resultCarNames = Arrays.asList("car1", "car2", "car3");

        Assertions.assertEquals(carNames, resultCarNames);
    }
}