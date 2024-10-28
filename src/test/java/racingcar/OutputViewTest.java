package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView = new OutputView();
    ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void printInfo() {
        outputView.printInfo();
        assertEquals("\n실행 결과\n", outContent.toString());
    }

    @Test
    void printWinner() {
        Engine engine = new RandomEngine();
        Car winner = Car.of("pobi", engine);
        outputView.printWinner(List.of(winner));
        assertEquals("최종 우승자 : pobi\n", outContent.toString());
    }

    @Test
    void printWinners() {
        Engine engine = new RandomEngine();
        List<Car> winners = List.of(Car.of("pobi", engine), Car.of("jun", engine));
        outputView.printWinner(winners);
        assertEquals("최종 우승자 : pobi, jun\n", outContent.toString());
    }

    @Test
    void printRound() {
        Engine engine = new RandomEngine();
        Car car1 = Car.of("pobi", engine);
        Car car2 = Car.of("crong", engine);
        outputView.printRound(List.of(car1, car2));
        assertEquals("pobi : \ncrong : \n\n", outContent.toString());
    }
}