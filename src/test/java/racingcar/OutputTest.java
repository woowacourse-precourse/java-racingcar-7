package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }


    @Test
    public void 우승자_여러명_출력_테스트(){
        List<String> winners = List.of("pobi","jun");
        Output.printWinner(winners);
        assertEquals("최종 우승자 : pobi, jun\n", getOutput());
    }

    @Test
    public void 우승자_한명_출력_테스트(){
        List<String> winners = List.of("pobi");
        Output.printWinner(winners);
        assertEquals("최종 우승자 : pobi\n", getOutput());
    }

    @Test
    public void 자동차별_실행결과_출력_테스트(){
        Car car = new Car("pobi");
        car.addPosition();
        car.addPosition();

        Output.printCarPosition(car);
        assertEquals("pobi : --\n",getOutput());
    }
}