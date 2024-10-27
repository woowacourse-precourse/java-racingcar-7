package racingcar;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarConverterTest {

    @DisplayName("쉼표(,)를 구분자로 자동차 이름 문자열을 객체 리스트로 변환할 수 있다.")
    @Test
    void toObjects() {

        Assertions.assertSimpleTest(() -> {
            RacingCarConverter converter = new RacingCarConverter();
            List<RacingCar> cars = converter.toObjects("이름1,이름2");
            assertThat(cars).hasSize(2);
            assertThat(cars.get(0).getName()).isEqualTo("이름1");
            assertThat(cars.get(1).getName()).isEqualTo("이름2");
        });
    }
}
