package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("각 자동차의 현재 위치를 출력한다.")
    void testPrintCurrentLocationOf() {
        // given
        Car car = new Car("TestCar", 3);

        // when
        outputView.printCurrentLocationOf(car);

        // then
        assertThat(outputStream.toString().trim()).isEqualTo("TestCar : ---"); // 3개의 '-' 출력 확인
    }

    @Test
    @DisplayName("최종 우승자들의 이름을 출력한다.")
    void testPrintWinnerNames() {
        // given
        List<String> winnerNames = List.of("car1", "car2");

        // when
        outputView.printWinnerNames(winnerNames);

        // then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : car1, car2");
    }
}