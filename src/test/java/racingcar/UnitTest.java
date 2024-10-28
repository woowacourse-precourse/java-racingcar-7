package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.view.RacingGameView;

public class UnitTest {

    @DisplayName("사용자가 정상적인 시도횟수를 입력한 경우")
    @Test
    public void testGetTrialCountValidInput() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RacingGameView view = new RacingGameView();

        int trialCount = view.getTrialCount();

        assertThat(trialCount).isEqualTo(5);
    }

    @DisplayName("사용자가 잘못된 시도횟수를 입력한 경우")
    @Test
    public void testGetTrialCountInvalidInput() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RacingGameView view = new RacingGameView();

        assertThatThrownBy(view::getTrialCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 숫자를 입력해주세요."); // 예외 메시지 검증
    }

    private RacingGameController controller;

    @BeforeEach
    public void setUp() {
        controller = new RacingGameController();

        // Car 객체 추가
        controller.cars.add(new Car("pobi"));
        controller.cars.add(new Car("min"));
        controller.cars.add(new Car("gyu"));
    }

    @Test
    public void testStartRace() {
        int trialCount = 3;

        controller.startRace(controller.cars, trialCount);

        List<Car> cars = controller.cars;
        for (Car car : cars) {
            assertThat(car.getAdvance()).isGreaterThanOrEqualTo(0); // advance 값이 0 이상인지 확인
            assertThat(car.getAdvance()).isLessThanOrEqualTo(trialCount); // advance 값이 trialCount 이하인지 확인
        }
    }
}
