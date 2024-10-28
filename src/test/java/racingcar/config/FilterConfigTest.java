package racingcar.config;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.filter.FilterChain;

class FilterConfigTest {

    private final FilterConfig filterConfig = FilterConfig.getInstance();
    private final FilterChain carNameFilterChain = filterConfig.getCarNameFilterChain();
    private final FilterChain roundFilterChain = filterConfig.getRoundFilterChain();

    @Test
    @DisplayName("특수문자_포함_자동차이름_테스트")
    void testInvalidCarNameWithSpecialCharacters() {
        String input = "Test!";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->{
                    carNameFilterChain.doFilter(input);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복_이름_입력_테스트")
    void testDuplicateNameInput() {
        String input = "test,test";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->{
                    carNameFilterChain.doFilter(input);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름_5자_초과_테스트")
    void testCarNameTooLong() {
        String input = "Test12";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        carNameFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("경주_횟수_음수_입력_테스트")
    void testNegativeRaceCount() {
        String input = "-1";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("최대_경주_횟수_초과_테스트")
    void testExceedingMaxRaceCount() {
        String input = "2147483648";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("경주_횟수_실수_입력_테스트")
    void testRealNumberRaceCount() {
        String input = "1.01";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("경주_횟수_문자_입력_테스트")
    void testCharacterRaceCount() {
        String input = "test";
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        roundFilterChain.doFilter(input)
                ).isInstanceOf(IllegalArgumentException.class));
    }
}