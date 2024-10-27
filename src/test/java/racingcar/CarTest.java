package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validators.CarValidator;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest extends NsTest {

    @Test
    @DisplayName("자동차 이름을 입력 안 했을 때")
    void NAME_WITH_EMPTY_INPUT() {
        Set<String> uniqueNames = new HashSet<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CarValidator.validateCarName("", uniqueNames)
        );
        assert(exception.getMessage().equals("자동차 이름은 비어 있을 수 없습니다."));
    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘겨졌을 때")
    void THE_NAME_IS_LONGER_THEN_FIVE_CHARACTERS() {
        Set<String> uniqueNames = new HashSet<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CarValidator.validateCarName("pobbii", uniqueNames)
        );
        assert(exception.getMessage().equals("자동차 이름은 5글자를 넘을 수 없습니다."));
    }

    @Test
    @DisplayName("자동차 이름이 중복 되었을 때")
    void NAME_OVERLAP() {
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("pobi");

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CarValidator.validateCarName("pobi", uniqueNames)
        );
        assert(exception.getMessage().equals("자동차 이름이 중복 되었습니다 : pobi"));
    }

    @Override
    protected void runMain() {

    }
}
