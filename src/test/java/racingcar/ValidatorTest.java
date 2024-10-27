package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    @DisplayName("정상적인 자동차 이름 입력시 배열로 반환")
    void 기능_테스트() {
        String input = "pobi,woni,jun";
        String[] result = Validator.checkInput(input);
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("빈 문자열 입력시 예외 발생")
    void 예외_테스트1() {
        assertThatThrownBy(() -> Validator.checkInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주에 참여할 자동차를 입력해주세요. 예) pobi,woni,jun");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 발생")
    void 예외_테스트2() {
        assertThatThrownBy(() -> Validator.checkInput("pobi,superman,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 입력해주세요. 예) pobi,woni,jun");
    }

    @Test
    @DisplayName("시도 횟수가 0 이하일 경우 예외 발생")
    void 예외_테스트3() {
        assertThatThrownBy(() -> Validator.checkNum(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상 시도할 횟수를 입력해주세요.");
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 예외 발생")
    void 예외_테스트4() {
        assertThatThrownBy(() -> Validator.checkNum(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상 시도할 횟수를 입력해주세요.");
    }

    @Test
    @DisplayName("쉼표만 있는 입력의 경우 예외 발생")
    void 예외_테스트5() {
        assertThatThrownBy(() -> Validator.checkInput(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주에 참여할 자동차를 입력해주세요. 예) pobi,woni,jun");
    }
}