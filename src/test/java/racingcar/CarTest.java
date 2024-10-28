package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("이름이_5글자를_넘기면_예외를_발생한다")
    public void should_ThrowException_When_NameLengthMoreThan5() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Car("testcar"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에_영문자와_숫자_이외의_문자를_입력하면_예외를_발생한다")
    public void should_ThrowException_When_NameNotOnlyEnglishAndNumber() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Car("ab-c"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}