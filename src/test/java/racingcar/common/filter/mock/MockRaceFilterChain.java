package racingcar.common.filter.mock;

import java.util.Collections;
import java.util.List;
import racingcar.common.filter.Filter;
import racingcar.common.filter.RaceFilterChain;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;

public class MockRaceFilterChain extends RaceFilterChain {
    RaceRequest updatedRequest;

    /**
     * 제공된 필터들로 RaceFilterChain을 생성합니다.
     *
     * @param filters 체인에서 적용될 필터들의 목록
     */
    public MockRaceFilterChain(List<Filter<RaceRequest, RaceResponse>> filters) {
        super(filters);
    }

    @Override
    public RaceResponse doFilter(RaceRequest request) {
        // 변환된 요청을 저장
        this.updatedRequest = request;
        return new RaceResponse(Collections.emptyList());
    }

    public RaceRequest getUpdatedRequest() {
        return updatedRequest;
    }
}
