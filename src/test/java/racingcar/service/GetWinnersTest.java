package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetWinnersTest {
    private List<Car> cars;
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameService();
    }

    private void setUpCarsWithDifferentDistances() {
        Car car1 = new Car("Car1");
        car1.moveForward(); // Car1 거리: 1

        Car car2 = new Car("Car2");
        car2.moveForward(); // Car2 거리: 1

        Car car3 = new Car("Car3");
        car3.moveForward();
        car3.moveForward(); // Car3 거리: 2

        cars = Arrays.asList(car1, car2, car3);
    }

    private void setUpCarsWithEqualDistances() {
        Car car1 = new Car("Car1");
        car1.moveForward();
        car1.moveForward(); // Car1 거리: 2

        Car car2 = new Car("Car2");
        car2.moveForward();
        car2.moveForward(); // Car2 거리: 2

        Car car3 = new Car("Car3");
        car3.moveForward(); // Car3 거리: 1

        cars = Arrays.asList(car1, car2, car3);
    }

    @Test
    @DisplayName("1명의 우승자를 검증하는 메서드")
    void getWinner() {
        setUpCarsWithDifferentDistances();

        List<String> winners = gameService.getWinners(cars);

        assertEquals(1, winners.size(), "우승자의 수가 1이 아닙니다.");
        assertEquals("Car3", winners.get(0), "우승자의 이름이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("여러 명의 우승자 검증 테스트")
    void getWinners() {
        setUpCarsWithEqualDistances(); // 우승자 수가 2인 설정 호출

        List<String> winners = gameService.getWinners(cars);

        // 우승자의 수가 2여야 함
        assertEquals(2, winners.size(), "우승자의 수가 2가 아닙니다.");
        // 우승자가 Car1과 Car2여야 함
        assertTrue(winners.contains("Car1"), "우승자 목록에 Car1이 없습니다.");
        assertTrue(winners.contains("Car2"), "우승자 목록에 Car2가 없습니다.");
    }
}
