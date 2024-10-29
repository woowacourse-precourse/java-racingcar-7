package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    void printTitle() {
        OutputView.printTitle();
        assertEquals("\n실행 결과\r\n", outputMessage.toString());
    }

    @Test
    void printRaceResult() {
        List<Car> cars = new ArrayList<>();
        List<String> name = List.of("a", "b", "c");
        List<Integer> progress = List.of(1, 2, 3);
        for (int i = 0; i < 3; i++) {
            cars.add(new Car(name.get(i), progress.get(i)));
        }

        OutputView.printRaceResult(cars);
        assertEquals("a : -\r\nb : --\r\nc : ---\r\n\r\n", outputMessage.toString());
    }

    @Test
    void printWinner() {
        List<String> winner = List.of("a", "b");
        OutputView.printWinner(winner);
        assertEquals("최종 우승자 : a, b\r\n", outputMessage.toString());
    }
}