package racingcar.filter;

import java.util.Iterator;
import java.util.List;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;

/**
 * 레이스 요청을 처리하기 위한 필터 체인입니다.
 */
public class RaceFilterChain implements FilterChain<RaceRequest, RaceResponse> {
    private final Iterator<Filter<RaceRequest, RaceResponse>> filterIterator;

    /**
     * 제공된 필터들로 RaceFilterChain을 생성합니다.
     *
     * @param filters 체인에서 적용될 필터들의 목록
     */
    public RaceFilterChain(List<Filter<RaceRequest, RaceResponse>> filters) {
        this.filterIterator = filters.iterator();
    }

    /**
     * RaceFilterChain을 생성하기 위한 새로운 빌더를 반환합니다.
     *
     * @return RaceFilterChainBuilder
     */
    public static RaceFilterChainBuilder builder() {
        return new RaceFilterChainBuilder();
    }

    @Override
    public RaceResponse doFilter(RaceRequest request) {
        if (hasMoreFilters()) {
            Filter<RaceRequest, RaceResponse> filter = filterIterator.next();
            return filter.doFilter(request, this);
        }
        return null;
    }

    /**
     * 체인에 더 많은 필터가 있는지 확인합니다.
     *
     * @return 더 많은 필터가 있으면 true, 그렇지 않으면 false
     */
    private boolean hasMoreFilters() {
        return filterIterator.hasNext();
    }
}
