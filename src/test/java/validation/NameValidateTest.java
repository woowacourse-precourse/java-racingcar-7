package validation;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.service.GameService;


public class NameValidateTest {
    @Test
    void 이름_5글자_초과_예외_테스트() {
        validNameException("messi,ronaldo", "이름은 5글자를 넘기면 안됩니다.");
    }

    @Test
    void 쉼표중복_예외_테스트() {
        validNameException("messi,,silva", "이름이 제대로 입력되지 않았습니다.");
    }

    @Test
    void 쉼표앞뒤_예외_테스트() {
        validNameException(",messi,silva,", "이름이 제대로 입력되지 않았습니다.");
    }

    @Test
    void 빈값_예외_테스트() {
        validNameException("", "이름이 제대로 입력되지 않았습니다.");
    }

    @Test
    void 이름_띄어쓰기_예외_테스트() {
        validNameException("me ssi,sonny", "이름은 영문, 한글, 숫자로 띄어쓰기없이 입력하십시오.");
    }

    @Test
    void 이름_특수문자_예외_테스트() {
        validNameException("mess$,sonny", "이름은 영문, 한글, 숫자로 띄어쓰기없이 입력하십시오.");
    }

    @Test
    void 다른구분자_예외_테스트() {
        validNameException("messi%silva", "이름은 영문, 한글, 숫자로 띄어쓰기없이 입력하십시오.");
    }

    @Test
    void 공백_예외_테스트() {
        validNameException("  ", "이름은 영문, 한글, 숫자로 띄어쓰기없이 입력하십시오.");
    }

    @Test
    void 동일이름_예외_테스트() {
        validNameException("messi,messi", "동일한 이름은 작성할 수 없습니다.");
    }


    private void validNameException(String input, String message) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> GameService.splitCarName(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(message)
        );
    }
}
