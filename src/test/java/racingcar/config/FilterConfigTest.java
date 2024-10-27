package racingcar.config;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.filter.FilterChain;

class FilterConfigTest {

    private final FilterConfig filterConfig = FilterConfig.getInstance();
    private final FilterChain carNameFilterChain = filterConfig.getCarNameFilterChain();
    private final FilterChain roundFilterChain = filterConfig.getRoundFilterChain();

    @Test
    void testInvalidCarNameWithSpecialCharacters() {
        String input = "Test!";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->{
                    carNameFilterChain.doFilter(input);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void testCarNameTooLong() {
        String input = "Test12";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        carNameFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void testNegativeRaceCount() {
        String input = "-1";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void testExceedingMaxRaceCount() {
        String input = "2147483648";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void testRealNumberRaceCount() {
        String input = "1.01";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void testCharacterRaceCount() {
        String input = "test";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }
}