package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean hasNoInput = inputValidator.checkNameIsEmpty("");

        Assertions.assertThat(hasNoInput).isTrue();
    }

    @Test
    public void 이름이_6자_이상인_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean length4 = inputValidator.checkNameIsLongerThanFive("pobi,woni,jun"); //4자인 경우
        boolean length5 = inputValidator.checkNameIsLongerThanFive("pobii,woni,jun");//5자인 경우
        boolean length6 = inputValidator.checkNameIsLongerThanFive("pobiii,wondi,jun");//6자인 경우

        Assertions.assertThat(length4).isTrue();
        Assertions.assertThat(length5).isTrue();
        Assertions.assertThat(length6).isFalse();
    }

    @Test
    public void 이름에_숫자가_포함된_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean noNumber = inputValidator.checkNameIncludeNumber("pobi,woni,jun"); //정상적인 입력
        boolean hasNumber = inputValidator.checkNameIncludeNumber("pobi,woni,1");//이름이 숫자인 경우
        boolean includeNumber = inputValidator.checkNameIncludeNumber("pobi,wondi,jun1");//숫자가 포함된 경우

        Assertions.assertThat(noNumber).isFalse();
        Assertions.assertThat(hasNumber).isTrue();
        Assertions.assertThat(includeNumber).isTrue();
    }

    @Test
    public void 쉼표뒤에_이름이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.checkNameHasNameBehindComma("pobi,woni,jun"); //정상적인 입력
        boolean NoNameBehindCommaInput = inputValidator.checkNameHasNameBehindComma("pobi,woni,");//쉼표 뒤 이름이 없는 경우
        boolean NoNameBetweenCommaInput = inputValidator.checkNameHasNameBehindComma(
                "pobi,woni,,jun");//쉼표 사이 이름이 없는 경우
        boolean OnlyCommaInput = inputValidator.checkNameHasNameBehindComma(",,,");//쉼표 사이 이름이 없는 경우

        Assertions.assertThat(normalInput).isFalse();
        Assertions.assertThat(NoNameBehindCommaInput).isTrue();
        Assertions.assertThat(NoNameBetweenCommaInput).isTrue();
        Assertions.assertThat(OnlyCommaInput).isTrue();

    }

    @Test
    public void 시도횟수가_숫자가_아닌경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.checkTryNumberIsNotNumber("5"); //정상적인 입력
        boolean stringInput = inputValidator.checkTryNumberIsNotNumber("A");//숫자가 아닌 문자인 경우

        Assertions.assertThat(normalInput).isFalse();
        Assertions.assertThat(stringInput).isTrue();
    }

    @Test
    public void 시도횟수가_1이상의_정수가_아닌경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.checkTryNumberIsNotInteger("1"); //정상적인 입력
        boolean zeroInput = inputValidator.checkTryNumberIsNotInteger("0");
        boolean minusInput = inputValidator.checkTryNumberIsNotInteger("-1");

        Assertions.assertThat(normalInput).isFalse();
        Assertions.assertThat(zeroInput).isTrue();
        Assertions.assertThat(minusInput).isTrue();
    }


}