package racingcar.view;

import racingcar.model.Car;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @Test
    public void 테스트_라운드_결과_출력() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move();
        car1.move();
        car2.move();
        List<Car> cars = Arrays.asList(car1, car2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printRoundResult(cars);

        String expectedOutput = "pobi : --\n" +
                "woni : -\n" +
                "\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));

        System.setOut(System.out);
    }

    @Test
    public void 테스트_우승자_출력() {
        List<String> winners = Arrays.asList("pobi", "woni");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printWinners(winners);

        String expectedOutput = "최종 우승자 : pobi, woni\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));

        System.setOut(System.out);
    }
}
