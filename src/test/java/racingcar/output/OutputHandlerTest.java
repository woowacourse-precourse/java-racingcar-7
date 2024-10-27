package racingcar.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputHandlerTest {

    private OutputHandler outputHandler;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputHandler = new OutputHandler();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("outputMessage 메서드는 주어진 메시지를 출력한다.")
    void outputMessage_printsMessage() {
        // given
        String message = "Hello, World!";

        // when
        outputHandler.outputMessage(message);

        // then
        assertEquals(message, outContent.toString());
    }

    @Test
    @DisplayName("displayCarPosition 메서드는 자동차의 이름과 위치를 출력한다.")
    void displayCarPosition_printsCarPosition() {
        // given
        Car car = new Car("jjj");
        car.move(4); // 위치 1로 이동

        // when
        outputHandler.displayCarPosition(car);

        // then
        assertEquals("jjj : -\n", outContent.toString());
    }

    @Test
    @DisplayName("displayWinners 메서드는 우승자 목록을 출력한다.")
    void displayWinners_printsWinners() {
        // given
        List<Car> winners = List.of(new Car("pobi"), new Car("jjj"));

        // when
        outputHandler.displayWinners(winners);

        // then
        assertEquals("최종 우승자 : pobi, jjj", outContent.toString());
    }
}