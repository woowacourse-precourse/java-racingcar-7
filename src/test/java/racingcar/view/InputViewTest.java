package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class InputViewTest {

    private InputView inputView = new InputView();

    @Test
    @DisplayName("inputCarNames 테스트")
    void inputCarNames() {
        //given
        String readLine = "Car1,Car2,Car3";
        System.setIn(new ByteArrayInputStream(readLine.getBytes()));

        //when
        List<String> carNames = inputView.inputCarnames();

        //then
        assertThat(carNames)
                .isEqualTo(List.of("Car1", "Car2", "Car3"));
    }

    @Test
    @DisplayName("inputGameTokens 테스트")
    void inputGameTokens() {
        //given
        String readLine = "5";
        System.setIn(new ByteArrayInputStream(readLine.getBytes()));

        //when
        int gameTokens = inputView.inputGameTokens();

        //then
        assertThat(gameTokens)
                .isEqualTo(5);
    }

}
