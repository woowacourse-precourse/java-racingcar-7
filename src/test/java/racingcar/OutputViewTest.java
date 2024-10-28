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
        assertEquals("실행 결과\n", outContent.toString());
    }

    @Test
    void printWinner() {
        RandomCar winner = new RandomCar("pobi");
        outputView.printWinner(winner);
        assertEquals("최종 우승자 : pobi\n", outContent.toString());
    }

    @Test
    void printWinners() {
        List<Car> winners = List.of(new RandomCar("pobi"), new RandomCar("jun"));
        outputView.printWinner(winners);
        assertEquals("최종 우승자 : pobi, jun\n", outContent.toString());
    }
}