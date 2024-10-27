package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringValidatorTest{

    @Test
    void 입력된_자동차가_2개_이하() {
        // given
        String[] input = {"pobi"};
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.isSeveralValue(input));
        // then
        assertThat(e.getMessage()).isEqualTo("2개 이상의 자동차를 입력해주세요.");
    }

    @Test
    void 입력값에_공백_문자열을_포함() {
        // given
        String[] input = {"pobi", "tom", ""};
        String emptyValue = "";
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.isEmptyValue(input));
        // then
        assertThat(e.getMessage()).isEqualTo("공백 문자열이 포함되어 있습니다. : " + emptyValue);
    }

    @Test
    void 입력값에_null값을_포함() {
        // given
        String[] input = {"pobi", "tom", null};
        String emptyValue = null;
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.isEmptyValue(input));
        // then
        assertThat(e.getMessage()).isEqualTo("공백 문자열이 포함되어 있습니다. : " + emptyValue);
    }

    @Test
    void 숫자가_포함된_자동차명_입력() {
        // given
        String[] input = {"pobi", "123", "tom"};
        String wrongValue = "123";
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.areAllLetter(input));
        // then
        assertThat(e.getMessage()).isEqualTo("한글과 염문으로 구성된 이름을 입력해주세요. : " + wrongValue);
    }

    @Test
    void 기호가_포함된_자동차명_입력() {
        // given
        String[] input = {"pobi", "Kim;", "tom"};
        String wrongValue = "Kim;";
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.areAllLetter(input));
        // then
        assertThat(e.getMessage()).isEqualTo("한글과 염문으로 구성된 이름을 입력해주세요. : " + wrongValue);
    }

    @Test
    void 공백이_포함된_자동차명_입력() {
        // given
        String[] input = {"pobi", "인 수", "tom"};
        String wrongValue = "인 수";
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.areAllLetter(input));
        // then
        assertThat(e.getMessage()).isEqualTo("한글과 염문으로 구성된 이름을 입력해주세요. : " + wrongValue);
    }

    @Test
    void 문자열의_길이가_5를_넘는_경우() {
        //given
        String[] input = {"pobi", "김수한무거북이", "tom"};
        String wrongValue = "김수한무거북이";
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> StringValidator.areAllLengthUnderFive(input));
        //then

        assertThat(e.getMessage()).isEqualTo("이름의 길이가 5자를 넘습니다. : " + wrongValue);
    }
}