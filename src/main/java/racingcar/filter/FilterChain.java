package racingcar.filter;

/**
 * 필터 체인 인터페이스입니다.
 * <p>
 * 이 인터페이스는 요청을 필터링하기 위한 메서드를 정의합니다. 구현체는 필터 체인을 통해 요청을 처리할 수 있습니다.
 * </p>
 *
 * @param <R> 요청 객체의 타입
 * @param <T> 응답 객체의 타입
 */
public interface FilterChain<R, T> {
    /**
     * 주어진 요청을 처리하고 응답을 반환합니다.
     *
     * @param request 처리할 요청 객체
     * @return 처리된 응답 객체
     */
    T doFilter(R request);
}
