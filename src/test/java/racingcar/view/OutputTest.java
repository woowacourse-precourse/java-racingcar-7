package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.Output;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Output output;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // System.out 출력을 캡처
        output = new Output();
    }

    @Test
    void printExecutionResult_출력() {
        output.printExecutionResult();

        assertThat(outContent.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    void printRoundResult_출력() {
        // 자동차 상태 설정
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");

        car1.move(4); // 위치가 4로 설정
        car2.move(5); // 위치가 5로 설정

        Cars cars = new Cars(List.of(car1, car2));

        output.printRoundResult(cars);

        // 예상 출력 확인 (위치에 맞는 "-" 개수)
        String expectedOutput = "pobi : ----\ncrong : -----\n";
        assertThat(outContent.toString().trim()).isEqualTo(expectedOutput.trim());
    }
    @Test
    void printWinners_출력() {
        List<String> winners = List.of("pobi", "crong");

        output.printWinners(winners);

        assertThat(outContent.toString().trim()).isEqualTo("최종 우승자 : pobi, crong");
    }
}
