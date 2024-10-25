package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    void 자동차_이름을_정상적으로_구분하는가() {
        List<String> names = InputView.splitNames("pobi,woni,jun");
        assertThat(names).isEqualTo(List.of("pobi", "woni", "jun"));
    }
}
