package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    @DisplayName("시도 횟수가 0이하면 예외를 반환한다")
    void 시도_횟수_검증_테스트() {
        List<Car> racer = new ArrayList<>();
        int round = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(racer, round);
        });
    }
}
