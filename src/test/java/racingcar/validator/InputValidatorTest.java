package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    public void 입력이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean hasNoInput = inputValidator.hasNoInput("");

        Assertions.assertThat(hasNoInput).isTrue();
    }

    @Test
    public void 이름이_6자_이상인_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean length4 = inputValidator.checkInputLength("pobi,woni,jun"); //4자인 경우
        boolean length5 = inputValidator.checkInputLength("pobii,woni,jun");//5자인 경우
        boolean length6 = inputValidator.checkInputLength("pobiii,wondi,jun");//6자인 경우

        Assertions.assertThat(length4).isTrue();
        Assertions.assertThat(length5).isTrue();
        Assertions.assertThat(length6).isFalse();
    }

    @Test
    public void 이름에_숫자가_포함된_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean noNumber = inputValidator.includeNumber("pobi,woni,jun"); //정상적인 입력
        boolean hasNumber = inputValidator.includeNumber("pobi,woni,1");//이름이 숫자인 경우
        boolean includeNumber = inputValidator.includeNumber("pobi,wondi,jun1");//숫자가 포함된 경우

        Assertions.assertThat(noNumber).isFalse();
        Assertions.assertThat(hasNumber).isTrue();
        Assertions.assertThat(includeNumber).isTrue();
    }

    @Test
    public void 쉼표뒤에_이름이_없는_경우() {
        InputValidator inputValidator = new InputValidator();

        boolean normalInput = inputValidator.NoNameBehindComma("pobi,woni,jun"); //정상적인 입력
        boolean NoNameBehindCommaInput = inputValidator.NoNameBehindComma("pobi,woni,");//쉼표 뒤 이름이 없는 경우
        boolean NoNameBetweenCommaInput = inputValidator.NoNameBehindComma("pobi,woni,,jun");//쉼표 사이 이름이 없는 경우
        boolean OnlyCommaInput = inputValidator.NoNameBehindComma(",,,");//쉼표 사이 이름이 없는 경우

        Assertions.assertThat(normalInput).isFalse();
        Assertions.assertThat(NoNameBehindCommaInput).isTrue();
        Assertions.assertThat(NoNameBetweenCommaInput).isTrue();
        Assertions.assertThat(OnlyCommaInput).isTrue();

    }

}