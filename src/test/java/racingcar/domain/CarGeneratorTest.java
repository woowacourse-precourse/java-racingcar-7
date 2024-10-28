package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racingcar.domain.CarGenerator.getParticipateCars;

class CarGeneratorTest {
    @Test
    @DisplayName("자동차_이름에_공백이_포함된_경우_공백을_제거한_후_목록 생성")
    void getParticipateCarsTest() {
        String input = " p  ob i ,han i,   su   z i   ";

        List<Car> result = getParticipateCars(input);

        assertThat(result).hasSize(3);

        assertThat(result.get(0).getName()).isEqualTo("pobi");
        assertThat(result.get(1).getName()).isEqualTo("hani");
        assertThat(result.get(2).getName()).isEqualTo("suzi");
    }
}