package racingcar.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.CarList;
import racingcar.model.RacingCar;

class RaceWinnerDecisionFilterTest {
    private RaceWinnerDecisionFilter filter;

    @BeforeEach
    void setUp() {
        filter = new RaceWinnerDecisionFilter(); // RaceWinnerDecisionFilter 인스턴스 생성
    }

    @Test
    @DisplayName("최대 거리를 이동한 자동차의 이름을 반환해야 한다")
    void testGetWinnersReturnsCorrectWinners() {
        // Given: 자동차 목록과 승자를 설정
        RacingCar car1 = new RacingCar("Car1", 5);
        RacingCar car2 = new RacingCar("Car2", 10);
        RacingCar car3 = new RacingCar("Car3", 10);
        CarList carList = new CarList(Arrays.asList(car1, car2, car3));
        RaceRequest request = new RaceRequest("Car1,Car2,Car3", 5, carList);

        // When: 필터를 통해 승자 결정
        RaceResponse response = filter.doFilter(request, new RaceFilterChain(Collections.emptyList()));

        // Then: 응답에 올바른 승자 목록이 포함되어야 함
        List<String> expectedWinners = Arrays.asList("Car2", "Car3");
        assertEquals(expectedWinners, response.winners(), "승자 목록이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("모든 자동차의 거리가 0일 때 전부를 반환한다.")
    void testGetWinnersReturnsEmptyListWhenNoWinners() {
        // Given: 모든 자동차의 거리 설정
        RacingCar car1 = new RacingCar("Car1", 0);
        RacingCar car2 = new RacingCar("Car2", 0);
        CarList carList = new CarList(Arrays.asList(car1, car2));
        RaceRequest request = new RaceRequest("Car1,Car2", 5, carList);

        // When: 필터를 통해 승자 결정
        RaceResponse response = filter.doFilter(request, new RaceFilterChain(Collections.emptyList()));

        // Then: 응답에 모든 사람이 포함되어야 함.
        List<String> expectedWinners = Arrays.asList("Car1", "Car2");
        assertEquals(expectedWinners, response.winners(), "빈 승자 목록이어야 합니다.");
    }
}
