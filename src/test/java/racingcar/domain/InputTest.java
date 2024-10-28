package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.vo.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.io.Input;
import racingcar.vo.ExceptionMessage;

public class InputTest {


    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Nested
    class 횟수_입력_테스트 {
        @Test
        void 성공() {
            String input = "11";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Input inputView = new Input();
            int playCount = inputView.readPlayCount();
            assertThat(playCount).isEqualTo(Integer.parseInt(input));
        }

        @Test
        void 입력된_값이_알파벳일_때_IllegalArgumentException_발생() {
            String input = "abc";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Input inputView = new Input();
            assertThatThrownBy(() -> inputView.readPlayCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_NOT_NUMBER.getMessage());
        }

        @Test
        void 입력된_값이_특수문자일_때_IllegalArgumentException_발생() {
            String input = "!@#$%%";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Input inputView = new Input();
            assertThatThrownBy(() -> inputView.readPlayCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_NOT_NUMBER.getMessage());
        }

        @Test
        void 입력된_값이_마이너스_기호_하나일_때_IllegalArgumentException_발생() {
            String input = "-";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Input inputView = new Input();
            assertThatThrownBy(() -> inputView.readPlayCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_NOT_NUMBER.getMessage());
        }

        @Test
        void 입력된_값이_음수일_때_IllegalArgumentException_발생() {
            String input = "-1";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            Input inputView = new Input();
            assertThatThrownBy(
                    () -> inputView.readPlayCount()
            ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    @Nested
    class 자동차_이름_입력_테스트 {

        @Test
        void 입력_성공() {
            String inputCarNames = "poly,woni,jun";
            System.setIn(new ByteArrayInputStream(inputCarNames.getBytes()));

            Input input = new Input();
            List<String> carNames = input.readCarNames();

            assertThat(carNames).isNotEmpty();
            assertThat(carNames.size()).isEqualTo(inputCarNames.split(",").length);
        }

        @Test
        void 입력된_값에_특수문자가_있을_때_IllegalArgumentException_발생()    {
            String inputCarNames = "poly,woni,j#n";
            System.setIn(new ByteArrayInputStream(inputCarNames.getBytes()));

            Input input = new Input();
            assertThatThrownBy(() -> input.readCarNames()).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                    INVALID_NOT_ALLOWED_NAME.getMessage());
        }

        @Test
        void 입력값_앞_뒤에_컴마가_있으면_IllegalArgumentException_발생()    {
            String inputCarNames = ",poly,woni,jin,";
            System.setIn(new ByteArrayInputStream(inputCarNames.getBytes()));

            Input input = new Input();
            assertThatThrownBy(() -> input.readCarNames()).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                    INVALID_NOT_ALLOWED_NAME.getMessage());
        }
    }

}
