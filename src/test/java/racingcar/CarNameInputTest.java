package racingcar;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CarNameInputTest {
    @Test
    void 자동차_이름_정상_저장_테스트() {
        setInput("pobi,woni"); // 정상 입력

        String[] expected = {"pobi", "woni"};
        String[] actual = CarNameInput.settingCarName();

        assertArrayEquals(expected, actual);
    }

    @Test
    void 자동차_이름_연속된_쉼표_입력_예외테스트() {
        setInput("pobi,,woni,,"); // 연속된 쉼표 입력

        assertThatThrownBy(() -> CarNameInput.settingCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("쉼표 사이에 빈 이름이 포함될 수 없습니다. 유효한 이름을 입력해주세요.");
    }

    @Test
    void 자동차_최소_개수_입력_예외테스트() {
        setInput("pobi"); // 자동차 이름 1개 입력

        assertThatThrownBy(() -> CarNameInput.settingCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 최소 두 개 이상 입력해야 합니다. 다시 시도해주세요.");
    }

    @Test
    void 자동차_이름_길이_5이하제한_예외테스트() {
        setInput("pobi,abcdefghi"); // 6글자 이름 입력

        assertThatThrownBy(() -> CarNameInput.settingCarName())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5글자 이하로 입력해야 합니다. 다시 시도해주세요.");
    }

    // 입력을 설정하는 메소드
    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
