package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

class DecideWinnerTest {
    @Test
    void 승자_결정_테스트_단독우승() {
        List<String> carNames = List.of("pobi", "minju", "java");
        List<Integer> progresses = List.of(4, 1, 3);
        Cars testCar = new Cars(carNames, progresses);
        List<String> expectedWinner = List.of("pobi");

        List<String> actualWinner = testCar.decideWinner();
        Assertions.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void 승자_결정_테스트_공동우승() {
        List<String> carNames = List.of("pobi", "minju", "java");
        List<Integer> progresses = List.of(3, 1, 3);
        Cars testCar = new Cars(carNames, progresses);
        List<String> expectedWinner = List.of("pobi", "java");

        List<String> actualWinner = testCar.decideWinner();
        Assertions.assertEquals(expectedWinner, actualWinner);
    }
}
