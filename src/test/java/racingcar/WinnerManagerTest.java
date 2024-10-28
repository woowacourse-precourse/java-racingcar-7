package racingcar;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class WinnerManagerTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;
    private List<Car> cars;
    private WinnerManager winnerManager;

    @BeforeEach
    void setup() {
        car1 = new Car("pobi");
        car2 = new Car("woni");
        car3 = new Car("jun");
        car4 = new Car("jason");
        cars = Arrays.asList(car1, car2, car3, car4);

        car1.setDistance(10);
        car2.setDistance(4);
        car3.setDistance(7);
        car4.setDistance(10);

        winnerManager = new WinnerManager();
    }

    @Test
    @DisplayName("자동차 List에서 최대 거리를 반환한다")
    void getMaxDistanceTest() {
        assertEquals(10, winnerManager.getMaxDistance(cars));
    }

    @Test
    @DisplayName("자동차 List에서 최대 거리를 반환한다")
    void determineWinnersTest() {
        List<Car> winners = winnerManager.determineWinners(cars);
        assertEquals(2, winners.size());
        assertEquals("pobi", winners.getFirst().getCarName());
        assertEquals("jason", winners.get(1).getCarName());
    }

    @Test
    @DisplayName("공동 우승자의 이름을 출력한다.")
    void getWinnerNamesTest() {
        List<Car> winners = winnerManager.determineWinners(cars);
        String winnerNames = winnerManager.getWinnerNames(winners);
        assertEquals("pobi, jason", winnerNames);
    }

    @Test
    @DisplayName("단독 우승자의 이름을 출력한다.")
    void getWinnerNamesTest2() {
        car4.setDistance(12);
        List<Car> winners = winnerManager.determineWinners(cars);
        String winnerNames = winnerManager.getWinnerNames(winners);
        assertEquals("jason", winnerNames);
    }
}
