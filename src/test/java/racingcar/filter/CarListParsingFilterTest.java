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

class CarListParsingFilterTest {
    private CarListParsingFilter filter;
    private TestRaceFilterChain chain;

    @BeforeEach
    void setUp() {
        filter = new CarListParsingFilter();
        chain = new TestRaceFilterChain(Collections.emptyList());
    }

    @Test
    @DisplayName("유효한 자동차 이름이 요청을 올바르게 업데이트해야 한다")
    void testValidCarNamesUpdateRequest() {
        // 주어진: 유효한 자동차 이름이 있는 요청
        RaceRequest request = new RaceRequest("Car1,Car2", 3);

        // 필터가 요청을 처리할 때
        RaceResponse response = filter.doFilter(request, chain);

        // 응답이 null이 아님을 확인
        assertNotNull(response, "응답은 null이 아니어야 한다");

        // 변환된 요청이 올바르게 업데이트되었는지 확인
        assertNotNull(chain.updatedRequest, "업데이트된 요청은 null이 아니어야 한다");
        assertEquals(2, chain.updatedRequest.carList().getCars().size(), "2대의 자동차가 있어야 한다");
    }

    @Test
    @DisplayName("유효하지 않은 자동차 이름은 예외를 발생시켜야 한다")
    void testInvalidCarNameThrowsException() {
        // 주어진: 유효하지 않은 자동차 이름이 있는 요청
        RaceRequest request = new RaceRequest("CarWithVeryLongName", 3);

        // 필터가 요청을 처리할 때 예외가 발생해야 함
        Exception exception = assertThrows(InvalidCarNameException.class, () -> {
            filter.doFilter(request, chain);
        });

        // 예외가 발생했는지 확인
        assertNotNull(exception);
    }

    // 테스트용 RaceFilterChain
    private static class TestRaceFilterChain extends RaceFilterChain {
        RaceRequest updatedRequest;

        /**
         * 제공된 필터들로 RaceFilterChain을 생성합니다.
         *
         * @param filters 체인에서 적용될 필터들의 목록
         */
        public TestRaceFilterChain(List<Filter<RaceRequest, RaceResponse>> filters) {
            super(filters);
        }

        @Override
        public RaceResponse doFilter(RaceRequest request) {
            // 변환된 요청을 저장
            this.updatedRequest = request;
            return new RaceResponse(Collections.singletonList("Car1")); // 간단한 테스트 응답
        }
    }
}
