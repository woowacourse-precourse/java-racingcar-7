package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.view.RacingGameView;

public class UnitTest {
    private RacingGameController controller;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // ByteArrayOutputStream 선언

    @BeforeEach
    public void setUp() {
        controller = new RacingGameController();
        System.setOut(new PrintStream(outContent)); // 표준 출력을 ByteArrayOutputStream으로 리디렉션

        // Car 객체 추가
        controller.cars.add(new Car("pobi"));
        controller.cars.add(new Car("min"));
        controller.cars.add(new Car("gyu"));
    }

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

    @DisplayName("경주 시작후 자동차들이 잘 전진하는지 확인하는 테스트 메서드")
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

    @DisplayName("가장 많이 전진한 차량이 우승자로 출력되는지 확인하는 메서드")
    @Test
    public void testShowFinalWinner() {
        RacingGameView view = new RacingGameView();

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        car1.setAdvance(3);
        Car car2 = new Car("min");
        car2.setAdvance(5);
        Car car3 = new Car("gyu");
        car3.setAdvance(5);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        view.showFinalWinner(cars);

        String expectedOutput = "최종 우승자 : min, gyu\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
