package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차 이름은 중복으로 입력할 수 없다.")
    @Test
    void 자동차_이름_중복입력_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("준기");
        carNames.add("준기");

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 중복이 아니면 등록이 가능하다.")
    @Test
    void 자동차_등록_테스트1() {
        List<String> carNames = new ArrayList<>();
        carNames.add("준기");
        carNames.add("민기");

        Cars cars = new Cars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @DisplayName("자동차는 101대 이상 등록할 수 없다.")
    @Test
    void 자동차_등록_테스트2() {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            carNames.add(String.valueOf(i));
        }

        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 100대 이하는 등록할 수 있다.")
    @Test
    void 자동차_등록_테스트3() {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            carNames.add(String.valueOf(i));
        }

        Cars cars = new Cars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(100);
    }
}