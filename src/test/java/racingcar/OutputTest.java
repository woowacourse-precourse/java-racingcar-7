package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

    private Output output;
    private Cars cars;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        output = new Output();
        cars = new Cars(List.of("pobi", "woni", "jun"));

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 현재_위치_출력() {
        cars.moveCars();
        output.printCurrentPositions(cars);

        // 캡처된 출력 확인
        String consoleOutput = outputStream.toString();
        assertThat(consoleOutput).contains("pobi", "woni", "jun");
        assertThat(consoleOutput).contains(":");
    }

    @Test
    void 우승자_출력() {
        cars.getCars().get(0).move(4);
        cars.getCars().get(2).move(5);
        output.printWinners(cars);

        String consoleOutput = outputStream.toString();
        assertThat(consoleOutput).contains("최종 우승자");
        assertThat(consoleOutput).contains("pobi", "jun");
    }
}