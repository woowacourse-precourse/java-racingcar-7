package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 자동차_이름_검증_정상() {
        String input = "Swn,Bae";

        List<String> result = Validator.checkName(input);

        assertThat(result).containsExactly("Swn", "Bae");
    }

    @Test
    void 자동차_이름_검증_빈문자() {
        assertThatThrownBy(() -> Validator.checkName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자를 입력했습니다.");
    }

    @Test
    void 자동차_이름_검증_마지막_구분자() {
        assertThatThrownBy(() -> Validator.checkName("Swn,Bae,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("마지막 입력이 구분자입니다.");
    }

    @Test
    void 자동차_이름_검증_길이초과() {
        assertThatThrownBy(() -> Validator.checkName("Swn,Bae,TooLongName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 경기_횟수_검증_정상() {
        String input = "3";

        int result = Validator.checkCount(input);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 경기_횟수_검증_빈문자() {
        assertThatThrownBy(() -> Validator.checkCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자를 입력했습니다.");
    }

    @Test
    void 경기_횟수_검증_문자() {
        assertThatThrownBy(() -> Validator.checkCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경기 횟수는 양수로 입력되어야 합니다.");
    }

    @Test
    void 경기_횟수_검증_음수() {
        assertThatThrownBy(() -> Validator.checkCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경기 횟수는 양수로 입력되어야 합니다.");
    }

    @Test
    void 경기_횟수_검증_소수() {
        assertThatThrownBy(() -> Validator.checkCount("2.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경기 횟수는 양수로 입력되어야 합니다.");
    }

    @Test
    void 경기_횟수_검증_특문() {
        assertThatThrownBy(() -> Validator.checkCount(";"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경기 횟수는 양수로 입력되어야 합니다.");
    }
}
