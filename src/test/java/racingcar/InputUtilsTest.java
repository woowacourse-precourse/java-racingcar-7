package racingcar;

import static racingcar.util.Constant.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.util.InputUtils;

class InputUtilsTest {
    @Test
    void 자동차_이름이_5자_초과() {
        System.setIn(new ByteArrayInputStream("pobi,woni,juniii".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_LENGTH_ERROR);
    }

    @Test
    void 자동차_빈칸_입력() {
        System.setIn(new ByteArrayInputStream(" ".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_NO_INPUT_ERROR);
    }

    @Test
    void 자동차_입력에_연속적_쉼표() {
        System.setIn(new ByteArrayInputStream("pobi,woni,,jun".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_INVALID_COMMA);
    }

    @Test
    void 자동차_입력_앞에_공백포함() {
        System.setIn(new ByteArrayInputStream(" pobi,woni,jun".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_BLANK_ERROR);
    }

    @Test
    void 자동차_입력_뒤에_공백포함() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun ".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_BLANK_ERROR);
    }

    @Test
    void 자동차_이름_앞_쉼표() {
        System.setIn(new ByteArrayInputStream(",pobi,woni,jun".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_INVALID_COMMA);
    }


    @Test
    void 자동차_이름_뒤_쉼표() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun,".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_INVALID_COMMA);
    }

    @Test
    void 자동차_이름_중복_체크() {
        System.setIn(new ByteArrayInputStream("pobi,woni,jun,pobi".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_DUPLICATE_ERROR);
    }

    @Test
    void 시도_횟수_입력이_정수가_아닐_때() {
        System.setIn(new ByteArrayInputStream("//1".getBytes()));

        assertThatThrownBy(InputUtils::inputAttempt)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPT_INPUT_ERROR_MESSAGE);
    }
}
