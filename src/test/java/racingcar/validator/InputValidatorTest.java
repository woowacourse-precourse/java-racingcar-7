package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean hasNoInput = inputValidator.checkNameIsEmpty("");

        assertThat(hasNoInput).isTrue();
    }

    @Test
    public void 이름이_6자_이상인_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean length4 = inputValidator.checkNameIsLongerThanFive("pobi,woni,jun"); //4자인 경우
        boolean length5 = inputValidator.checkNameIsLongerThanFive("pobii,woni,jun");//5자인 경우
        boolean length6 = inputValidator.checkNameIsLongerThanFive("pobiii,wondi,jun");//6자인 경우

        assertThat(length4).isTrue();
        assertThat(length5).isTrue();
        assertThat(length6).isFalse();
    }

    @Test
    public void 이름에_숫자가_포함된_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean noNumber = inputValidator.checkNameIncludeNumber("pobi,woni,jun"); //정상적인 입력
        boolean hasNumber = inputValidator.checkNameIncludeNumber("pobi,woni,1");//이름이 숫자인 경우
        boolean includeNumber = inputValidator.checkNameIncludeNumber("pobi,wondi,jun1");//숫자가 포함된 경우

        assertThat(noNumber).isFalse();
        assertThat(hasNumber).isTrue();
        assertThat(includeNumber).isTrue();
    }

    @Test
    public void 쉼표뒤에_이름이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.checkNameHasNameBehindComma("pobi,woni,jun"); //정상적인 입력
        boolean NoNameBehindCommaInput = inputValidator.checkNameHasNameBehindComma("pobi,woni,");//쉼표 뒤 이름이 없는 경우
        boolean NoNameBetweenCommaInput = inputValidator.checkNameHasNameBehindComma("pobi,woni,,jun");//쉼표 사이 이름이 없는 경우
        boolean OnlyCommaInput = inputValidator.checkNameHasNameBehindComma(",,,");//쉼표 사이 이름이 없는 경우

        assertThat(normalInput).isFalse();
        assertThat(NoNameBehindCommaInput).isTrue();
        assertThat(NoNameBetweenCommaInput).isTrue();
        assertThat(OnlyCommaInput).isTrue();

    }

    @Test
    public void 시도횟수가_숫자가_아닌경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.checkTryNumberIsNotNumber("5"); //정상적인 입력
        boolean stringInput = inputValidator.checkTryNumberIsNotNumber("A");//숫자가 아닌 문자인 경우

        assertThat(normalInput).isFalse();
        assertThat(stringInput).isTrue();
    }

    @Test
    public void 시도횟수가_1이상의_정수가_아닌경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.checkTryNumberIsNotInteger("1"); //정상적인 입력
        boolean zeroInput = inputValidator.checkTryNumberIsNotInteger("0");
        boolean minusInput = inputValidator.checkTryNumberIsNotInteger("-1");

        assertThat(normalInput).isFalse();
        assertThat(zeroInput).isTrue();
        assertThat(minusInput).isTrue();
    }

    @Test
    public void 입력_통합_검증시_예외발생_테스트() {
        InputValidator inputValidator = new InputValidator();
        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validate("pobi,woni,jun", "5");
            inputValidator.validate("pobi,woni,123jun", "5");
            inputValidator.validate("pobi,woni,jun", "-1");
            inputValidator.validate("pobiiii,woni,jun", "5");
            inputValidator.validate("pobiiii,woni,jun", "ABC");
            inputValidator.validate("pobiiii,,jun", "5");
            inputValidator.validate("pobiiii,jun,", "5");
        });

    }
}