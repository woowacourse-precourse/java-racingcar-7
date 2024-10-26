package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {

    private void setConsoleInput(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    void 자동차목록을_입력받아_전달한다() {
        String input = "pobi,woni,jun";
        setConsoleInput(input);

        InputView inputView = new InputView();
        String carNames = inputView.requestCarNames();

        assertThat(carNames)
                .isEqualTo("pobi,woni,jun");
    }

    @Test
    void 빈_문자열을_입력받으면_예외발생() {
        Validator validator = new Validator();

        assertThatThrownBy(() -> validator.inputSting(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @Test
    void 자동차목록을_구분자로_나눈다() {
        InputParser inputParser = new InputParser();

        String carNames = "pobi,woni,jun";
        List<Car> carList = inputParser.stringToCarList(carNames);

        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

}