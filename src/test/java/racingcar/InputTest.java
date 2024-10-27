package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    @DisplayName("긴 차 이름이 입력되는 경우 오류 테스트")
    void input_test_1() {
        Assertions.assertThatThrownBy(() -> Input.parseCarNames("pobi,abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름이 너무 깁니다.");
    }

    @Test
    @DisplayName("쉼표 뒤에 아무것도 오지 않는 경우 입력테스트")
    void input_test_2() {
        Assertions.assertThatThrownBy(() -> Input.parseCarNames("pobi,abcde,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표는 구분자로만 사용해야 합니다.");
    }

}
