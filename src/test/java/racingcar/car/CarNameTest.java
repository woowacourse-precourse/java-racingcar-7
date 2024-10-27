package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"t", "te", "tes", "test", "testo"})
    void 자동차_이름은_5자_이하로_생성할_수_있다(String content) {
        //when & then
        Assertions.assertThatCode(() -> {
            CarName carName = new CarName(content);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "     "})
    void 자동차_이름이_공백이면_예외가_발생한다(String content) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(content);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", " 12", "23 ", "2 3", " 1 2 3 "})
    void 자동차_이름에_숫자만_있으면_예외가_발생한다(String content) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
                    CarName carName = new CarName(content);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 숫자로만 구성될 수 없습니다. 최소 1자 이상의 문자를 포함해주세요.");
    }
}
