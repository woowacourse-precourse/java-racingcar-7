package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;
    private View view;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        view = new View();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 실행_결과는_자동차_이름_입력순으로_보여준다() {
        List<Car> roundResult = new ArrayList<>();
        roundResult.add(new Car("test1"));
        roundResult.add(new Car("test2"));
        roundResult.add(new Car("test3"));

        int attempts = 1;
        for (Car car : roundResult) {
            for(int i=1; i<=attempts; i++) {
                car.moveForward();
            }
            attempts++;
        }

        view.print(roundResult);

        String expectedOutput = "test1 : -\ntest2 : --\ntest3 : ---\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void 우승자가_여러명일_경우_쉼표를_통해_구분한다() {
        List<String> winners = new ArrayList<>();
        winners.add("test1");
        winners.add("test2");
        winners.add("test3");

        view.printFinalResult(winners);

        String expectedOutput = "최종 우승자 : test1, test2, test3";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
