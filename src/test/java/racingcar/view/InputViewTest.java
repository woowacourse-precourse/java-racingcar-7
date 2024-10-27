package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.UserDto;

import java.io.ByteArrayInputStream;

class InputViewTest extends NsTest {

    InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("유저에게 Input을 받으면 정확히 Dto로 변환되어야 한다.")
    void getInput() {
        String[] args = new String[]{"pobi, woni,jun", "5"};
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        UserDto.Input input = inputView.getInput();
        Assertions.assertThat(input.getCarName()).isEqualTo("pobi, woni,jun");
        Assertions.assertThat(input.getCount()).isEqualTo(5);
    }

    @Override
    public void runMain() {
        inputView.getInput();
    }
}