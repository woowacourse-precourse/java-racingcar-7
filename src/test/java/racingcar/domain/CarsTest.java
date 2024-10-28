package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("숫자의 값이 4이상이면 전진할 수 있다.")
    @Test
    void canMoveIfNumberIsMoreThanThree() {
        //given
        List<Car> initialCars = List.of(
                new Car(new CarName("a"), new CarPosition()),
                new Car(new CarName("b"), new CarPosition()),
                new Car(new CarName("c"), new CarPosition()));
        Cars cars = new Cars(initialCars);
        //when
        cars.move(new FixedNumberGenerator(5,4,3));
        // then
        assertThat(cars.getCars().get(0).getPosition().getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getPosition().getPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(2).getPosition().getPosition()).isEqualTo(0);
    }

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