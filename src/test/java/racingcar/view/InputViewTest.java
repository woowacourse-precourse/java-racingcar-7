package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.exception.ErrorMessage;

public class InputViewTest {
    @AfterEach
    void consoleClear() {
        Console.close();
    }

    @Test
    @DisplayName("유저로부터_정상적인_자동차_이름_문자열을_입력받는다.")
    void 유저로부터_정상적인_자동차_이름_문자열을_입력받는다() {
        //given
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream("pobi,woni\n".getBytes());
        System.setIn(in);

        // when & then
        assertThatCode(inputView::requestCarsName)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("유저로부터_자동차_이름_문자열에_빈_문자열을_입력받아_에러를_반환한다.")
    void 유저로부터_자동차_이름_문자열에_빈_문자열을_입력받아_에러를_반환한다() {
        //given
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::requestCarsName)
                .withMessage(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
    }

    @Test
    @DisplayName("유저로부터_정상적인_횟수를_입력받는다.")
    void 유저로부터_정상적인_횟수를_입력받는다() {
        //given
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(in);

        // when & then
        assertThatCode(inputView::requestRoundCount)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("유저로부터_시도할_횟수에_알파벳을_입력받아서_에러를_반환한다.")
    void 유저로부터_시도할_횟수에_알파벳을_입력받아서_에러를_반환한다() {
        //given
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream("a\n".getBytes());
        System.setIn(in);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::requestRoundCount)
                .withMessage(ErrorMessage.INVALID_ROUND_COUNT_ERROR.getMessage());
    }

    @Test
    @DisplayName("유저로부터_시도할_횟수에_음수를_입력받아_에러를_반환한다.")
    void 유저로부터_시도할_횟수에_음수를_입력받아_에러를_반환한다() {
        //given
        InputView inputView = new InputView();

        InputStream in = new ByteArrayInputStream("-1\n".getBytes());
        System.setIn(in);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::requestRoundCount)
                .withMessage(ErrorMessage.INVALID_ROUND_COUNT_ERROR.getMessage());
    }
}
