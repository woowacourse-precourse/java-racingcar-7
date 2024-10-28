package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarImpl;

public class WinnerTest {
    @Test
    @DisplayName("동점")
    public void testSame() {
        Car car1 = new CarImpl("1");
        Car car2 = new CarImpl("2");

        car1.forward();
        car2.forward();
        List<String> winnersName = CarGame.getWinnersName(List.of(car1, car2));
        Assertions.assertEquals("1", winnersName.get(0));
        Assertions.assertEquals("2", winnersName.get(1));
    }

    @Test
    @DisplayName("0점으로 동점")
    public void testSameZero() {
        Car car1 = new CarImpl("1");
        Car car2 = new CarImpl("2");

        List<String> winnersName = CarGame.getWinnersName(List.of(car1, car2));
        Assertions.assertEquals("1", winnersName.get(0));
        Assertions.assertEquals("2", winnersName.get(1));
    }

    @Test
    @DisplayName("큰 사람이 우승")
    public void testBigger() {
        Car car1 = new CarImpl("1");
        Car car2 = new CarImpl("2");

        car1.forward();
        List<String> winnersName = CarGame.getWinnersName(List.of(car1, car2));
        Assertions.assertEquals(1, winnersName.size());
        Assertions.assertEquals("1", winnersName.get(0));
    }
}
