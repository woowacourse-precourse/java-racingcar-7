package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("입력한 자동차 이름만큼의 자동차 이름을 지닌 문자열 리스트를 반환한다.")
    void getCarNames() {
        //given
        String input = "박재연, 우테코";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView();

        //when
        List<String> carNames = inputView.getCarNames();
        Console.close();

        //then
        Assertions.assertThat(carNames.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("공백을 입력하면 예외를 발생한다.")
    void validateBlank() {
        //given
        String input = " ";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView();

        //when, then
        Assertions.assertThatThrownBy(inputView::getCarNames).isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("입력한 시도 횟수를 반환한다.")
    void getRoundCount() {
        //given
        String input = "5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView();

        //when
        String tryCount = inputView.getRoundCount();
        Console.close();

        //then
        Assertions.assertThat(tryCount).isEqualTo("5");
    }
}