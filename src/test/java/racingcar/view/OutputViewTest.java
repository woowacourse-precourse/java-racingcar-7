package racingcar.view;

import racingcar.domain.Car;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @Test
    public void displayCurrentPositions_ShouldPrintCorrectFormat() {
        // Given
        List<Car> cars = Arrays.asList(new Car("CarA"), new Car("CarB"));
        cars.getFirst().moveForward();

        // Capturing the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        OutputView.displayCurrentPositions(cars);

        // Then
        String expectedOutput = "실행 결과\nCarA : -\nCarB : \n\n";
        assertThat(outContent.toString()).contains(expectedOutput);
    }

    @Test
    public void announceWinners_ShouldPrintCorrectWinners() {
        // Given
        List<Car> cars = Arrays.asList(new Car("CarA"), new Car("CarB"));
        cars.get(0).moveForward(); // CarA의 위치를 1로 설정
        cars.get(1).moveForward(); // CarB의 위치를 1로 설정

        // Capturing the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        OutputView.announceWinners(cars);

        // Then
        assertThat(outContent.toString()).contains("최종 우승자 : CarA, CarB");
    }
}