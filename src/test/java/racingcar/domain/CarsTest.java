package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.global.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.Cars;


class CarsTest {

    @Test
    void 중복된_자동차_이름_예외() {
        assertThatThrownBy(() -> Cars.createCarList("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }
    
    @Test
    void 우승자_결정_테스트() {
        Cars cars = Cars.createCarList("pobi,woni");
        cars.moveCars();

        List<Car> winners = cars.findWinnerCars();

        assertThat(winners).isNotEmpty();
        int topPosition = winners.get(0).getPosition();

        for (Car winner : winners) {
            assertThat(winner.getPosition()).isEqualTo(topPosition);
        }
    }

}
