package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Constants.ErrorMessage;
import racingcar.Model.Car;
import racingcar.Model.InputParser;
import racingcar.Model.Validator;
import racingcar.View.InputView;

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
        assertThatThrownBy(() -> Validator.inputCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차목록을_구분자로_나눈다(String input) {
        List<Car> cars = InputParser.stringToCars(input);

        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"일이삼사오육", "일이삼 사오"})
    void 자동차이름_제한_초과하면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void 자동차이름_공백이면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백을 허용하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"po-bi", "wo/ni", "jun!!"})
    void 자동차이름_숫자문자이외_포함하면_예외발생(String input) {
        assertThatThrownBy(() -> InputParser.stringToCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 숫자와 문자만 가능해요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    void 자동차이름_중복되면_예외발생(String input) {
        assertThatThrownBy(() -> Validator.cars(InputParser.stringToCars(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_UNIQUE_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10"})
    void 정상적인_시도횟수를_입력받는다(String input) {
        setConsoleInput(input);
        InputView inputView = new InputView();

        String rounds = inputView.requestRound();

        assertThat(rounds)
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 시도횟수_빈문자열_입력시_예외발생(String input) {
        assertThatThrownBy(() -> Validator.inputRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_ROUND_FORMAT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a2", "!@#", " "})
    void 시도횟수_숫자가_아닌_입력시_예외발생(String input) {
        assertThatThrownBy(() -> Validator.inputRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_ROUND_FORMAT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "10001", "999999"})
    void 시도횟수_범위초과시_예외발생(String input) {
        assertThatThrownBy(() -> {
            Validator.inputRound(input);
            int round = InputParser.stringToRound(input);
            Validator.round(round);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_ROUND_RANGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.5", "0.0", "-3.14"})
    void 시도횟수_실수입력시_예외발생(String input) {
        assertThatThrownBy(() -> Validator.inputRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_ROUND_FORMAT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"9999999999999999999999999999"})
    void 시도횟수_정수범위초과시_예외발생(String input) {
        assertThatThrownBy(() -> Validator.inputRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_ROUND_RANGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"poby,woni,jun"})
    void 자동차목록에서_자동차리스트를_생성한다(String input) {
        List<Car> actual = InputParser.stringToCars(input);

        List<Car> expected = List.of(
                Car.from("poby"),
                Car.from("woni"),
                Car.from("jun")
        );

        assertThat(actual.stream()
                .map(Car::getName)
                .toList())
                .containsExactlyElementsOf(expected.stream()
                        .map(Car::getName)
                        .toList());
    }

}