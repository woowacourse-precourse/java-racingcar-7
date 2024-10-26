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
}
