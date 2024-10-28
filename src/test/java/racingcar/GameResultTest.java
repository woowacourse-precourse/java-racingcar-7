package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    @Test
    void 단독_우승자_찾기() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(4);
        GameResult gameResult = new GameResult();
        List<String> winners = gameResult.findWinners(Arrays.asList(car1, car2));
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 공동_우승자_찾기() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(4);
        car2.move(4);
        GameResult gameResult = new GameResult();
        List<String> winners = gameResult.findWinners(Arrays.asList(car1, car2));
        assertThat(winners).containsExactly("pobi", "woni");
    }
}