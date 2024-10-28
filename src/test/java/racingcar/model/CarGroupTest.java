package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    @Test
    @DisplayName("CarGroup 불변 테스트")
    void isImmutableCollections() {
        String[] carNames = new String[]{"a", "b", "c", "d"};
        CarGroup carGroup = new CarGroup(carNames);
        Assertions.assertThatThrownBy(() ->
                carGroup.getCarList().add(
                        new Car("e")
                )
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}