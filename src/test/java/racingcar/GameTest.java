package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
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

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차목록을_입력받아_전달한다(String input) {
        InputView inputView = new InputView();
        setConsoleInput(input);

        String carNames = inputView.requestCarNames();

        assertThat(carNames)
                .isEqualTo("pobi,woni,jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 빈_문자열을_입력받으면_예외발생(String input) {
        assertThatThrownBy(() -> Validator.inputSting(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차목록을_구분자로_나눈다(String input) {
        List<Car> carList = InputParser.stringToCarList(input);

        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"일이삼사오육", "일이삼 사오"})
    void 자동차이름_제한_초과하면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void 자동차이름_공백이면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백을 허용하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"po-bi", "wo/ni", "jun!!"})
    void 자동차이름_숫자문자이외_포함하면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 숫자와 문자만 가능해요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    void 자동차이름_중복되면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("dd");
    }



}