package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void attemptStatus() {
        Game game = new Game(List.of("pobi", "jun"));
        game.attemptStatus();
        List<Integer> position = game.getCarPositions();
        for (int i = 0; i < position.size(); i++) {
            Assertions.assertThat(position.get(i)).isGreaterThanOrEqualTo(0);
        }
    }
}