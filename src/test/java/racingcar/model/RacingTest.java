package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    void 초기_우승_거리_확인_테스트() {
        // given
        int expectedDistance = 0;

        // when
        int winnerDistance = racing.getWinnerDistance();

        // then
        assertEquals(expectedDistance, winnerDistance);
    }

    @Test
    void 우승_거리_설정_테스트() {
        // given
        int newWinnerDistance = 10;

        // when
        racing.setWinnerDistance(newWinnerDistance);

        // then
        assertEquals(newWinnerDistance, racing.getWinnerDistance());
    }

    @Test
    void 초기_우승자_리스트_확인_테스트() {
        // given
        int expectedSize = 0;

        // when
        List<String> winnerNames = racing.getWinnerNames();

        // then
        assertEquals(expectedSize, winnerNames.size());
    }

    @Test
    void 우승자_추가_테스트() {
        // given
        String winnerName = "pobi";

        // when
        racing.getWinnerNames().add(winnerName);

        // then
        assertEquals(1, racing.getWinnerNames().size());
        assertTrue(racing.getWinnerNames().contains(winnerName));
    }

    @Test
    void 여러_우승자_추가_테스트() {
        // given
        String winnerName1 = "pobi";
        String winnerName2 = "woni";

        // when
        racing.getWinnerNames().add(winnerName1);
        racing.getWinnerNames().add(winnerName2);

        // then
        assertEquals(2, racing.getWinnerNames().size());
        assertTrue(racing.getWinnerNames().contains(winnerName1));
        assertTrue(racing.getWinnerNames().contains(winnerName2));
    }
}
