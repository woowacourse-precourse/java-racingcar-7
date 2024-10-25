package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    void testRoundProcessingOutPut() {

        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        Cars cars = new Cars(List.of(car1, car2, car3));
        Round round = new Round(cars);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        //when
        round.process();

        //then
        String output = outputStream.toString();
        assertThat(output).contains("pobi :");
        assertThat(output).contains("woni :");
        assertThat(output).contains("jun :");
        System.setOut(originalOut);
    }
}
