package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundResultTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("Car 리스트에서 RoundResult 생성 시 이름과 위치과 올바르게 저장되는지 테스트")
    void testRoundResultCreation() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Alpha"));
        cars.add(new Car("Bravo"));
        cars.add(new Car("Choco"));

        assertRandomNumberInRangeTest(() -> {
            cars.get(0).move();
            cars.get(1).move();
            cars.get(2).move();
            cars.get(2).move();
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP);

        RoundResult roundResult = RoundResult.recordRound(cars);

        assertThat(roundResult.getCarNames()).containsExactly("Alpha", "Bravo", "Choco");
        assertThat(roundResult.getCarPositions()).containsExactly(1, 1, 1);
    }
}
