package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

public class ResultViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ResultView resultView;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        resultView = new ResultView();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("라운드 결과 출력 테스트")
    void 라운드_결과_출력_테스트() {
        List<Car> cars = Arrays.asList(new Car("CarA"), new Car("CarB"), new Car("CarC"));
        cars.get(0).move(4);
        cars.get(1).move(3);
        cars.get(2).move(4);

        resultView.printRoundResult(cars);

        String expectedOutput = "CarA : -"+System.lineSeparator() +
                "CarB : "+System.lineSeparator() +
                "CarC : -"+System.lineSeparator() + System.lineSeparator();

        String actualOutput = outputStreamCaptor.toString();
        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void 우승자_출력_테스트() {
        Car carA = new Car("CarA");
        Car carB = new Car("CarB");

        carA.move(4);
        carB.move(4);

        List<Car> winners = Arrays.asList(carA, carB);

        resultView.printWinners(winners);

        String expectedOutput = "최종 우승자 : CarA, CarB" + System.lineSeparator();
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
