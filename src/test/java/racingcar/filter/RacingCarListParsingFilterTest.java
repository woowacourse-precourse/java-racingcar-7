package racingcar.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.InvalidCarNameException;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.filter.mock.MockRaceFilterChain;

class RacingCarListParsingFilterTest {
    private RacingCarListParsingFilter filter;
    private MockRaceFilterChain chain;

    @BeforeEach
    void setUp() {
        filter = new RacingCarListParsingFilter();
        chain = new MockRaceFilterChain(Collections.emptyList());
    }

    @Test
    @DisplayName("유효한 자동차 이름이 요청을 올바르게 업데이트해야 한다")
    void testValidCarNamesUpdateRequest() {
        RaceRequest request = new RaceRequest("Car1,Car2", 3);
        RaceResponse response = filter.doFilter(request, chain);

        assertNotNull(response, "응답은 null이 아니어야 한다");
        assertNotNull(chain.getUpdatedRequest(), "업데이트된 요청은 null이 아니어야 한다");
        assertEquals(2, chain.getUpdatedRequest().racingCarList().getCars().size(), "2대의 자동차가 있어야 한다");
    }

    @Test
    @DisplayName("유효하지 않은 자동차 이름은 예외를 발생시켜야 한다")
    void testInvalidCarNameThrowsException() {
        RaceRequest request = new RaceRequest("CarWithVeryLongName", 3);
        Exception exception = assertThrows(InvalidCarNameException.class, () -> {
            filter.doFilter(request, chain);
        });

        assertNotNull(exception);
    }
}
