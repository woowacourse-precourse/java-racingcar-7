package racingcar.Validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void 빈_입력값_검사() {
        assertThatThrownBy(() -> InputValidator.checkEmptyInput(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력하였습니다");

        assertThatThrownBy(() -> InputValidator.checkEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값을 입력하였습니다");
    }

    @Test
    void 입력_형식_확인_모두_알파벳_숫자_포함() {
        assertThat(InputValidator.checkInputFormat("car1,car2,car3")).isTrue();
        assertThat(InputValidator.checkInputFormat("car1,car2,")).isFalse(); // 빈 이름 포함
        assertThat(InputValidator.checkInputFormat("car1,car2,car@")).isFalse(); // 특수문자 포함
    }

    @Test
    void 입력_길이_제한_확인() {
        assertThat(InputValidator.checkInputRule("car1,car2")).isTrue();
        assertThat(InputValidator.checkInputRule("car1,toolongname")).isFalse(); // 5자 초과 이름 포함
    }

    @Test
    void 숫자_여부_확인() {
        assertThat(InputValidator.isNumber("12345")).isTrue();
        assertThat(InputValidator.isNumber("123a5")).isFalse(); // 숫자가 아닌 문자 포함
        assertThat(InputValidator.isNumber("")).isFalse(); // 빈 문자열
    }

    @Test
    void 시도_횟수_입력_유효성_검사() {
        // 숫자로만 구성된 시도 횟수
        assertThat(InputValidator.isNumber("5")).isTrue();

        // 숫자가 아닌 문자가 포함된 경우
        assertThat(InputValidator.isNumber("5a")).isFalse();

        // 빈 문자열로 시도 횟수를 입력한 경우
        assertThat(InputValidator.isNumber("")).isFalse();
    }

    @Test
    void 자동차_이름_유효성_검사() {
        assertThat(InputValidator.checkInputFormat("car1,car2")).isTrue(); // 유효한 이름들
        assertThat(InputValidator.checkInputFormat("car1,,car2")).isFalse(); // 유효하지 않은 이름
        assertThat(InputValidator.checkInputFormat("car1,car@")).isFalse(); // 유효하지 않은 이름
        assertThat(InputValidator.checkInputFormat("car1,")).isFalse(); // 빈 이름 포함
    }
}
