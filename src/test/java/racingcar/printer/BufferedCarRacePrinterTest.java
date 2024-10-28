package racingcar.printer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BufferedCarRacePrinterTest {

    @Test
    @DisplayName("자동차 경주 중간집계 정상 출력")
    void success_PrintProgress() {
        // Given
        StringWriter stringWriter = new StringWriter();
        BufferedCarRacePrinter printer = new BufferedCarRacePrinter(stringWriter);
        List<Car> cars = Arrays.asList(
            new Car("pobi"),
            new Car("woni"),
            new Car("jun")
        );
        // Simulate moves
        cars.get(0).move(() -> true); // pobi: 1
        cars.get(0).move(() -> true); // pobi: 2
        cars.get(1).move(() -> false); // woni: 0
        cars.get(2).move(() -> true); // jun: 1

        // When
        printer.writeProgress(cars);
        printer.printProgress();

        // Then
        String expectedOutput = "pobi : --\nwoni : \njun : -\n\n";
        assertThat(stringWriter.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("메세지 정상 출력")
    void success_PrintMessage() {
        // Given
        StringWriter stringWriter = new StringWriter();
        BufferedCarRacePrinter printer = new BufferedCarRacePrinter(stringWriter);
        String message = "테스트 메세지 출력";

        // When
        printer.printMessage(message);

        // Then
        String expectedOutput = "테스트 메세지 출력";
        assertThat(stringWriter.toString()).isEqualTo(expectedOutput);
    }
}