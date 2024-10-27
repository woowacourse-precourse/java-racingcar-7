package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarOutputHandlerTest {
    private CarOutputHandler carOutputHandler;
    private List<Car> carList;

    @BeforeEach
    public void setUp() {
        carOutputHandler = new CarOutputHandler();
        carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("woni"));
    }

    @Test
    public void 경주_실행_테스트() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        carOutputHandler.runRace(carList, 3);

        String output = outputStream.toString();
        assert(output.contains("실행 결과"));
        assert(output.contains("최종 우승자 :"));

        System.setOut(originalOut);
    }

    @Test
    public void 우승자_찾기_테스트() {
        carList.get(0).carPosition = 3;
        carList.get(1).carPosition = 3;

        List<Car> winners = carOutputHandler.findRacingWinners(carList);
        assertEquals(2, winners.size());
        assertEquals("pobi", winners.get(0).getCarName());
        assertEquals("woni", winners.get(1).getCarName());
    }
}
