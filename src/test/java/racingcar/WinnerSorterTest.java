package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinnerSorterTest {

    @Test
    @DisplayName("forwardCount가 동일한 모두를 우승자로 출력한다.")
    void testGetJointWinners() {

        TreeMap<String, Integer> forwardCounter = new TreeMap<>();
        forwardCounter.put("bora", 3);
        forwardCounter.put("tubi", 3);
        forwardCounter.put("nana", 3);
        forwardCounter.put("po", 3);
        List<String> winnerList = Arrays.asList("bora", "tubi", "nana", "po");

        assertThat(WinnerSorter.getJointWinners(forwardCounter)).containsAll(winnerList);
    }

    @Test
    @DisplayName("forwardCount가 동일한 일부만 우승자로 출력한다.")
    void testGetJointWinnersTop() {

        TreeMap<String, Integer> forwardCounter = new TreeMap<>();
        forwardCounter.put("bora", 1);
        forwardCounter.put("tubi", 3);
        forwardCounter.put("nana", 1);
        forwardCounter.put("po", 3);
        List<String> winnerList = Arrays.asList("tubi", "po");

        assertThat(WinnerSorter.getJointWinners(forwardCounter)).containsAll(winnerList);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 10, Integer.MAX_VALUE})
    @DisplayName("forwardCount는 winnerValue보다 작거나 같다.")
    void testAddJointWinner(int forwardCount) {
        int winnerValue = 3;
        List<String> winnerList = Arrays.asList("tubi");

        assertThatThrownBy(() -> WinnerSorter.addJointWinner("po", forwardCount, winnerValue, winnerList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
