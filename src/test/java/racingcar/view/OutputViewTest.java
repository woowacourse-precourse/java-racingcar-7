package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class OutputViewTest {
    @Test
    void 중간_결과_출력_테스트() {
        List<Car> car = Arrays.asList(new Car("pobi"));
        for (int i = 0; i < car.size(); i++) {
            car.get(i).increaseScore();
        }
        String expectedOutput = "pobi : -\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printIntermediateResults(car);
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @Test
    void 우승자_출력_테스트() {
        List<Car> winners = Arrays.asList(new Car("pobi"), new Car("crong"));
        String expectedOutput = "최종 우승자 : pobi, crong\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printFinalResults(winners);
        assertEquals(expectedOutput, outputStream.toString());
    }

}
