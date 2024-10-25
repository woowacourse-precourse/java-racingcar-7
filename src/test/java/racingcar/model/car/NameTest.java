package racingcar.model.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(IllegalArgumentException.class, () -> new Name(name));
    }

    @ParameterizedTest
    @DisplayName("정상 이름 생성 테스트")
    @ValueSource(strings = {"phobi", "woni", "bmwM3"})
    void createValidName(String name) {
        Name createdName = new Name(name);
        assertEquals(name, createdName.getCarName());
    }
}
