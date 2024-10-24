package racingcar.model.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @DisplayName("이름 예외 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "5자를넘어감", "$%기호"})
    void createInValidName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("정상 이름 생성 테스트")
    @ValueSource(strings = {"phobi", "woni", "bmwM3"})
    void createValidName(String name) {
        Name createdName = new Name(name);
        assertThat(createdName.getCarName()).isEqualTo(name);
    }
}