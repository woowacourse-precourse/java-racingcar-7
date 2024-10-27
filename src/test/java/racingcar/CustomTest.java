package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.util.*;

public class CustomTest {

    @Test
    @DisplayName("자동차 이름 목록이 정상적으로 생성되는지 테스트")
    void testGetNames() {
        Map<String, Integer> race = new HashMap<>();
        String input = "pobi,woni,jun";
        Application.getNames(race, input);
        assertThat(race).containsKeys("pobi", "woni", "jun");
        assertThat(race.values()).allMatch(val -> val == 0);
    }

    @Test
    @DisplayName("자동차 이름 목록이 빈 문자열일 때 예외 발생")
    void testEmptyStringException() {
        Map<String, Integer> race = new HashMap<>();
        assertThatThrownBy(() -> Application.getNames(race, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 두 개 이상이 아닐 때 예외 발생")
    void testMinimumCarException() {
        Map<String, Integer> race = new HashMap<>();
        assertThatThrownBy(() -> Application.getNames(race, "pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2개 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 한 글자 이상이 아닐 때 예외 발생")
    void testMinimumCarNameException() {
        Map<String, Integer> race = new HashMap<>();
        assertThatThrownBy(() -> Application.getNames(race, "pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 한 글자 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 때 예외 발생")
    void testMaximumCarNameException() {
        Map<String, Integer> race = new HashMap<>();
        assertThatThrownBy(() -> Application.getNames(race, "pobi, javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("이동 횟수가 숫자가 아닐 때 예외 발생")
    void testParseNumberFormatException() {
        assertThatThrownBy(() -> Application.parseNumber("three"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형식이 아닙니다.");
    }

    @Test
    @DisplayName("음수 이동 횟수를 입력했을 때 예외 발생")
    void testParseNumberNegativeException() {
        assertThatThrownBy(() -> Application.parseNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

}
