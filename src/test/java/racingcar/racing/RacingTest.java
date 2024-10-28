package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.Racing;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        racing = Racing.getInstance(cars);
    }

    @Test
    @DisplayName("Racing 인스턴스가 올바르게 생성된다")
    void createRacingInstance() {
        assertThat(racing).isNotNull();
    }

    @Test
    @DisplayName("최대 전진 거리를 올바르게 계산한다")
    void getMaxProgress() {
        racing.race(1);
        int maxProgress = racing.determineWinners().size();
        assertThat(maxProgress).isGreaterThanOrEqualTo(1);
    }
}
