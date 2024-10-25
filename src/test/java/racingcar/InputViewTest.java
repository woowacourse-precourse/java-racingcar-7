package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        this.inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   ", "     "})
    void 입력값이_공백일때(String userInput) {
        boolean isBlankCarName = inputView.isBlank(userInput);
        assertThat(isBlankCarName).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요힛", "안녕하세요요요", "내이름은안녕하세요", "이름이특이하네요"})
    void 차이름_길이가_5자_이상일때(String userInput) {
        boolean isNameMoreThanFive = inputView.isMoreThanFive(userInput);
        assertThat(isNameMoreThanFive).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"반가워요", "세글자", "이름", "이", "안녕하세요"})
    void 차이름_길이가_5자_이하일때(String userInput) {
        boolean isNameLessThanFive = inputView.isMoreThanFive(userInput);
        assertThat(isNameLessThanFive).isFalse();
    }

    @Test
    void 차이름이_중복일때() {
        InputView.userNames.add("중복이");
        boolean isDuplicate = inputView.isDuplicate("중복이");
        assertThat(isDuplicate).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요!구분자가없으면어떻게되나요!느낌표가구분자입니다.", "안녕하세요?구분자가없으면어떻게되죠?"})
    void 차이름에_쉼표가_없을때(String userInput) {
        boolean isContainComma = inputView.isContainComma(userInput);
        assertThat(isContainComma).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "2나", "$3"})
    void 시도횟수가_정수가_아닐때(String userInput) {
        boolean isNumeric = inputView.isNumeric(userInput);
        assertThat(isNumeric).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "12", "23", "12321312"})
    void 시도횟수가_정수_일때(String userInput) {
        boolean isNumeric = inputView.isNumeric(userInput);
        assertThat(isNumeric).isTrue();
    }


}

