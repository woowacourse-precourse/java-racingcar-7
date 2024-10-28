package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @Test
    void 라운드_결과_출력() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        car1.move();

        carList.add(car1);
        carList.add(car2);

        // when
        outputView.printRoundResult(carList);

        // then
        String expectedOutput = "실행 결과" + System.lineSeparator()
                + "car1 : -" + System.lineSeparator()
                + "car2 : " + System.lineSeparator() + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(originalOut);
    }

    @Test
    void 최종_우승자_출력() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        List<String> winnerList = List.of("car1", "car2");

        // when
        outputView.printFinalResult(winnerList);

        // then
        String expectedOutput = "최종 우승자 : car1, car2" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(originalOut);
    }
}