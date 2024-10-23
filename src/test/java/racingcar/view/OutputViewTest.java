package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @Test
    void 차_이동_내역_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Car car1 = new Car("pobi");
        for (int i = 0; i < 4; i++) {
            car1.move();
        }
        Car car2 = new Car("jun");
        for (int i = 0; i < 2; i++) {
            car2.move();
        }
        List<Car> cars = Arrays.asList(car1, car2);
        String expectedOutput = "pobi : ----\njun : --\n\n";

        OutputView.printCarMove(cars);
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out);
    }

    @Test
    void 우승자_출력_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Car car1 = new Car("pobi");
        for (int i = 0; i < 4; i++) {
            car1.move();
        }
        Car car2 = new Car("jun");
        for (int i = 0; i < 2; i++) {
            car2.move();
        }
        List<Car> cars = Arrays.asList(car1, car2);
        String expectedOutput = "최종 우승자 : pobi, jun\n";

        OutputView.printFinalWinners(cars);
        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out);
    }
}
