package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    @Test
    void 기능_테스트() {
        // 횟수 검증
        assertThatNoException().isThrownBy(() -> {
            int trySize = 10;
            RacingGame game = new RacingGame(List.of("a","b","c"), trySize);
            for (int i = 0; i < trySize; i++) {
                game.startOneStep();
            }
        });
    }
    
    @Test
    void 예외_테스트() {
        // 횟수 초과시
        assertThatThrownBy(() -> {
            int trySize = 10;
            RacingGame game = new RacingGame(List.of("a","b","c"), trySize);
            for (int i = 0; i < trySize + 1; i++) {
                game.startOneStep();
            }
        });
    }
}
