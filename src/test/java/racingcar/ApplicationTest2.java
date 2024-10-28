package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest2 {

    @Test
    @DisplayName("자동차 위치 최대값 찾기 Test")
    void findMaxPositionTest() {
        int[] carPositions = {3,5,2,5,1};

        int maxPosition = Application.findMaxPosition(carPositions);

        assertThat(maxPosition).isEqualTo(5);
    }

    @Test
    @DisplayName("최종 우승자 찾기 Test")
    void findWinnersTest() {

        String[] carNames = {"min","seo","jeo","ng"};
        int[] carPositions = {3,5,2,5};

        StringBuilder winners = Application.getWinners(carNames, carPositions,5);

        assertThat(winners.toString()).isEqualTo("seo, ng");

    }
}
