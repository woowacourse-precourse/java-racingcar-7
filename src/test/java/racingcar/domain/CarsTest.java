package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("한 명의 우승자가 있는 경우")
    @Test
    void findSingleWinner() {
        //given
        Car carA = createCarWithPosition("a", 8);
        Car carB = createCarWithPosition("b", 2);
        Car carC = createCarWithPosition("c", 1);
        Cars cars = new Cars(List.of(carA, carB, carC));
        //when
        List<Car> winners = cars.drawWinner();
        //then
        assertThat(winners)
                .hasSize(1)
                .containsExactly(carA);
    }

    @DisplayName("공동 우승자가 있는 경우")
    @Test
    void findMultipleWinners() {
        //given
        Car carA = createCarWithPosition("a", 3);
        Car carB = createCarWithPosition("b", 3);
        Car carC = createCarWithPosition("c", 1);
        Cars cars = new Cars(List.of(carA, carB, carC));
        //when
        List<Car> winners = cars.drawWinner();
        //then
        assertThat(winners)
                .hasSize(2)
                .containsExactly(carA, carB);
    }

    private Car createCarWithPosition(String name, int position) {
        Car car = new Car(new CarName(name), new CarPosition());
        for (int i = 0; i < position; i++) {
            car.move();
        }
        return car;
    }
}