package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

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
        assertThatThrownBy(() -> Validator.inputSting(""))
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

    @Test
    void 자동차이름_제한_초과하면_예외발생() {
        InputParser inputParser = new InputParser();

        assertThatThrownBy(() -> inputParser.stringToCarList("일이삼사오육"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void 자동차이름_공백이면_예외발생(String input) {
        InputParser inputParser = new InputParser();

        assertThatThrownBy(() -> inputParser.stringToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백을 허용하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"po-bi", "wo/ni", "jun!!"})
    void 자동차이름_숫자문자이외_포함하면_예외발생(String input) {
        InputParser inputParser = new InputParser();

        assertThatThrownBy(() -> inputParser.stringToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 숫자와 문자만 가능해요.");
    }

    @Test
    void 자동차이름_중복되면_예외발생() {
        InputParser inputParser = new InputParser();

        assertThatThrownBy(() -> inputParser.stringToCarList("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("dd");
    }


}