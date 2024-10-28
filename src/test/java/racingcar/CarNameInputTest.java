package racingcar;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CarNameInputTest {

    @Test
    void 자동차_이름_연속된_쉼표_입력_예외테스트() {
        setInput("pobi,,woni,,"); // 연속된 쉼표 입력

        assertThatThrownBy(() -> CarNameInput.settingCarName())
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 입력을 설정하는 메소드
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
