package racingcar.filter;

public interface Filter {
    void doFilter(String input, FilterChain filterChain);
}
