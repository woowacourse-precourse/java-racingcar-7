package racingcar.filter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceRequest;
import racingcar.filter.mock.MockRaceExecutor;
import racingcar.model.RacingCarList;

class RaceExecutionFilterTest {
    private RaceExecutionFilter filter;
    private MockRaceExecutor executor;

    @BeforeEach
    void setUp() {
        executor = new MockRaceExecutor();
        filter = new RaceExecutionFilter(executor);
    }

    @Test
    @DisplayName("doFilter가 executeRace 메서드를 호출해야 한다")
    void testDoFilterCallsExecuteRace() {
        RacingCarList racingCarList = new RacingCarList(Collections.emptyList());
        RaceRequest request = new RaceRequest("Car1,Car2", 3);
        request = request.withCarList(racingCarList);

        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        filter.doFilter(request, chain);

        assertTrue(executor.isExecuted(), "executeRace가 호출되어야 한다");
    }
}
