package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    void 자동차_전진_조건() {
        int randomNumberOne = 1;
        int randomNumberTwo = 4;
        boolean result1 = racingCarService.moveOrStop(randomNumberOne);
        boolean result2 = racingCarService.moveOrStop(randomNumberTwo);

        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    void 랜덤_숫자_생성() {
        int expect = racingCarService.randomNumberCreate();
        boolean result = expect >= 0 && expect <= 9;
        assertTrue(result);
    }

    @Test
    void 입력값_리스트로_분리() {
        String input = "qw,er,ty";
        List<RacingCar> resultList = racingCarService.getCarListFromInput(input);
        Set<String> resultSet = new HashSet<>();
        for (RacingCar car : resultList) {
            resultSet.add(car.getName());
        }
        Set<String> expectSet = new HashSet<>();
        expectSet.add("qw");
        expectSet.add("er");
        expectSet.add("ty");

        assertEquals(expectSet, resultSet);
    }

    @Test
    void 자동차_전진_시_currentMovingPoint_증가() {
        int input = 6;
        RacingCar racingCar = new RacingCar("pobi", "");
        racingCarService.increasingCurrentMovingPoint(racingCar, input);
        assertEquals("-", racingCar.getCurrentMovingPoint());
        racingCarService.increasingCurrentMovingPoint(racingCar, input);
        assertEquals("--", racingCar.getCurrentMovingPoint());
    }
}
