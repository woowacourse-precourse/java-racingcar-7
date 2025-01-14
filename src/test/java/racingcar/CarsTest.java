package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.FakeGenerator;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"aa,bb,cc", "1,2", "가"})
    @DisplayName("경주 자동차가 콤마로 구분되어 정상적으로 생성되는지 확인한다")
    void carTest1(String carNames) {
        //when
        Cars cars = Cars.from(carNames);
        //that
        Assertions.assertThat(cars.getCars().size()).isEqualTo(carNames.split(",").length);
    }

    @Test
    @DisplayName("자동차 경주가 정상적으로 진행되는지 확인한다")
    void carTest2() {
        //given
        String carNames = "aa,bb,cc";
        Cars cars = Cars.from(carNames);
        //when
        cars.playRacing(new FakeGenerator(100));
        //that
        for (Car car : cars.getCars()) {
            Assertions.assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("자동차 우승자를 정상적으로 찾는지 확인")
    void carTest3() {
        //given
        String carNames = "aa,bb,cc";
        Cars cars = Cars.from(carNames);
        //when
        cars.playRacing(new FakeGenerator(100));
        List<String> winners = cars.findWinners();
        //that
        assertAll(
                () -> assertThat(winners.size()).isEqualTo(carNames.split(",").length),
                () -> assertThat(winners.contains("aa")).isEqualTo(true),
                () -> assertThat(winners.contains("bb")).isEqualTo(true),
                () -> assertThat(winners.contains("cc")).isEqualTo(true)
        );
    }
}
