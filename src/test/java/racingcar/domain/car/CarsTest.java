package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("경주할 자동차 이름 - 중복된 이름 입력")
    void duplicatedCarName() {
        //given
        final List<String> names = new ArrayList<>();
        names.add("a");
        names.add("a");
        names.add("c");
        final CarNames carNames = new CarNames(names);

        //when & then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

}