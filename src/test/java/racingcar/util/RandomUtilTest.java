package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @Test
    void 리스트에서_최댓값_반환() {
        List<Integer> moveCounts = List.of(1, 2, 5, 3);
        int maxValue = RandomUtil.getMaxValueFromList(moveCounts);

        assertThat(maxValue).isEqualTo(5);
    }
    
    @Test
    void 이동_횟수에_따른_우승자_반환() {
        List<Integer> moveCounts = List.of(1, 5, 2);
        int moveCount = 5;
        List<String> carNames = List.of("pobi", "jun", "seok");
        List<String> winnerNames = RandomUtil.getWinnersByMoveCount(moveCounts, moveCount, carNames);

        assertThat(winnerNames).containsExactly("jun");
    }
}
