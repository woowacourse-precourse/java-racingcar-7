package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.ReflectionUtils.HierarchyTraversalMode;

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

    @Test
    void 우승자_반환_테스트_단독() {
        Car car1 = new Car("temp1");
        Car car2 = new Car("temp2");
        RacingGame racingGame = new RacingGame(new ArrayList<>(Arrays.asList(car1, car2)), 1);

        car1.go(5);
        car1.go(5);
        car1.go(5);

        racingGame.progress();
        List<String> winner = racingGame.selectWinner();

        assertThat(winner).containsExactly("temp1");
    }
}
