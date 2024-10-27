package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingTest {

    private Racing racing;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        racing = new Racing();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 경주_시작_이름_출력_테스트() {
        List<Car> carList = createTestCarList();

        racing.start(carList, "1");

        assertTrue(outContent.toString().contains("pobi"));
        assertTrue(outContent.toString().contains("jun"));
        assertTrue(outContent.toString().contains("lisa"));
    }

    @Test
    void 우승자_결정_테스트() {
        List<Car> carList = createTestCarList();

        carList.get(0).move();
        carList.get(0).move();
        carList.get(0).move();

        List<Car> winners = racing.determineWinner(carList);

        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0).getName());
    }

    private List<Car> createTestCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("jun"));
        carList.add(new Car("lisa"));
        return carList;
    }
}
