package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.global.Message;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameInputTest {

    private final InputView inputViewValidator = new InputView();

    @Test
    void 자동차_이름_정상_입력_테스트() {
        String inputCarName = "pobi, java";
        inputViewValidator.validateNameLength(inputCarName);
    }

    @Test
    void 자동차_이름_예외_입력_테스트() {
        String inputCarName = "pobi, javaji";
        assertThatThrownBy(() -> inputViewValidator.validateNameLength(inputCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ILLEGAL_NAME_LENGTH.getMessage());
    }

    @Test
    void 자동차_이름_정상_변환_테스트() {
        String inputCarName = "pobi, java";

        List<String> names = inputViewValidator.changeStringToList(inputCarName);

        assertThat(names).containsExactly("pobi", "java");
    }
}
