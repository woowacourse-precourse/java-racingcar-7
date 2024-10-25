package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    private Output output;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream realOutput = System.out;

    @BeforeEach
    void init(){
        output = new Output();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void out(){
        System.setOut(realOutput);
    }

    @Test
    void 라운드_현황_테스트(){
        List<Car> cars = Arrays.asList(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();
        cars.get(2).move();

        output.printRoundResult(cars);

        String expected = "pobi : -\n"+
                            "woni : -\n"+
                            "jun : --\n\n";
        assertEquals(expected, outputStream.toString().replace("\r\n", "\n"));
    }
}
