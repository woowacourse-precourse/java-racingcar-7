package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankServiceTest {

    private RankService rankService;

    @BeforeEach
    void setUp() {
        rankService = new RankService();
    }

    @DisplayName("단독 우승인 경우, 매겨진 순위를 기반으로 한 명의 최종 우승자를 반환한다.")
    @Test
    void getWinnerByRanksWhenSingleWinner() {
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 2);

        List<String> winners = rankService.getWinnerByRanks(List.of(car1, car2, car3));

        assertEquals(1, winners.size());
        assertEquals("car1", winners.getFirst());
    }

    @DisplayName("공동 우승인 경우, 매겨진 순위를 기반으로 여러 명의 최종 우승자를 반환한다.")
    @Test
    void getWinnerByRanksWhenMultipleWinners() {
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 5);
        Car car3 = new Car("car3", 3);

        List<String> winners = rankService.getWinnerByRanks(List.of(car1, car2, car3));

        assertEquals(2, winners.size());
        assertEquals(List.of("car1", "car2"), winners);
    }
}
