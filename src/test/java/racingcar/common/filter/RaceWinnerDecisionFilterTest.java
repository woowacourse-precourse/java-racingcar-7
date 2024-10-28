package racingcar.common.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

class RaceWinnerDecisionFilterTest {
    private RaceWinnerDecisionFilter filter;

    @BeforeEach
    void setUp() {
        filter = new RaceWinnerDecisionFilter();
    }

    @Test
    @DisplayName("최대 거리를 이동한 자동차의 이름을 반환해야 한다")
    void testGetWinnersReturnsCorrectWinners() {
        RacingCar car1 = new RacingCar("Car1", 5);
        RacingCar car2 = new RacingCar("Car2", 10);
        RacingCar car3 = new RacingCar("Car3", 10);
        RacingCarList racingCarList = new RacingCarList(Arrays.asList(car1, car2, car3));
        RaceRequest request = new RaceRequest("Car1,Car2,Car3", 5, racingCarList);

        RaceResponse response = filter.doFilter(request, new RaceFilterChain(Collections.emptyList()));

        List<String> expectedWinners = Arrays.asList("Car2", "Car3");
        assertEquals(expectedWinners, response.winners(), "승자 목록이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("모든 자동차의 거리가 0일 때 전부를 반환한다.")
    void testGetWinnersReturnsEmptyListWhenNoWinners() {
        RacingCar car1 = new RacingCar("Car1", 0);
        RacingCar car2 = new RacingCar("Car2", 0);
        RacingCarList racingCarList = new RacingCarList(Arrays.asList(car1, car2));
        RaceRequest request = new RaceRequest("Car1,Car2", 5, racingCarList);
        RaceResponse response = filter.doFilter(request, new RaceFilterChain(Collections.emptyList()));

        List<String> expectedWinners = Arrays.asList("Car1", "Car2");
        assertEquals(expectedWinners, response.winners(), "빈 승자 목록이어야 합니다.");
    }
}
