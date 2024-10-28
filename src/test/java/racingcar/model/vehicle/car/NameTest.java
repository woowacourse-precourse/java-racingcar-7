package racingcar.model.vehicle.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.modle.vehicle.car.Name;

public class NameTest {

    @Test
    @DisplayName("이름 반환 테스트")
    void getNameTest() {
        //given
        Name name = new Name("gamza");
        String expected = "gamza";
        //when
        String actual = name.getName();
        //then
        assertThat(expected).isEqualTo(actual);
    }

    @ParameterizedTest(name = "이름 = {0} 경우")
    @DisplayName("null 값 또는 빈값(\"\") 그리고 공백(\" \") 이름 테스트 ")
    @NullSource
    @ValueSource(strings = {"", " "})
    void NullAndEmptyAndBlankNameTest(String name) {
        //when, then
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름 길이 5자 초과 테스트")
    void nameLengthTest() {
        //given
        String name = "여섯글자다다";
        //when, then
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "이름 = {0} 경우")
    @DisplayName("숫자로 이름 입력 테스트")
    @ValueSource(strings = {"0", "1", "10", "100", "-1", "0.1", "-0.1", "0.01", "-0.01"})
    void numberNameTest(String name) {
        //when, then
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
