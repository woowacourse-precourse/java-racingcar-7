package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outputStream;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        standardOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("실행 결과 시작 메시지를 출력한다")
    void printResultStart() {
        outputView.printResultStart();

        assertThat(outputStream.toString()).contains("실행 결과");
    }

    @Test
    @DisplayName("자동차들의 위치를 출력한다")
    void printRoundResult() {
        // given
        Car car1 = new Car("pobi", 2);  // 직접 위치 설정
        Car car2 = new Car("woni", 3);  // 직접 위치 설정

        // when
        outputView.printRoundResult(List.of(car1, car2));

        // then
        String result = outputStream.toString();
        assertThat(result)
                .contains("pobi : --")
                .contains("woni : ---");
    }

    @Test
    @DisplayName("우승자를 출력한다")
    void printWinners() {
        // given
        Car car1 = new Car("pobi", 5);  // 동일한 위치로 설정
        Car car2 = new Car("woni", 5);  // 동일한 위치로 설정
        List<Car> winners = List.of(car1, car2);

        // when
        outputView.printWinners(winners);

        // then
        assertThat(outputStream.toString())
                .contains("최종 우승자 : pobi, woni");
    }
}
