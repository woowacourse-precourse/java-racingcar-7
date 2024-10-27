package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car car;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 이동_거리_추가_테스트() {
        car.move();
        List<String> expectedPositions = List.of("-");
        assertEquals(expectedPositions.size(), car.getDistance());
    }

    @Test
    void 현재_위치_출력_테스트() {
        car.move();
        car.printCurrentPosition();
        String expectedOutput = "TestCar : -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void 이동_거리_반환_테스트() {
        car.move();
        car.move();
        assertEquals(2, car.getDistance());
    }

    @Test
    void 이름_반환_테스트() {
        assertEquals("TestCar", car.getName());
    }
}
