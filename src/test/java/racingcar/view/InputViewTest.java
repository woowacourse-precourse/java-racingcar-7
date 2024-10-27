package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {
    private final InputView inputView = new InputView();
    @Test
    void 자동차_이름_분리() {
        String input = "pobi,woni,jun";
        List<String> names = inputView.parseCarNames(input);

        assertThat(names)
                .hasSize(3)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 빈_자동차_이름_입력() {
        String input = "pobi,,jun";

        assertThatThrownBy(() -> inputView.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[빈 값]");
    }

    @Test
    void 길이_제한_초과_자동차_이름_입력() {
        String input = "pobi,ckdhkdwns,jun";

        assertThatThrownBy(() -> inputView.parseCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[길이 제한]");
    }

    @Test
    void 시도할_횟수에_문자_입력() {
        String input = "i";

        assertThatThrownBy(() -> inputView.parseMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[타입 변환]");
    }

    @Test
    void 시도할_횟수에_양이아닌_정수_입력() {
        String input = "0";

        assertThatThrownBy(() -> inputView.parseMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[부호]");
    }
}
