package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_이름_문자인지_확인(){
        assertThatThrownBy(() -> Car.isCarNameString("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_5자_이하로_제한(){
        assertThatThrownBy(() -> Car.isCarNameLengthFive("haeseon"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_구분자인지_확인(){
        assertThatThrownBy(() -> User.isCorrectSeparator("pobi.woni.jun"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_마지막에_구분자_입력_제한(){
        assertThatThrownBy(() -> User.isLastStringComma("pobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_사이_공백_확인(){
        String[] cars = {"pobi", "", "jun"};
        assertThatThrownBy(() -> User.isEmpty(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_숫자인지_확인(){
        assertThatThrownBy(() -> User.isDigit("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
