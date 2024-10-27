package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("실행 결과 메시지 출력 테스트")
    void testPrintStartMessage() {
        // When
        outputView.printStartMessage();

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    @DisplayName("라운드 결과 출력 테스트")
    void testPrintRoundResult() {
        // Given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        car1.move(() -> true);
        car2.move(() -> false);
        car3.move(() -> true);

        // When
        outputView.printRoundResult(List.of(car1, car2, car3));

        // Then
        String expectedOutput = """
                pobi : -
                woni :\s
                jun : -
                """.trim();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void testPrintWinners() {
        // Given
        List<String> winners = List.of("pobi", "jun");

        // When
        outputView.printWinners(winners);

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : pobi, jun");
    }
}
