package racingcar;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    private Validator validator;

    @Test
    void 이름입력_유효성_테스트() {
        validator = new Validator();
        HashSet<String> carNames = new HashSet<>();
        carNames.add("pobi");
        carNames.add("woni");
        carNames.add("jun");

        // 길이 초과
        assertThatThrownBy(() -> validator.nameValidation("popobi", carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5글자를 초과했습니다.");

        // 이름 중복
        assertThatThrownBy(() -> validator.nameValidation("pobi", carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 이름입니다.");

        // 공백
        assertThatThrownBy(() -> validator.nameValidation(" ", carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백만 입력할 수 없습니다.");
    }

    @Test
    public void 숫자입력_유효성_테스트() {
        validator = new Validator();

        // 문자 입력
        assertThatThrownBy(() -> validator.countValidation("abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력할 수 있습니다.");

        // 음수 입력
        assertThatThrownBy(() -> validator.countValidation("-14"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");

        // 소수 입력
        assertThatThrownBy(() -> validator.countValidation("4.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("소수는 입력할 수 없습니다.");
    }
}
