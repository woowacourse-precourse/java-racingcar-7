package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;




public class RacingServiceTest {
    @Test
    void 단독_우승자_반환() {
        List<Integer> moveCounts = List.of(1, 3, 2);
        List<String> carNames = List.of("pobi", "jun", "seok");

        List<String> winners = RacingService.getWinners(moveCounts, carNames);
        assertThat(winners).containsExactly("jun");
    }

    @Test
    void 공동_우승자_반환() {
        List<Integer> moveCounts = List.of(1, 3, 3);
        List<String> carNames = List.of("pobi", "jun", "seok");

        List<String> winners = RacingService.getWinners(moveCounts, carNames);
        assertThat(winners).containsExactly("jun", "seok");
    }
}
