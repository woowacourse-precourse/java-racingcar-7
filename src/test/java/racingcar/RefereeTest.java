package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 단일_우승자_판단() {
        // give
        Referee referee = new Referee();

        Map<String, Integer> carsDecision = new LinkedHashMap<>();
        carsDecision.put("소정", 3);
        carsDecision.put("pobi", 2);
        carsDecision.put("woni", 1);

        List<String> expectedWinners = List.of("소정");

        // when
        List<String> actualWinner = referee.judgmentWinner(carsDecision);

        // then
        Assertions.assertThat(actualWinner).isEqualTo(expectedWinners);
    }

    @Test
    void 공동_우승자_판단() {
        // give
        Referee referee = new Referee();

        Map<String, Integer> carsDecision = new LinkedHashMap<>();
        carsDecision.put("소정", 3);
        carsDecision.put("pobi", 3);
        carsDecision.put("woni", 2);

        List<String> expectedWinners = List.of("소정", "pobi");

        // when
        List<String> actualWinner = referee.judgmentWinner(carsDecision);

        // then
        Assertions.assertThat(actualWinner).isEqualTo(expectedWinners);
    }
}
