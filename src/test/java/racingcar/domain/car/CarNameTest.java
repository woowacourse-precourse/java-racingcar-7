package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    CarName userCarName;

    @ParameterizedTest
    @ValueSource(strings = {"povi", "minu", "joon", "010"})
    public void 유효한_자동차_이름을_입력하면_예외가_발생하지_않는다(String carName) {
        //given
        userCarName = new CarName(carName);

        //when then
        assertThat(userCarName.getName()).isEqualTo(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"carNameIsLong", "123456"})
    public void 자동차의_이름의_5글자를_초과할_경우_예외가_발생한다(String carName) {
        //given when then
        Assertions.assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "-min", "min-", " min ", ".min", "min.", " ", "   ", "min@car", "car!name", "car#123",
            "longcarname12345"})
    public void 자동차_이름에_유효하지_않은_문자_포함시_예외_발생한다(String carName) {
        //given when then
        Assertions.assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}