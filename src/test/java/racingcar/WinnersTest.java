package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinnersTest {

    @Test
    void findWinners() {
        Car karina = new Car("카리나", 6);
        Car winter = new Car("윈터", 6);
        Car giselle = new Car("지젤", 5);
        Car ningning = new Car("닝닝", 5);

        List<String> winners = Winners.findWinners(List.of(karina, winter, giselle, ningning), 6);

        Assertions.assertThat(winners).containsExactly("카리나", "윈터");
    }
}
