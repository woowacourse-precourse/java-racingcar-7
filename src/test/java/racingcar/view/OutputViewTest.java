package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.number.TestableNumber;

class OutputViewTest {
    private static final int MOVING_FORWARD = 5;
    private static final int STOP = 3;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("단독 우승자 출력 테스트")
    void printOneWinner() {
        String winnerCarName = "pobi";

        OutputView.printWinner(List.of(winnerCarName));

        assertEquals("최종 우승자 : pobi\n", outputStream.toString());
    }

    @Test
    @DisplayName("다수의 우승자 출력 테스트")
    void printMultipleWinner() {
        List<String> winnerCarNames = List.of("pobi", "kgy", "yeoni");

        OutputView.printWinner(winnerCarNames);

        assertEquals("최종 우승자 : pobi, kgy, yeoni\n", outputStream.toString());
    }

    @Test
    @DisplayName("자동차 결과 출력 테스트")
    void printResultTest() {
        Cars cars = new Cars("pobi,woni");
        Car car1 = cars.getCars().get(0);
        Car car2 = cars.getCars().get(1);

        car1.goOrStop(new TestableNumber(MOVING_FORWARD));
        car2.goOrStop(new TestableNumber(STOP));

        OutputView.printResult(cars);

        String expectedOutput = "pobi : -\nwoni : \n\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
