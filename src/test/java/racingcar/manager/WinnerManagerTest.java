package racingcar.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import racingcar.car.Car;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WinnerManagerTest {

    @DisplayName("우승자가 한 명일 경우 리스트에 한명의 이름만 담긴다.")
    @Test
    public void testSingleWinner() {
        // given
        WinnerManager winnerManager = new WinnerManager();
        Set<Car> cars = new LinkedHashSet<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        // when
        car1.move(5);

        car2.move(5);
        car2.move(5);

        car3.move(5);

        List<String> winners = winnerManager.whoWin(cars);

        // then
        assertEquals(1, winners.size());
        assertTrue(winners.contains("car1"));
    }

    @DisplayName("우승자가 두 명 이상일 경우 리스트에 여러 이름이 담긴다.")
    @Test
    public void testMultipleWinnersWithSamePosition() {
        // given
        WinnerManager winnerManager = new WinnerManager();
        Set<Car> cars = new LinkedHashSet<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        // when
        car1.move(5);
        car1.move(5);

        car2.move(5);
        car2.move(5);

        car3.move(5);

        List<String> winners = winnerManager.whoWin(cars);

        // then
        assertEquals(2, winners.size());
        assertTrue(winners.containsAll(List.of("car1", "car2")));
    }
}
