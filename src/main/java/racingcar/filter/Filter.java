package racingcar.filter;

/**
 * 필터 인터페이스입니다.
 * <p>
 * 이 인터페이스는 요청을 처리하는 필터의 기본 구조를 정의합니다. 각 필터는 요청을 받아들이고, 다음 필터 체인으로 전달할 수 있습니다.
 * </p>
 *
 * @param <R> 요청 객체의 타입
 * @param <T> 응답 객체의 타입
 */
public interface Filter<R, T> {
    /**
     * 주어진 요청을 처리하고, 다음 필터 체인을 통해 응답을 반환합니다.
     *
     * @param request     처리할 요청 객체
     * @param filterChain 다음 필터 체인
     * @return 처리된 응답 객체
     */
    T doFilter(R request, RaceFilterChain filterChain);
}
