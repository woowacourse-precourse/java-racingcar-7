package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 정상적인_입력() {
        List<String> carNames = List.of("good0", "good1");
        Cars cars = new Cars(carNames);

        var carList = cars.getCars();

        assertThat(carList.get(0).getCarName()).isEqualTo("good0");
        assertThat(carList.get(1).getCarName()).isEqualTo("good1");
    }

    @Test
    void 중복되는_자동차_이름이_있다면_예외처리() {
        List<String> carNames = List.of("dup", "dup", "bad");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}